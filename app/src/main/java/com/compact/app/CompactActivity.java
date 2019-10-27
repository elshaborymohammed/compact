package com.compact.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import java.io.IOException;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (layoutRes() > -1)
            setContentView(layoutRes());
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
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    protected Consumer<Throwable> onError() {
        return it -> {
            it.printStackTrace();
//            if (it instanceof ApiException) {
//                Toast.makeText(this, "Error in server.....", Toast.LENGTH_LONG).show();
//            } else if (it instanceof IOException) {
//                Toast.makeText(this, getString(R.string.connection_lost), Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(this, getString(R.string.unknown_error), Toast.LENGTH_LONG).show();
//            }
        };
    }
}