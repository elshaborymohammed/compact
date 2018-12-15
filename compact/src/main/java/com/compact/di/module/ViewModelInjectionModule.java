package com.compact.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.compact.CompactViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bind(CompactViewModelFactory factory);
}
