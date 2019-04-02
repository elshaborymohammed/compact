package com.smart.github.ui.trend

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.compact.app.CompactActivity
import com.smart.github.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import javax.inject.Inject

class TrendActivity : CompactActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: TrendViewModel

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate() {
        viewModel = ViewModelProviders.of(this, factory).get(TrendViewModel::class.java)

        var recyclerView = findViewById<RecyclerView>(R.id.list)
        val adapter = TrendAdapter().also {
            recyclerView.adapter = it
        }

        viewModel.get()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { adapter.swap(it) })
    }
}
