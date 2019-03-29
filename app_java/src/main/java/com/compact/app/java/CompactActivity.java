package com.compact.app.java;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.compact.app.java.util.ButterKnifeUtils;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private final CompositeDisposable disposable = new CompositeDisposable();
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
//    private Unbinder unbinder;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (layoutRes() > -1)
            setContentView(layoutRes());
//        unbinder = ButterKnife.bind(this);
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
//        ButterKnifeUtils.unbind(unbinder);
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}