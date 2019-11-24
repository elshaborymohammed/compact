package com.smart.sample.app.trend;

import androidx.lifecycle.ViewModelProvider;
import com.compact.app.CompactActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TrendActivity_MembersInjector implements MembersInjector<TrendActivity> {
  private final Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider;

  private final Provider<ViewModelProvider.Factory> factoryProvider;

  public TrendActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<TrendActivity> create(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    return new TrendActivity_MembersInjector(dispatchingAndroidInjectorProvider, factoryProvider);}

  @Override
  public void injectMembers(TrendActivity instance) {
    CompactActivity_MembersInjector.injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
    injectFactory(instance, factoryProvider.get());
  }

  public static void injectFactory(TrendActivity instance, ViewModelProvider.Factory factory) {
    instance.factory = factory;
  }
}
