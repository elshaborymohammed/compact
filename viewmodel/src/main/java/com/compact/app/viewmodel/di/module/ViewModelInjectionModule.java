package com.compact.app.viewmodel.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.compact.app.viewmodel.CompactViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bind(CompactViewModelProviderFactory factory);
}
