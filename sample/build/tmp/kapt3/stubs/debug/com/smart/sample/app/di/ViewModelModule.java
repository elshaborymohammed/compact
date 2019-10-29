package com.smart.sample.app.di;

import androidx.lifecycle.ViewModel;
import com.compact.app.viewmodel.di.key.ViewModelKey;
import com.compact.app.viewmodel.di.module.ViewModelInjectionModule;
import com.smart.sample.app.trend.TrendViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/smart/sample/app/di/ViewModelModule;", "", "()V", "bindTrendViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/smart/sample/app/trend/TrendViewModel;", "sample_debug"})
@dagger.Module(includes = {com.compact.app.viewmodel.di.module.ViewModelInjectionModule.class})
public abstract class ViewModelModule {
    
    @org.jetbrains.annotations.NotNull()
    @com.compact.app.viewmodel.di.key.ViewModelKey(value = com.smart.sample.app.trend.TrendViewModel.class)
    @dagger.multibindings.IntoMap()
    @dagger.Binds()
    public abstract androidx.lifecycle.ViewModel bindTrendViewModel(@org.jetbrains.annotations.NotNull()
    com.smart.sample.app.trend.TrendViewModel viewModel);
    
    public ViewModelModule() {
        super();
    }
}