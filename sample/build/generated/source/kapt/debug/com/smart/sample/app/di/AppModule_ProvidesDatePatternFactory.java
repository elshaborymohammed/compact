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
public final class AppModule_ProvidesDatePatternFactory implements Factory<String> {
  private final AppModule module;

  public AppModule_ProvidesDatePatternFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return providesDatePattern(module);
  }

  public static AppModule_ProvidesDatePatternFactory create(AppModule module) {
    return new AppModule_ProvidesDatePatternFactory(module);
  }

  public static String providesDatePattern(AppModule instance) {
    return Preconditions.checkNotNull(instance.providesDatePattern(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
