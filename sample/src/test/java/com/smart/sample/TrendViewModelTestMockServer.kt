package com.smart.sample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import com.smart.compact.response.ApiException
import com.smart.sample.domain.model.Trend
import com.smart.sample.ui.trend.TrendViewModel
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

class TrendViewModelTestMockServer {

    // Force tests to be executed synchronously
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
//    @Rule
//    @JvmField
//    val schedulers = RxImmediateSchedulerRule()

//    // Test rule for making the RxJava to run synchronously in unit test
//    companion object {
//
//    }

    @Inject
    lateinit var viewModel: TrendViewModel
    @Inject
    lateinit var mockServer: MockWebServer

    private lateinit var mockTrends: ArrayList<Trend>
    private var subscriber = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        com.smart.sample.di.DaggerTestAppComponent.builder().build().inject(this)

        mockTrends = ArrayList()
        mockTrends.add(Trend(id = 1, name = "name 1"))
        mockTrends.add(Trend(id = 2, name = "name 2"))
        mockTrends.add(Trend(id = 3, name = "name 3"))
        mockTrends.add(Trend(id = 4, name = "name 4"))
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun success() {
        mockServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(mockTrends)))
        viewModel.get().subscribe(subscriber)

        subscriber.awaitTerminalEvent()
        subscriber.assertSubscribed()
        subscriber.assertNoErrors()
        subscriber.assertSubscribed()
        subscriber.assertValueAt(0) {
            it[0] == mockTrends[0]
        }
        subscriber.assertValue {
            it.forEach { obj ->
                println("TrendViewModelTestMockServer.call : $obj")
            }
            true
        }
    }

    @Test
    fun error() {
        mockServer.enqueue(MockResponse().setResponseCode(400).setBody(Gson().toJson(mockTrends)))
        viewModel.get().subscribe(subscriber)

        subscriber.awaitTerminalEvent()
        subscriber.assertError(ApiException::class.java)
    }
}