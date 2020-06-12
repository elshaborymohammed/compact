package com.compact.util;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by lshabory on 3/21/2018.
 */

public class DisposableManager {

    private static CompositeDisposable compositeDisposable;

    private DisposableManager() {
    }

    public static void add(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }

    public static void dispose() {
        getCompositeDisposable().dispose();
    }

    public static int size() {
        return getCompositeDisposable().size();
    }

    private static CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }
}