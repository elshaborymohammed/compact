package com.compact.requester.adapter;

import com.compact.response.ApiException;

import java.io.IOException;
import java.lang.reflect.Type;

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
final class RxCompactCallAdapterSingle<R> implements CallAdapter<R, Single<R>> {
    private final Type responseType;

    public RxCompactCallAdapterSingle(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Single<R> adapt(Call<R> call) {
        return new Single<R>() {
            @Override
            protected void subscribeActual(SingleObserver<? super R> observer) {
                call.enqueue(new Callback<R>() {
                    @Override
                    public void onResponse(Call<R> call, Response<R> response) {
                        if (response.isSuccessful()) {
                            observer.onSuccess(response.body());
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