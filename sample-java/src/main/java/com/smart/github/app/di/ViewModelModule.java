package com.smart.github.app.di;

import androidx.lifecycle.ViewModel;
import com.compact.app.viewmodel.di.key.ViewModelKey;
import com.compact.app.viewmodel.di.module.ViewModelInjectionModule;
import com.smart.github.app.trend.TrendViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(includes = ViewModelInjectionModule.class)
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TrendViewModel.class)
    abstract ViewModel bindTrendViewModel(TrendViewModel viewModel);
}
