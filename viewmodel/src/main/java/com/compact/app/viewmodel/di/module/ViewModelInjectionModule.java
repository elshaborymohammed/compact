package com.compact.app.viewmodel.di.module;

import com.compact.app.viewmodel.CompactViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bind(CompactViewModelProviderFactory factory);
}
