package com.smart.sample.app.trend;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public abstract class ResponseObserver<T> implements SingleObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }


    @Override
    public void onError(Throwable e) {

    }
}
