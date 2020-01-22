package com.compact.response;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.HttpURLConnection;

/**
 * Created by lshabory on 1/31/2018.
 */

public class Resource<T> {

    @NonNull
    private final Status status;
    @NonNull
    private final int code;
    @Nullable
    private final String message;
    @Nullable
    private final T data;

    private Resource(@NonNull Status status, @NonNull int code, @Nullable String message, @Nullable T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Resource<T> ok(@Nullable String message, @Nullable T data) {
        return new Resource(Status.OK, HttpURLConnection.HTTP_OK, message, data);
    }

    public static <T> Resource<T> created(@Nullable String message) {
        return new Resource(Status.CREATED, HttpURLConnection.HTTP_CREATED, message, null);
    }

    public static <T> Resource<T> accepted(@Nullable String message) {
        return new Resource(Status.ACCEPTED, HttpURLConnection.HTTP_ACCEPTED, message, null);
    }

    public static <T> Resource<T> noContent(@Nullable String message) {
        return new Resource(Status.NO_CONTENT, HttpURLConnection.HTTP_NO_CONTENT, message, null);
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
        OK,
        CREATED,
        ACCEPTED,
        NO_CONTENT,
    }
}