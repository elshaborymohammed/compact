package com.smart.sample.app.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesEndpointFactory implements Factory<String> {
  private final AppModule module;

  public AppModule_ProvidesEndpointFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return providesEndpoint(module);
  }

  public static AppModule_ProvidesEndpointFactory create(AppModule module) {
    return new AppModule_ProvidesEndpointFactory(module);
  }

  public static String providesEndpoint(AppModule instance) {
    return Preconditions.checkNotNull(instance.providesEndpoint(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
