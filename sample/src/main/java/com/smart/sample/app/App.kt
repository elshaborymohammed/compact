package com.smart.sample.app

import com.compact.app.CompactApplication

class App : CompactApplication() {

    override fun onCreate() {
        super.onCreate()

        com.smart.sample.app.di.DaggerAppComponent.builder().application(this).build().inject(this)
    }
}