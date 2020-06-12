package com.compact.requester.adapter;

import com.compact.response.ApiException;
import com.compact.response.Resource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A Retrofit adapter that converts the Call into a ApiResponse.
 *
 * @param <R>
 */
final class RxCompactCallAdapterSingleResource<R> implements CallAdapter<R, Single<Resource<R>>> {
    private final Type responseType;

    public RxCompactCallAdapterSingleResource(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Single<Resource<R>> adapt(Call<R> call) {
        return new Single<Resource<R>>() {
            @Override
            protected void subscribeActual(SingleObserver<? super Resource<R>> observer) {
                call(call, observer);
            }
        };
    }

    private void call(Call<R> call, SingleObserver<? super Resource<R>> observer) {
        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    switch (response.code()) {
                        case HttpURLConnection.HTTP_OK:
                            observer.onSuccess(Resource.ok(response.message(), response.body()));
                            break;
                        case HttpURLConnection.HTTP_CREATED:
                            observer.onSuccess(Resource.created(response.message()));
                            break;
                        case HttpURLConnection.HTTP_ACCEPTED:
                            observer.onSuccess(Resource.accepted(response.message()));
                            break;
                        case HttpURLConnection.HTTP_NO_CONTENT:
                            observer.onSuccess(Resource.noContent(response.message()));
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