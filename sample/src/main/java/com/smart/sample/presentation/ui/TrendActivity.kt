package com.smart.sample.presentation.ui

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.compact.app.CompactActivity
import com.compact.app.extensions.*
import com.smart.sample.R
import com.smart.sample.databinding.ActivityMainBinding
import com.smart.sample.domain.model.User
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function6
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class TrendActivity : CompactActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: TrendViewModel
    private lateinit var adapter: TrendAdapter
    private lateinit var binding: ActivityMainBinding

    override fun layoutRes(): Int {
        return -1
    }

    override fun onCreate() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(TrendViewModel::class.java)

        var recyclerView = findViewById<RecyclerView>(R.id.list)
        adapter = TrendAdapter().also {
            recyclerView.adapter = it
        }

        val login = login_name.login(0)
        val username = username.username(0)
        val fullName = full_name.fullName(0)
        val digits = digits.digits(0)
        val phone = phone.phone(0)
        val email = email.email(0)

        io.reactivex.Observable.combineLatest(login, username, fullName, digits, phone, email,
                Function6 { b: Boolean, b1: Boolean, b2: Boolean, b3: Boolean, b4: Boolean, b5: Boolean ->
                    println("b = [${b}], b1 = [${b1}], b2 = [${b2}], b3 = [${b3}], b4 = [${b4}], b5 = [${b5}]")
                    b && b1 && b2 && b3 && b4 && b5
                }).subscribe(::println, Throwable::printStackTrace)

        binding.user = User()
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
