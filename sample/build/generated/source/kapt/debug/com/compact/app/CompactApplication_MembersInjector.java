package com.compact.app;

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
public final class CompactApplication_MembersInjector implements MembersInjector<CompactApplication> {
  private final Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider;

  public CompactApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<CompactApplication> create(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    return new CompactApplication_MembersInjector(dispatchingAndroidInjectorProvider);}

  @Override
  public void injectMembers(CompactApplication instance) {
    injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
  }

  public static void injectDispatchingAndroidInjector(CompactApplication instance,
      DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
    instance.dispatchingAndroidInjector = dispatchingAndroidInjector;
  }
}
