package com.smart.sample

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smart.sample.domain.model.Trend
import com.smart.sample.rule.RxImmediateSchedulerRule
import com.smart.sample.ui.trend.TrendViewModel
import io.reactivex.functions.Consumer
import io.reactivex.observers.TestObserver
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

//@RunWith(RobolectricTestRunner::class)
//@Config(manifest=Config.NONE)
//@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TrendViewModelTest {

    @Inject
    lateinit var viewModel: TrendViewModel
    private val testObserver = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        com.smart.sample.di.DaggerTestAppComponent.builder().build().inject(this)
    }

    @Test
    fun call() {
        viewModel.get().subscribe(testObserver)
        testObserver.awaitTerminalEvent()
        testObserver.assertSubscribed()
        testObserver.assertNoErrors()
        testObserver.assertSubscribed()
    }
}