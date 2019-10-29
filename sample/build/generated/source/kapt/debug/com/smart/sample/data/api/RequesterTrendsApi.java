package com.smart.sample.data.api;

import com.smart.sample.domain.model.Trend;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Singleton
public final class RequesterTrendsApi {
  private final Retrofit request;

  @Inject
  RequesterTrendsApi(Retrofit request) {
    this.request = request;
  }

  public final Single<List<Trend>> get() {
    return request.create(TrendsApi.class).get();
  }

  public final Completable completable() {
    return request.create(TrendsApi.class).completable();
  }
}
