package com.smart.sample.domain.usecase

import com.smart.sample.base.helper.MockDataHelper
import com.smart.sample.domain.model.Trend
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class TrendsUseCaseTest {

    @Mock
    lateinit var useCase: TrendsUseCase
    private var subscriber = TestObserver<List<Trend>>()

    fun setUp() {}

    fun buildUseCaseObservableSuccess() {
        val response = MockDataHelper.fromJson<List<Trend>>(MockDataHelper.MOCK_DATA_PATH_TRENDS)
        Mockito.`when`(useCase.buildUseCaseObservable()).thenReturn(Single.just(response))

        useCase.buildUseCaseObservable().subscribe(subscriber)
        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertNoErrors()
        subscriber.assertValue(response)
    }


    fun buildUseCaseObservableError() {
        val error = IOException()
        Mockito.`when`(useCase.buildUseCaseObservable()).thenReturn(Single.error(error))

        useCase.buildUseCaseObservable().subscribe(subscriber)
        subscriber.assertSubscribed()
        subscriber.awaitTerminalEvent()
        subscriber.assertError(error)
    }

    fun tearDown() {}
}