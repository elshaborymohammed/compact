package com.smart.compact.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.smart.compact.CompactViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bind(CompactViewModelFactory factory);
}
