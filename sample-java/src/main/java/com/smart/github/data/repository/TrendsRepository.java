package com.smart.github.data.repository;

import com.smart.github.data.api.RequesterTrendsApi;
import com.smart.github.domain.model.Trend;
import com.smart.github.domain.protocol.ITrendsProtocol;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TrendsRepository implements ITrendsProtocol {
    private final RequesterTrendsApi api;

    @Inject
    public TrendsRepository(RequesterTrendsApi api) {
        this.api = api;
    }

    @Override
    public Single<List<Trend>> get() {
        return api.get().map(it -> it.body());
    }
}