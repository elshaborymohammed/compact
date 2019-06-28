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
    // Force tests to be executed synchronously
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var viewModel: TrendViewModel
    private val testObserver = TestObserver<List<Trend>>()

    @Before
    fun setUp() {
        com.smart.sample.di.DaggerTestAppComponent.builder().build().inject(this)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun call() {
        viewModel.get().subscribe(testObserver)
        testObserver.assertSubscribed()
        testObserver.assertNoErrors()
        testObserver.assertSubscribed()
    }

    @Test
    fun real() {
        viewModel.get()
                .subscribe(Consumer { println(it.toString()) })
    }

    @Test
    fun int() {
        Assert.assertEquals(viewModel.int(), 50)
        println("int : ${viewModel.int()}")
    }

    // Test rule for making the RxJava to run synchronously in unit test
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }
}