package com.compact.app.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class CompactViewModel<T> extends ViewModel {
    protected final CompositeDisposable disposable = new CompositeDisposable();
    private ReplayRelay<Boolean> loading = ReplayRelay.create();

    protected BehaviorRelay<T> data = BehaviorRelay.create();

    public Observable<T> data() {
        if (!data.hasValue()) {
            call();
        }
        return data.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    protected void call() {
    }

    public final Relay<Boolean> loading() {
        return loading;
    }

    protected final void loadingOn() {
        loading.accept(Boolean.TRUE);
    }

    protected final void loadingOff() {
        loading.accept(Boolean.FALSE);
    }

    public Consumer<Disposable> doOnSubscribe() {
        return disposable -> loadingOn();
    }

    public Consumer<T> doOnSuccess() {
        return response -> {
            loadingOff();
            data.accept(response);
        };
    }

    public Consumer<Throwable> doOnError() {
        return throwable -> loading().accept(Boolean.FALSE);
    }

    @Override
    protected void onCleared() {
        if (!disposable.isDisposed()) {
            disposable.clear();
            disposable.dispose();
        }
        super.onCleared();
    }
}
