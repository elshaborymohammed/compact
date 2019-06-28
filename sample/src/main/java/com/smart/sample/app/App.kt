package com.smart.sample

import com.compact.app.CompactApplication

class App : CompactApplication() {

    override fun onCreate() {
        super.onCreate()
        com.smart.sample.di.DaggerAppComponent.builder().application(this).build().inject(this)
    }
}