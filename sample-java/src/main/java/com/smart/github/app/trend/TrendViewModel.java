package com.smart.github.app.trend;

import com.compact.app.viewmodel.CompactViewModel;
import com.smart.github.domain.model.Trend;
import com.smart.github.domain.usecase.TrendsUseCase;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TrendViewModel extends CompactViewModel {

    private final TrendsUseCase useCase;

    @Inject
    public TrendViewModel(TrendsUseCase useCase) {
        this.useCase = useCase;
    }

    public Single<List<Trend>> get() {
        return useCase.buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread());
    }
}
