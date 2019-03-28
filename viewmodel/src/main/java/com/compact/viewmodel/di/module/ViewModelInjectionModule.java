package com.compact.viewmodel.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.compact.viewmodel.CompactViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bind(CompactViewModelProviderFactory factory);
}
