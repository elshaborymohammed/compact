package com.smart.compact;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.smart.compact.util.ButterKnifeUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private Unbinder unbinder;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        if (layoutRes() > -1)
            setContentView(layoutRes());
        unbinder = ButterKnife.bind(this);
        onCreate();
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void onCreate();

    @Override
    protected void onDestroy() {
        ButterKnifeUtils.unbind(unbinder);
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}