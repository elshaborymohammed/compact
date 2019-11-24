package com.smart.sample.app.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.CallAdapter;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesCompactCallAdapterFactoryFactory implements Factory<CallAdapter.Factory> {
  private final AppModule module;

  public AppModule_ProvidesCompactCallAdapterFactoryFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public CallAdapter.Factory get() {
    return providesCompactCallAdapterFactory(module);
  }

  public static AppModule_ProvidesCompactCallAdapterFactoryFactory create(AppModule module) {
    return new AppModule_ProvidesCompactCallAdapterFactoryFactory(module);
  }

  public static CallAdapter.Factory providesCompactCallAdapterFactory(AppModule instance) {
    return Preconditions.checkNotNull(instance.providesCompactCallAdapterFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
