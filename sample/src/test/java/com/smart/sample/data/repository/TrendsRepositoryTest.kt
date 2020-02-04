package com.smart.sample.data.repository

import com.compact.response.ApiException
import com.smart.sample.base.CompactTest
import com.smart.sample.base.di.TestAppComponent
import com.smart.sample.base.helper.MockDataHelper
import com.smart.sample.data.api.RequesterTrendsApi
import com.smart.sample.domain.model.Trend
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject
import javax.net.ssl.HttpsURLConnection

@RunWith(MockitoJUnitRunner::class)
class TrendsRepositoryTest : CompactTest() {

    @Inject
    lateinit var api: RequesterTrendsApi

    private lateinit var repository: TrendsRepository
    private var subscriber = TestObserver<List<Trend>>()
    private lateinit var mocks: List<Trend>

    override fun inject(testAppComponent: TestAppComponent) {
        testAppComponent.inject(this)
    }

    @Before
    fun setUp() {
        mocks = MockDataHelper.fromJson(MockDataHelper.MOCK_DATA_PATH_TRENDS)
    }

    @Test
    fun trendsSuccess() {
        mockHttpResponse(HttpsURLConnection.HTTP_OK, MockDataHelper.MOCK_DATA_PATH_TRENDS)
        repository = TrendsRepository(api)
        repository.get()
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribe(subscriber)

        subscriber.awaitTerminalEvent()
        subscriber.assertSubscribed()
        subscriber.assertNoErrors()
        subscriber.assertValuesOnly(mocks)
    }

    @Test
    fun trendsError() {
        mockHttpResponse(HttpsURLConnection.HTTP_BAD_REQUEST, MockDataHelper.MOCK_DATA_PATH_TRENDS)
        repository = TrendsRepository(api)
        repository.get()
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribe(subscriber)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertError(ApiException::class.java)
    }
}