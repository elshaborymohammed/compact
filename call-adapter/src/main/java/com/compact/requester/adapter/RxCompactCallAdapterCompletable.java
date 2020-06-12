package com.compact.requester.adapter;

import com.compact.response.ApiException;

import java.io.IOException;
import java.lang.reflect.Type;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A Retrofit adapter that converts the Call into a ApiResponse.
 *
 * @param
 */
final class RxCompactCallAdapterCompletable implements CallAdapter<Void, Completable> {

    @Override
    public Type responseType() {
        return Object.class;
    }

    @Override
    public Completable adapt(Call<Void> call) {
        return new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver observer) {

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            observer.onComplete();
                        } else {
                            try {
                                observer.onError(new ApiException(response.code(), response.errorBody().string()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable throwable) {
                        observer.onError(throwable);
                    }
                });
            }
        };
    }


}