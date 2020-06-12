package com.compact.requester.adapter;

import com.compact.response.Resource;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class RxCompactCallAdapterFactory extends CallAdapter.Factory {

    private RxCompactCallAdapterFactory() {
    }

    public static RxCompactCallAdapterFactory create() {
        return new RxCompactCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType = getRawType(returnType);

//        if (rawType == Observable.class) {
//            Type bodyType = getParameterUpperBound(0, (ParameterizedType) returnType);
//
//            if (getRawType(bodyType) == Resource.class) {
//                return new RxCompactCallAdapterObservableResource<>(getParameterUpperBound(0, (ParameterizedType) bodyType));
//            } else {
//                return new RxCompactCallAdapterObservable<>(bodyType);
//            }
//        } else
        if (rawType == Single.class) {
            Type bodyType = getParameterUpperBound(0, (ParameterizedType) returnType);

            if (getRawType(bodyType) == Resource.class) {
                return new RxCompactCallAdapterSingleResource<>(getParameterUpperBound(0, (ParameterizedType) bodyType));
            } else {
                return new RxCompactCallAdapterSingle<>(bodyType);
            }
        } else if (rawType == Completable.class) {
            return new RxCompactCallAdapterCompletable();
        } else {
            return null;
        }
    }
}
