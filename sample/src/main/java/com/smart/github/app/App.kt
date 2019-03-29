package com.smart.github

import com.compact.app.kotlin.CompactApplication

class App : CompactApplication() {

    override fun onCreate() {
        super.onCreate()
        com.smart.github.di.DaggerAppComponent.create().inject(this)
    }
}