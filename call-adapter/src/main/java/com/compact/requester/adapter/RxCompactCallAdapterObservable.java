package com.compact.requester.adapter;

import com.compact.response.ApiException;

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
final class RxCompactCallAdapterObservable<R> implements CallAdapter<R, Observable<R>> {
    private final Type responseType;

    public RxCompactCallAdapterObservable(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Observable<R> adapt(Call<R> call) {
        return new Observable<R>() {
            @Override
            protected void subscribeActual(Observer<? super R> observer) {
                call.enqueue(new Callback<R>() {
                    @Override
                    public void onResponse(Call<R> call, Response<R> response) {
                        if (response.isSuccessful()) {
                            observer.onNext(response.body());
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
        };
    }
}