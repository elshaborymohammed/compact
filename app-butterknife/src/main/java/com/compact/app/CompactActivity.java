package com.compact.app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.compact.utils.ButterKnifeUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactActivity extends AppCompatActivity implements HasAndroidInjector {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private final CompositeDisposable disposable = new CompositeDisposable();
    private Unbinder unbinder;

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (layoutRes() > -1)
            setContentView(layoutRes());
        unbinder = ButterKnife.bind(this);
        onCreate();
        disposable.addAll(subscriptions());
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void onCreate();

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    protected void subscribe(Disposable d) {
        disposable.add(d);
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        disposable.clear();
        ButterKnifeUtils.unbind(unbinder);
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}