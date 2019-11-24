package com.smart.sample.app.trend;

import com.compact.executor.RxCompactSchedulers;
import com.smart.sample.domain.usecase.TrendsUseCase;
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
public final class TrendViewModel_Factory implements Factory<TrendViewModel> {
  private final Provider<TrendsUseCase> useCaseProvider;

  private final Provider<RxCompactSchedulers> schedulerProvider;

  public TrendViewModel_Factory(Provider<TrendsUseCase> useCaseProvider,
      Provider<RxCompactSchedulers> schedulerProvider) {
    this.useCaseProvider = useCaseProvider;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public TrendViewModel get() {
    return newInstance(useCaseProvider.get(), schedulerProvider.get());
  }

  public static TrendViewModel_Factory create(Provider<TrendsUseCase> useCaseProvider,
      Provider<RxCompactSchedulers> schedulerProvider) {
    return new TrendViewModel_Factory(useCaseProvider, schedulerProvider);
  }

  public static TrendViewModel newInstance(TrendsUseCase useCase, RxCompactSchedulers scheduler) {
    return new TrendViewModel(useCase, scheduler);
  }
}
