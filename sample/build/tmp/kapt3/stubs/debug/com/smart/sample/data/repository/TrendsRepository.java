package com.smart.sample.data.repository;

import com.smart.compact.response.Resource;
import com.smart.sample.data.api.RequesterTrendsApi;
import com.smart.sample.domain.model.Trend;
import com.smart.sample.domain.protocol.ITrendsProtocol;
import io.reactivex.Completable;
import io.reactivex.Single;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001a\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r0\tH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/smart/sample/data/repository/TrendsRepository;", "Lcom/smart/sample/domain/protocol/ITrendsProtocol;", "api", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "completable", "Lio/reactivex/Completable;", "get", "Lio/reactivex/Single;", "", "Lcom/smart/sample/domain/model/Trend;", "resource", "Lcom/smart/compact/response/Resource;", "sample_debug"})
public final class TrendsRepository implements com.smart.sample.domain.protocol.ITrendsProtocol {
    private final RequesterTrendsApi api = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable completable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.smart.sample.domain.model.Trend>> get() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.smart.compact.response.Resource<java.util.List<com.smart.sample.domain.model.Trend>>> resource() {
        return null;
    }
    
    public TrendsRepository(@org.jetbrains.annotations.NotNull()
    RequesterTrendsApi api) {
        super();
    }
}