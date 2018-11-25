package com.smart.compact.remote;


import java.lang.reflect.Type;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 *
 * @param <R>
 */
public class LiveDataCallAdapter<R> implements CallAdapter<R, Single<ApiResponse<R>>> {
    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Single<ApiResponse<R>> adapt(Call<R> call) {
        return new Single<ApiResponse<R>>() {
            @Override
            protected void subscribeActual(SingleObserver<? super ApiResponse<R>> observer) {
                call.enqueue(new Callback<R>() {
                    @Override
                    public void onResponse(Call<R> call, Response<R> response) {
                        if (response.isSuccessful()) {
                            observer.onSuccess(new ApiResponse<>(response));
                        } else {
                            observer.onError(new ApiException(new ApiResponse<>(response)));
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