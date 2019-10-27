package com.compact.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class CompactViewModel<T> extends ViewModel {
    protected final CompositeDisposable disposable = new CompositeDisposable();
    private ReplayRelay<Boolean> loading = ReplayRelay.create();
    protected MutableLiveData<T> liveData = new MutableLiveData();

    public LiveData<T> data() {
        if (null == liveData.getValue()) {
            disposable.addAll(subscriptions());
        }
        return liveData;
    }

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    protected Disposable[] subscription() {
        return new Disposable[0];
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
            liveData.postValue(response);
        };
    }

    public Consumer<T> doOnNext() {
        return response -> {
            loadingOff();
            liveData.postValue(response);
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
