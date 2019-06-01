package com.smart.github.domain.protocol;

import com.smart.github.domain.model.Trend;
import io.reactivex.Single;

import java.util.List;

public interface ITrendsProtocol {
    Single<List<Trend>> get();
}