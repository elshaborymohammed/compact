package com.smart.sample.data.api;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RequesterTrendsApi_Factory implements Factory<RequesterTrendsApi> {
  private final Provider<Retrofit> requestProvider;

  public RequesterTrendsApi_Factory(Provider<Retrofit> requestProvider) {
    this.requestProvider = requestProvider;
  }

  @Override
  public RequesterTrendsApi get() {
    return newInstance(requestProvider.get());
  }

  public static RequesterTrendsApi_Factory create(Provider<Retrofit> requestProvider) {
    return new RequesterTrendsApi_Factory(requestProvider);
  }

  public static RequesterTrendsApi newInstance(Retrofit request) {
    return new RequesterTrendsApi(request);
  }
}
