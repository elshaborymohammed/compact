package com.compact.requester.adapter;

import com.smart.compact.response.Resource;

import io.reactivex.SingleObserver;

public abstract class SingleResourceObserver<T> implements SingleObserver<Resource<T>> {

    @Override
    public void onSuccess(Resource<T> t) {
        switch (t.status()) {
            case OK:
                onOK(t.data());
                break;
            case CREATED:
                onCreated(t.message());
                break;
            case ACCEPTED:
                onAccepted(t.message());
                break;
            case NO_CONTENT:
                onNoContent(t.message());
                break;
            default:
                onError(new Throwable("cannot recognize data..."));
                break;
        }
    }

    public abstract void onOK(T t);

    public abstract void onCreated(String message);

    public abstract void onAccepted(String message);

    public abstract void onNoContent(String message);
}
