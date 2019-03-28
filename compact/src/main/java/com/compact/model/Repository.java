package com.compact.model;

import android.content.Context;

import java.net.UnknownHostException;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * Created by lshabory on 1/31/2018.
 */

// ResponseType: Type for the API response
// ResultType: Type for the Resource data
public abstract class Repository<ResponseType, ResultType> {

    private final Flowable<Resource<ResultType>> resource;
    private FlowableEmitter<Resource<ResultType>> emitter;
    private boolean fetching = true;
    private TransitionState transitionState;

    protected Repository() {
        this.resource = Flowable.create(e -> fetch(e), BackpressureStrategy.BUFFER);
    }

    public void fetch(FlowableEmitter<Resource<ResultType>> emitter) {
        this.emitter = emitter;
        loadFromDb()
                .map(resultType -> Resource.loading(resultType))
                .subscribe(resource -> {
                    if (fetching && shouldFetch(resource.data()))
                        fetchFromNetwork();
                    emitter.onNext(resource);
                });
    }

    public final void fetchFromNetwork() {
        try {
            if (isNetworkAvailable()) {
                fetching = false;
                createCall()
                        .subscribe(new SingleObserver<Response<ResponseType>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                if (null != transitionState)
                                    transitionState.onLoading();
                            }

                            @Override
                            public void onSuccess(Response<ResponseType> response) {
                                if (response.code() == 200) {
                                    saveCallResult(mapper(response));
                                    if (null != transitionState) {
                                        transitionState.onSuccess();
                                        transitionState.onComplete();
                                    }
                                } else {
                                    if (null != transitionState) {
                                        transitionState.onError(new Throwable(
                                                onResponseError(Resource.error(response.code(), response.message(), response.errorBody()))
                                        ));
                                        transitionState.onComplete();
                                    }
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                onFetchFailed(e);
                                if (null != transitionState) {
                                    transitionState.onError(e);
                                    transitionState.onComplete();
                                }
                            }
                        });
            } else {
                if (null != transitionState) {
                    transitionState.onError(new UnknownHostException("Network not available"));
                    transitionState.onComplete();
                }
            }
        } catch (Exception e) {
            onFetchFailed(e);
            if (null != transitionState) {
                transitionState.onError(e);
                transitionState.onComplete();
            }
        }
    }

    protected boolean isNetworkAvailable() {
//        ConnectivityManager cm =
//                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        return activeNetwork != null &&
//                activeNetwork.isConnectedOrConnecting();
        return true;
    }

    protected abstract Context getContext();

    @MainThread
    protected boolean shouldFetch(@Nullable ResultType data) {
        return true;
    }

    @NonNull
    @MainThread
    protected abstract Flowable<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Single<Response<ResponseType>> createCall();

    @WorkerThread
    protected abstract void saveCallResult(@NonNull ResultType item);

    @WorkerThread
    protected abstract ResultType mapper(Response<ResponseType> response);

    @MainThread
    protected String onResponseError(Resource resource) {
        return String.format("%s %s", resource.code(), resource.message());
    }

    @MainThread
    protected void onFetchFailed(Throwable throwable) {
    }

    public void emit(@NonNull ResultType item) {
        emitter.onNext(Resource.loading(item));
    }

    public final Flowable<Resource<ResultType>> getResource() {
        return resource;
    }

    public final void subscribe(TransitionState transitionState) {
        this.transitionState = transitionState;
    }

    public interface TransitionState {
        void onLoading();

        void onSuccess();

        void onError(Throwable e);

        void onComplete();
    }
}