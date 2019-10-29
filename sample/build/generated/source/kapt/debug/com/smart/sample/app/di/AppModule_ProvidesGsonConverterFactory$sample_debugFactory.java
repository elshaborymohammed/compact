package com.smart.sample.app.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Converter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidesGsonConverterFactory$sample_debugFactory
    implements Factory<Converter.Factory> {
  private final AppModule module;

  private final Provider<Gson> gsonProvider;

  public AppModule_ProvidesGsonConverterFactory$sample_debugFactory(
      AppModule module, Provider<Gson> gsonProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Converter.Factory get() {
    return providesGsonConverterFactory$sample_debug(module, gsonProvider.get());
  }

  public static AppModule_ProvidesGsonConverterFactory$sample_debugFactory create(
      AppModule module, Provider<Gson> gsonProvider) {
    return new AppModule_ProvidesGsonConverterFactory$sample_debugFactory(module, gsonProvider);
  }

  public static Converter.Factory providesGsonConverterFactory$sample_debug(
      AppModule instance, Gson gson) {
    return Preconditions.checkNotNull(
        instance.providesGsonConverterFactory$sample_debug(gson),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
