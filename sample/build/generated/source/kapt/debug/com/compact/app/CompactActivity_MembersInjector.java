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
public final class CompactActivity_MembersInjector implements MembersInjector<CompactActivity> {
  private final Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider;

  public CompactActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<CompactActivity> create(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    return new CompactActivity_MembersInjector(dispatchingAndroidInjectorProvider);}

  @Override
  public void injectMembers(CompactActivity instance) {
    injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
  }

  public static void injectDispatchingAndroidInjector(CompactActivity instance,
      DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
    instance.dispatchingAndroidInjector = dispatchingAndroidInjector;
  }
}
