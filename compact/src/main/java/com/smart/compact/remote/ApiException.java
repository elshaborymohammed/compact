package com.smart.compact.remote;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

public class ApiException extends Exception {
    private final int code;
    @Nullable
    private final String error;

    public ApiException(int code, @Nullable String error) {
        super();
        this.code = code;
        this.error = error;
    }

    public ApiException(ApiResponse response) {
        this(response.code(), response.error());
    }

    public int code() {
        return code;
    }

    @Nullable
    public <T> T error(Class<T> classOfT) {
        return new Gson().fromJson(error, classOfT);
    }
}
