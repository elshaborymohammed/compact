package com.smart.sample.domain.usecase;

import com.smart.sample.domain.protocol.ITrendsProtocol;
import dagger.internal.Factory;
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
public final class TrendsUseCase_Factory implements Factory<TrendsUseCase> {
  private final Provider<ITrendsProtocol> trendsProtocolProvider;

  public TrendsUseCase_Factory(Provider<ITrendsProtocol> trendsProtocolProvider) {
    this.trendsProtocolProvider = trendsProtocolProvider;
  }

  @Override
  public TrendsUseCase get() {
    return newInstance(trendsProtocolProvider.get());
  }

  public static TrendsUseCase_Factory create(Provider<ITrendsProtocol> trendsProtocolProvider) {
    return new TrendsUseCase_Factory(trendsProtocolProvider);
  }

  public static TrendsUseCase newInstance(ITrendsProtocol trendsProtocol) {
    return new TrendsUseCase(trendsProtocol);
  }
}
