package com.compact.executor;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppExecutors {
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private final Executor diskIO;
    private final Executor networkIO;
    private final Executor mainThread;

    @Inject
    public AppExecutors() {
        this.diskIO = Executors.newSingleThreadExecutor();
        this.networkIO = Executors.newFixedThreadPool(NUMBER_OF_CORES);
        this.mainThread = new MainThreadExecutor();
    }

    @NonNull
    public final Executor diskIO() {
        return this.diskIO;
    }

    @NonNull
    public final Executor networkIO() {
        return this.networkIO;
    }

    @NonNull
    public final Executor mainThread() {
        return this.mainThread;
    }

    private class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        public void execute(@NonNull Runnable runnable) {
            this.mainThreadHandler.post(runnable);
        }
    }
}
