package com.smart.github.app;

import com.compact.app.CompactApplication;

public class App extends CompactApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        com.smart.github.app.di.DaggerAppComponent.builder().application(this).build().inject(this);
    }
}
