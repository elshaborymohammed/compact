package com.smart.sample.app.trend;

import com.compact.executor.MainThread;
import com.compact.executor.WorkerThread;
import com.smart.sample.domain.usecase.TrendsUseCase;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TrendViewModel_Factory implements Factory<TrendViewModel> {
  private final Provider<TrendsUseCase> useCaseProvider;

  private final Provider<WorkerThread> subscribeOnProvider;

  private final Provider<MainThread> observeOnProvider;

  public TrendViewModel_Factory(
      Provider<TrendsUseCase> useCaseProvider,
      Provider<WorkerThread> subscribeOnProvider,
      Provider<MainThread> observeOnProvider) {
    this.useCaseProvider = useCaseProvider;
    this.subscribeOnProvider = subscribeOnProvider;
    this.observeOnProvider = observeOnProvider;
  }

  @Override
  public TrendViewModel get() {
    return new TrendViewModel(
        useCaseProvider.get(), subscribeOnProvider.get(), observeOnProvider.get());
  }

  public static TrendViewModel_Factory create(
      Provider<TrendsUseCase> useCaseProvider,
      Provider<WorkerThread> subscribeOnProvider,
      Provider<MainThread> observeOnProvider) {
    return new TrendViewModel_Factory(useCaseProvider, subscribeOnProvider, observeOnProvider);
  }

  public static TrendViewModel newInstance(
      TrendsUseCase useCase, WorkerThread subscribeOn, MainThread observeOn) {
    return new TrendViewModel(useCase, subscribeOn, observeOn);
  }
}
