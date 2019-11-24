package com.smart.sample.data.module;

import com.smart.sample.data.api.RequesterTrendsApi;
import com.smart.sample.domain.protocol.ITrendsProtocol;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ProtocolModule_ProvidesTrendsProtocolFactory implements Factory<ITrendsProtocol> {
  private final ProtocolModule module;

  private final Provider<RequesterTrendsApi> apiProvider;

  public ProtocolModule_ProvidesTrendsProtocolFactory(ProtocolModule module,
      Provider<RequesterTrendsApi> apiProvider) {
    this.module = module;
    this.apiProvider = apiProvider;
  }

  @Override
  public ITrendsProtocol get() {
    return providesTrendsProtocol(module, apiProvider.get());
  }

  public static ProtocolModule_ProvidesTrendsProtocolFactory create(ProtocolModule module,
      Provider<RequesterTrendsApi> apiProvider) {
    return new ProtocolModule_ProvidesTrendsProtocolFactory(module, apiProvider);
  }

  public static ITrendsProtocol providesTrendsProtocol(ProtocolModule instance,
      RequesterTrendsApi api) {
    return Preconditions.checkNotNull(instance.providesTrendsProtocol(api), "Cannot return null from a non-@Nullable @Provides method");
  }
}
