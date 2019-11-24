package com.smart.sample.app.trend

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.compact.app.CompactActivity
import com.smart.sample.R
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class TrendActivity : CompactActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: TrendViewModel
    private lateinit var adapter: TrendAdapter

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate() {
        viewModel = ViewModelProviders.of(this, factory).get(TrendViewModel::class.java)

        var recyclerView = findViewById<RecyclerView>(R.id.list)
        adapter = TrendAdapter().also {
            recyclerView.adapter = it
        }
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.loading().subscribe { },
                viewModel.trendsResource().subscribe({
                    adapter.swap(it.data())
                }, {
                    Log.d("Resource", "error: $it")
                })
        )
    }
}
