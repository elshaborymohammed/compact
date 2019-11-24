package com.smart.sample

import com.google.gson.reflect.TypeToken
import com.smart.compact.response.ApiException
import com.smart.sample.base.BaseTest
import com.smart.sample.domain.model.Trend
import com.smart.sample.testutils.TestUtils
import com.smart.sample.app.trend.TrendViewModel
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection
import javax.inject.Inject

class TrendViewModelTestMockServer : BaseTest() {

    @Inject
    lateinit var viewModel: TrendViewModel<Any?>

    private lateinit var mockTrends: List<Trend>
    private lateinit var mockTrend: Trend
    private var subscriber = TestObserver<List<Trend>>()
    private var loading = TestObserver<Boolean>()

    @Before
    fun setUp() {
        com.smart.sample.di.DaggerTestAppComponent.builder().build().inject(this)

        val listType = object : TypeToken<List<Trend>>() {

        }.type
        mockTrends = TestUtils.loadJson("mock/trends.json", listType)

        mockTrend = TestUtils.loadJson("mock/trend.json", Trend::class.java)
    }

    @Test
    fun success() {
        mockHttpResponse(HttpURLConnection.HTTP_OK, "mock/trends.json")
        viewModel.get().subscribe(subscriber)
        viewModel.loading().subscribe(loading)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertSubscribed()
        subscriber.assertValue(mockTrends)

        loading.assertValues(true, false)
    }

    @Test
    fun badRequest() {
        mockServer.enqueue(MockResponse().setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST))
        viewModel.get().subscribe(subscriber)

        subscriber.awaitTerminalEvent()
        subscriber.assertError(ApiException::class.java)
    }

    @Test
    fun unauthorized() {
        mockServer.enqueue(MockResponse().setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED))
        viewModel.get().subscribe(subscriber)

        subscriber.awaitTerminalEvent()
        subscriber.assertError(ApiException::class.java)
    }
}