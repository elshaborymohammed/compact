package com.compact.requester.adapter;


import com.compact.response.ApiException;
import com.compact.response.Resource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A Retrofit adapter that converts the Call into a ApiResponse.
 *
 * @param <R>
 */
final class RxCompactCallAdapterObservableResource<R> implements CallAdapter<R, Observable<Resource<R>>> {
    private final Type responseType;

    public RxCompactCallAdapterObservableResource(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Observable<Resource<R>> adapt(Call<R> call) {
        return new Observable<Resource<R>>() {
            @Override
            protected void subscribeActual(Observer<? super Resource<R>> observer) {
                call(call, observer);
            }
        };
    }

    private void call(Call<R> call, Observer<? super Resource<R>> observer) {
        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    switch (response.code()) {
                        case HttpURLConnection.HTTP_OK:
                            observer.onNext(Resource.ok(response.message(), response.body()));
                            break;
                        case HttpURLConnection.HTTP_CREATED:
                            observer.onNext(Resource.created(response.message()));
                            break;
                        case HttpURLConnection.HTTP_ACCEPTED:
                            observer.onNext(Resource.accepted(response.message()));
                            break;
                        case HttpURLConnection.HTTP_NO_CONTENT:
                            observer.onNext(Resource.noContent(response.message()));
                            break;
                        default:
                            observer.onError(new Throwable("Response succeeded but can't Recognize status...."));
                            break;
                    }
                } else {
                    try {
                        observer.onError(new ApiException(response.code(), response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<R> call, Throwable throwable) {
                observer.onError(throwable);
            }
        });
    }
}