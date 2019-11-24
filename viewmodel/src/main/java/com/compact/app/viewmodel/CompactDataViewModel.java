package com.compact.app.viewmodel;

import com.jakewharton.rxrelay2.BehaviorRelay;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class CompactDataViewModel<T> extends CompactViewModel {

    protected BehaviorRelay<T> data = BehaviorRelay.create();

    public Observable<T> data() {
        if (!data.hasValue()) {
            call();
        }
        return data.subscribeOn(subscribeOn()).observeOn(observeOn());
    }

    protected Scheduler subscribeOn() {
        return Schedulers.newThread();
    }

    protected Scheduler observeOn() {
        return AndroidSchedulers.mainThread();
    }

    protected abstract void call();

    protected Consumer<T> onSuccess() {
        return it -> data.accept(it);
    }

    protected Consumer<Throwable> onError() {
        return it -> data.error(it);
    }

    @Override
    protected void onCleared() {
        this.dispose();
        super.onCleared();
    }
}
