package com.smart.sample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import com.smart.sample.ui.trend.TrendViewModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject

@RunWith(MockitoJUnitRunner::class)
class TrendViewModelTestMock {
    init {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    // Force tests to be executed synchronously
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockUseCase: TrendsUseCase
    lateinit var viewModel: TrendViewModel
    private val testObserver = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        viewModel = TrendViewModel(mockUseCase)

        val just: Single<List<Trend>> = Single.wrap { it.onSuccess(mockTrends) }
        Mockito.`when`(mockUseCase.buildUseCaseObservable()).thenReturn(just)
    }

    @After
    fun tearDown() {
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
            println("TrendViewModelTestMock.init")
            mockTrends = ArrayList()
            for (i in 0 until 5)
                mockTrends.add(Trend(id = i, name = "name $i"))
        }

        @AfterClass
        @JvmStatic
        fun finalized() {
            println("TrendViewModelTestMock.finalize")
        }
    }
}