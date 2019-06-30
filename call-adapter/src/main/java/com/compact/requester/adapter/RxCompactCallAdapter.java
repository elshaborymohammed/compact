package com.compact.requester.adapter;


import com.smart.compact.response.ApiException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A Retrofit adapter that converts the Call into a ApiResponse.
 *
 * @param <R>
 */
public class RxCompactCallAdapter<R> implements CallAdapter<R, Single<R>> {
    private final Type responseType;

    public RxCompactCallAdapter(Type responseType) {
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
                            if (response.code() == HttpURLConnection.HTTP_OK) {
                                observer.onSuccess(response.body());
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
        };
    }

    public static class Factory extends CallAdapter.Factory {

        private Factory() {
        }

        public static Factory create() {
            return new Factory();
        }

        @Override
        public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            if (Factory.getRawType(returnType) != Single.class) {
                return null;
            }
            Type bodyType = Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            return new RxCompactCallAdapter<>(bodyType);
        }
    }
}