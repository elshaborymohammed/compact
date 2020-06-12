package com.smart.sample.presentation.ui

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.compact.app.CompactActivity
import com.compact.app.extensions.*
import com.compact.binding.annotation.AndroidBinding
import com.smart.sample.R
import com.smart.sample.domain.model.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function6
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidBinding
class TrendActivity : CompactActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: TrendViewModel
    private lateinit var adapter: TrendAdapter
    private lateinit var binding: com.smart.sample.databinding.ActivityMainBinding

    override fun layoutRes(): Int {
        return -1
    }

    override fun onCreate() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(TrendViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        adapter = TrendAdapter().also {
            recyclerView.adapter = it
        }

        val login = login_name.login(1, 0)
        val username = username.username(1, 0)
        val fullName = full_name.fullName(1, 0)
        val digits = digits.digits(1, 0)
        val phone = phone.phone(1, 0)
        val email = email.email(1, 0)

        Observable.combineLatest(login, username, fullName, digits, phone, email,
                Function6 { b: Boolean, b1: Boolean, b2: Boolean, b3: Boolean, b4: Boolean, b5: Boolean ->
                    b && b1 && b2 && b3 && b4 && b5
                }).subscribe(submit::setEnabled, Throwable::printStackTrace)
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                viewModel.loading().subscribe(::println),
                Observable.just(true).delay(3000, TimeUnit.MILLISECONDS).subscribe { binding.user = User() },
                viewModel.trends().subscribe({
                    adapter.swap(it)
                }, {
                    Log.e("Resource", "Api Error", it);
                })
        )
    }
}
