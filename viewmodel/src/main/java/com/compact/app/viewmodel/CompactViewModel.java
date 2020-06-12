package com.compact.app.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay3.Relay;
import com.jakewharton.rxrelay3.ReplayRelay;

import io.reactivex.rxjava3.core.CompletableTransformer;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.SingleTransformer;

public abstract class CompactViewModel extends ViewModel {

    private ReplayRelay<Boolean> loading = ReplayRelay.create();

    public final Relay<Boolean> loading() {
        return loading;
    }

    protected void loadingOn() {
        loading.accept(Boolean.TRUE);
    }

    protected void loadingOff() {
        loading.accept(Boolean.FALSE);
    }

    public <T> ObservableTransformer<T, T> composeLoadingObservable() {
        return upstream -> upstream
                .doOnSubscribe(it -> loadingOn())
                .doOnNext(it -> loadingOff())
                .doOnError(it -> loadingOff());
    }

    public <T> SingleTransformer<T, T> composeLoadingSingle() {
        return upstream -> upstream
                .doOnSubscribe(it -> loadingOn())
                .doOnSuccess(it -> loadingOff())
                .doOnError(it -> loadingOff());
    }

    public CompletableTransformer composeLoadingCompletable() {
        return upstream -> upstream
                .doOnSubscribe(it -> loadingOn())
                .doOnComplete(this::loadingOff)
                .doOnError(it -> loadingOff());
    }
}