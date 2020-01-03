package com.smart.sample

import com.smart.sample.domain.model.Trend
import com.smart.sample.app.ui.TrendViewModel
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

//@RunWith(RobolectricTestRunner::class)
//@Config(manifest=Config.NONE)
//@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TrendViewModelTest {

    @Inject
    lateinit var viewModel: TrendViewModel<Any?>
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