package com.compact.app.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CompactViewModelProviderFactory_Factory
    implements Factory<CompactViewModelProviderFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider;

  public CompactViewModelProviderFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    this.creatorsProvider = creatorsProvider;
  }

  @Override
  public CompactViewModelProviderFactory get() {
    return new CompactViewModelProviderFactory(creatorsProvider.get());
  }

  public static CompactViewModelProviderFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    return new CompactViewModelProviderFactory_Factory(creatorsProvider);
  }

  public static CompactViewModelProviderFactory newInstance(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
    return new CompactViewModelProviderFactory(creators);
  }
}
