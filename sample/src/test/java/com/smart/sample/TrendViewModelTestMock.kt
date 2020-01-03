package com.smart.sample

import com.compact.executor.MainThread
import com.compact.executor.WorkerThread
import com.smart.sample.base.BaseTest
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import com.smart.sample.app.ui.TrendViewModel
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TrendViewModelTestMock : BaseTest() {

    @Mock
    private lateinit var mockUseCase: TrendsUseCase
    lateinit var viewModel: TrendViewModel<Any?>
    private val testObserver = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        viewModel = TrendViewModel(mockUseCase, WorkerThread { testScheduler }, MainThread { testScheduler })

        val just: Single<List<Trend>> = Single.wrap { it.onSuccess(mockTrends) }
        Mockito.`when`(mockUseCase.buildUseCaseObservable()).thenReturn(just)
    }

    @After
    override fun tearDown() {
        Mockito.verify(mockUseCase).buildUseCaseObservable()
        testObserver.assertSubscribed()
    }

    @Test
    fun noError() {
        viewModel.get().subscribe(testObserver)
        testObserver.assertNoErrors()
    }

    @Test
    fun value() {
        viewModel.get().subscribe(testObserver)
        testObserver.assertValue(mockTrends.toList())
    }

    companion object {
        private lateinit var mockTrends: ArrayList<Trend>

        @BeforeClass
        @JvmStatic
        fun init() {
            mockTrends = ArrayList()
            for (i in 0 until 5)
                mockTrends.add(Trend(id = i, name = "name $i"))
        }
    }
}