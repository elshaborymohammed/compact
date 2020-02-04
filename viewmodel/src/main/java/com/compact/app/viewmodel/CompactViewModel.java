package com.compact.app.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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

    public final <T> ObservableTransformer<T, T> composeLoadingObservable() {
        return upstream -> upstream
                .doOnSubscribe(it -> {
                    subscribe(it);
                    loadingOn();
                })
                .doOnNext(it -> loadingOff())
                .doOnError(it -> loadingOff());
    }

    public final <T> SingleTransformer<T, T> composeLoadingSingle() {
        return upstream -> upstream
                .doOnSubscribe(it -> {
                    subscribe(it);
                    loadingOn();
                })
                .doOnSuccess(it -> loadingOff())
                .doOnError(it -> loadingOff());
    }

    public final CompletableTransformer composeLoadingCompletable() {
        return upstream -> upstream
                .doOnSubscribe(it -> {
                    subscribe(it);
                    loadingOn();
                })
                .doOnComplete(this::loadingOff)
                .doOnError(it -> loadingOff());
    }

    protected boolean subscribe(Disposable d) {
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