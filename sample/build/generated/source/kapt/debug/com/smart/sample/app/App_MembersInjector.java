package com.smart.sample.app;

import com.compact.app.CompactApplication_MembersInjector;
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
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider;

  public App_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<App> create(
      Provider<DispatchingAndroidInjector<Object>> dispatchingAndroidInjectorProvider) {
    return new App_MembersInjector(dispatchingAndroidInjectorProvider);}

  @Override
  public void injectMembers(App instance) {
    CompactApplication_MembersInjector.injectDispatchingAndroidInjector(instance, dispatchingAndroidInjectorProvider.get());
  }
}
