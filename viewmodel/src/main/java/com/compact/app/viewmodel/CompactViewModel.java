package com.compact.app.viewmodel;

import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CompactViewModel extends ViewModel {
    private ReplayRelay<Boolean> loading = ReplayRelay.create();
    private ReplayRelay<Integer> statusCode = ReplayRelay.create();


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
        return disposable -> loading().accept(Boolean.TRUE);
    }

    public <T> Consumer<T> doOnSuccess() {
        return response -> loading().accept(Boolean.FALSE);
    }

    public Consumer<Throwable> doOnError() {
        return throwable -> loading().accept(Boolean.FALSE);
    }
}
