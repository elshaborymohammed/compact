package com.smart.sample.app.trend;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.compact.app.CompactActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrendActivity_MembersInjector implements MembersInjector<TrendActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<ViewModelProvider.Factory> factoryProvider;

  public TrendActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<TrendActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    return new TrendActivity_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, factoryProvider);
  }

  @Override
  public void injectMembers(TrendActivity instance) {
    CompactActivity_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectFactory(instance, factoryProvider.get());
  }

  public static void injectFactory(TrendActivity instance, ViewModelProvider.Factory factory) {
    instance.factory = factory;
  }
}
