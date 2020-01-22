package com.compact.requester.adapter;


import com.compact.response.ApiException;
import com.compact.response.ApiResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
public class CompactCallAdapter<R> implements CallAdapter<R, Single<ApiResponse<R>>> {
    private final Type responseType;

    public CompactCallAdapter(Type responseType) {
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
            Type observableType = Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            Class<?> rawObservableType = Factory.getRawType(observableType);
//            if (rawObservableType != ApiResponse.class) {
//                throw new IllegalArgumentException("type must be a resource");
//            }
            if (!(observableType instanceof ParameterizedType)) {
                throw new IllegalArgumentException("resource must be parameterized");
            }
            Type bodyType = Factory.getParameterUpperBound(0, (ParameterizedType) observableType);
            return new CompactCallAdapter<>(bodyType);
        }
    }
}