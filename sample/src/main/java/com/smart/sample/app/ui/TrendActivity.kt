package com.smart.sample.app.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.compact.app.CompactActivity
import com.compact.app.extensions.*
import com.smart.sample.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
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

        login_name.loginName().subscribe()
        username.userName().subscribe()
        digits.digits().subscribe()
        phone.phone().subscribe()
        email.email().subscribe()
        password.password().subscribe()
        confirm_password.confirmPassword(password).subscribe()
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.loading().subscribe(::println)
//                viewModel.trendsResource().subscribe({
//                    adapter.swap(it.data())
//                }, {
//                    Log.d("Resource", "error: $it")
//                })
        )
    }
}
