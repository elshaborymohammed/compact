package com.smart.compact.util;

import android.arch.lifecycle.ViewModel;

import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.ReplayRelay;

public class CompactViewModel extends ViewModel {
    private ReplayRelay<Boolean> loading = ReplayRelay.create();
    private ReplayRelay<Integer> status = ReplayRelay.create();


    public Relay<Boolean> loading() {
        return loading;
    }
}
