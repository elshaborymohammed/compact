package com.smart.sample.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smart.sample.rule.RxImmediateSchedulerRule
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.TestScheduler
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import javax.inject.Inject
import kotlin.test.AfterTest

open abstract class BaseTest {
//    init {
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler { AndroidSchedulers.mainThread() }
//    }

//    /** Force tests to be executed synchronously */
//    @Rule
//    @JvmField
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//    /** Test rule for making the RxJava to run synchronously in unit test */
//    @get:Rule
//    val schedulers = RxImmediateSchedulerRule()

    @Inject
    lateinit var mockServer: MockWebServer

    var testScheduler: Scheduler = TestScheduler()

//    companion object {
//    /** Test rule for making the RxJava to run synchronously in unit test */
//        @ClassRule
//        @JvmField
//        val schedulers = RxImmediateSchedulerRule()
//    }


    @After
    open fun tearDown() {
        mockServer.shutdown()
    }
}