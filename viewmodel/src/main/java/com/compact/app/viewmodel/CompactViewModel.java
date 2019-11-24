package com.compact.app.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class CompactViewModel extends ViewModel {

    protected final CompositeDisposable disposable = new CompositeDisposable();
    private ReplayRelay<Boolean> loading = ReplayRelay.create();

    public final Relay<Boolean> loading() {
        return loading;
    }

    protected final void loadingOn() {
        loading.accept(Boolean.TRUE);
    }

    protected final void loadingOff() {
        loading.accept(Boolean.FALSE);
    }

    protected Consumer<Disposable> doOnSubscribe() {
        return disposable -> loadingOn();
    }

    protected <T> Consumer<T> doOnSuccess() {
        return response -> loadingOff();
    }

    protected Consumer<Throwable> doOnError() {
        return throwable -> loading().accept(Boolean.FALSE);
    }

    protected boolean addDisposable(Disposable d) {
        return disposable.add(d);
    }

    protected boolean removeDisposable(Disposable d) {
        return disposable.remove(d);
    }

    protected void dispose() {
        if (!disposable.isDisposed()) {
            disposable.clear();
            disposable.dispose();
        }
    }

    @Override
    protected void onCleared() {
        this.dispose();
        super.onCleared();
    }
}