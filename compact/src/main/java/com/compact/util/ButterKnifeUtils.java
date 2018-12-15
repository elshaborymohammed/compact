package com.compact.util;

import butterknife.Unbinder;

public class ButterKnifeUtils {

    private ButterKnifeUtils() {

    }

    public static void unbind(Unbinder unbinder) {
        if (unbinder != null) {
            try {
                unbinder.unbind();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}