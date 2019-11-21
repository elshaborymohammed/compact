package com.smart.sample.domain.usecase;

import com.smart.compact.response.Resource;
import com.smart.sample.domain.model.Trend;
import com.smart.sample.domain.protocol.ITrendsProtocol;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n0\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smart/sample/domain/usecase/TrendsUseCase;", "", "trendsProtocol", "Lcom/smart/sample/domain/protocol/ITrendsProtocol;", "(Lcom/smart/sample/domain/protocol/ITrendsProtocol;)V", "buildUseCaseObservable", "Lio/reactivex/Single;", "", "Lcom/smart/sample/domain/model/Trend;", "buildUseCaseObservableResource", "Lcom/smart/compact/response/Resource;", "completable", "Lio/reactivex/Completable;", "sample_debug"})
@javax.inject.Singleton()
public final class TrendsUseCase {
    private final com.smart.sample.domain.protocol.ITrendsProtocol trendsProtocol = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.smart.sample.domain.model.Trend>> buildUseCaseObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.smart.compact.response.Resource<java.util.List<com.smart.sample.domain.model.Trend>>> buildUseCaseObservableResource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Completable completable() {
        return null;
    }
    
    @javax.inject.Inject()
    public TrendsUseCase(@org.jetbrains.annotations.NotNull()
    com.smart.sample.domain.protocol.ITrendsProtocol trendsProtocol) {
        super();
    }
}