package com.smart.sample.presentation.ui

import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.Relay
import com.smart.sample.base.helper.MockDataHelper
import com.smart.sample.base.helper.MockDataHelper.fromJson
import com.smart.sample.domain.model.Trend
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class TrendViewModelTest {

    @Mock
    lateinit var viewModel: TrendViewModel

    private val loading: Relay<Boolean> = BehaviorRelay.create()
    private var subscriber = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        Mockito.`when`(viewModel.loading()).thenReturn(loading)
    }

    @Test
    fun data() {
        val mock = setUpSuccess()
        viewModel.data().subscribe(subscriber)
        viewModel.loading().subscribe(loading)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertValue(mock)
    }

    @Test
    fun loading() {
        val test = viewModel.loading().test()
        viewModel.loading().accept(true)
        viewModel.loading().accept(false)

        test.assertSubscribed()
        test.assertValues(true, false)
    }

    @Test
    fun trendsSuccess() {
        val mock = setUpSuccess()
        viewModel.trends().subscribe(subscriber)
        viewModel.loading().subscribe(loading)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertValue(mock)
    }

    @Test
    fun trendsError() {
        val mock = setUpError()
        viewModel.trends().subscribe(subscriber)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertError(mock)
    }

    @Test
    fun completable() {
        val mock = setUpSuccess()
        viewModel.completable().subscribe(subscriber)
        viewModel.loading().subscribe(loading)

        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertValue(mock)
    }

    private fun setUpSuccess(): List<Trend> {
        val response: List<Trend> = fromJson(MockDataHelper.MOCK_DATA_PATH_TRENDS)
        Mockito.`when`(viewModel.trends()).thenReturn(Single.just(response))
        return response
    }

    private fun setUpError(): Throwable {
        val error = IOException()
        Mockito.`when`(viewModel.trends()).thenReturn(Single.error(error))
        return error
    }
}