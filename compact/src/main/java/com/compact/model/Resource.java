package com.compact.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by lshabory on 1/31/2018.
 */

public class Resource<T> {

    @NonNull
    private final Status status;
    @NonNull
    private final int code;
    @Nullable
    private final T data;
    @Nullable
    private final String message;

    private Resource(@NonNull Status status, @NonNull int code, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource(Status.LOADING, 000, data, null);
    }

    public static <T> Resource<T> success(@NonNull int code, @Nullable String message, @NonNull T data) {
        return new Resource(Status.SUCCESS, code, data, message);
    }

    public static <T> Resource<T> error(@NonNull int code, @Nullable String message, @Nullable T data) {
        return new Resource(Status.ERROR, code, data, message);
    }

    @NonNull
    public Status status() {
        return status;
    }

    @NonNull
    public int code() {
        return code;
    }

    @Nullable
    public T data() {
        return data;
    }

    @Nullable
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", code=" + code +
                ", body=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING,
    }
}