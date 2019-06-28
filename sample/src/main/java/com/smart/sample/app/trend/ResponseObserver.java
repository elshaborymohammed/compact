package com.smart.sample.app.trend;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleObserveOn;
import retrofit2.Response;

public abstract class ResponseObserver<T> implements SingleObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }


    @Override
    public void onError(Throwable e) {

    }
}
