package com.smart.compact.remote;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

public class ApiException extends Exception {
    private final int code;
    @Nullable
    private final String errorMessage;

    public ApiException(int code, @Nullable String errorMessage) {
        super();
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ApiException(ApiResponse response) {
        this(response.code(), response.error());
    }

    public int code() {
        return code;
    }

    @Nullable
    public <T> T error(Class<T> classOfT) {
        return new Gson().fromJson(errorMessage, classOfT);
    }
}
