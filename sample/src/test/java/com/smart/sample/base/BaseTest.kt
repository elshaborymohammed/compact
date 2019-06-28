package com.smart.sample.base

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import org.junit.Before
import kotlin.test.AfterTest

open abstract class BaseTest {
    init {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { AndroidSchedulers.mainThread() }
    }

    @Before
    fun init() {
        com.smart.sample.di.DaggerTestAppComponent.builder().build().inject(inject())
        println("BaseTest.setUp")
    }

    abstract fun inject(): BaseTest
}