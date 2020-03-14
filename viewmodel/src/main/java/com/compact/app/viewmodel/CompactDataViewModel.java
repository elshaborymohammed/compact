package com.compact.app.viewmodel;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class CompactDataViewModel<T> extends CompactViewModel {

    protected BehaviorRelay<T> data = BehaviorRelay.create();
    protected PublishRelay<Throwable> error = PublishRelay.create();

    public Observable<T> data() {
        if (!data.hasValue()) {
            disposable.add(subscription());
        }
        return data.subscribeOn(subscribeOn()).observeOn(observeOn());
    }

    public Observable<Throwable> error() {
        return error.subscribeOn(subscribeOn()).observeOn(observeOn());
    }

    protected abstract Disposable subscription();

    protected Scheduler subscribeOn() {
        return Schedulers.newThread();
    }

    protected Scheduler observeOn() {
        return AndroidSchedulers.mainThread();
    }

    protected Consumer<T> onSuccess() {
        return it -> data.accept(it);
    }

    protected Consumer<Throwable> onError() {
        return it -> error.accept(it);
    }

    @Override
    protected void onCleared() {
        this.dispose();
        super.onCleared();
    }
}
