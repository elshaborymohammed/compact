package com.smart.sample.app.di

import androidx.lifecycle.ViewModel
import com.compact.app.viewmodel.di.key.ViewModelKey
import com.compact.app.viewmodel.di.module.ViewModelInjectionModule
import com.smart.sample.presentation.ui.TrendViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelInjectionModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TrendViewModel::class)
    abstract fun bindTrendViewModel(viewModel: TrendViewModel): ViewModel
}