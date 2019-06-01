package com.smart.github.domain.usecase;

import com.smart.github.domain.model.Trend;
import com.smart.github.domain.protocol.ITrendsProtocol;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TrendsUseCase {

    private final ITrendsProtocol trendsProtocol;

    @Inject
    public TrendsUseCase(ITrendsProtocol trendsProtocol) {
        this.trendsProtocol = trendsProtocol;
    }


    public Single<List<Trend>> buildUseCaseObservable() {
        return this.trendsProtocol.get();
    }
}
