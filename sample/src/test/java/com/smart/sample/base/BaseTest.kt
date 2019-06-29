package com.smart.sample.base

import com.smart.sample.testutils.TestUtils
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import java.io.File
import javax.inject.Inject

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


    open fun mockHttpResponse(responseCode: Int, fileName: String) = mockServer.enqueue(
            MockResponse()
                    .setResponseCode(responseCode)
                    .setBody(TestUtils.loadJson(fileName)))

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    @After
    open fun tearDown() {
        mockServer.shutdown()
    }
}