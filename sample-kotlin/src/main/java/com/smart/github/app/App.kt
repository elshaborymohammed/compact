package com.smart.github

import com.compact.app.CompactApplication

class App : CompactApplication() {

    override fun onCreate() {
        super.onCreate()
        com.smart.github.di.DaggerAppComponent.builder().application(this).build().inject(this)
    }
}