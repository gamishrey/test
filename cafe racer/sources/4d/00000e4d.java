package com.soomla;

/* loaded from: classes.dex */
public final class BusProvider {
    private static final AndroidBus BUS = new AndroidBus();

    public static AndroidBus getInstance() {
        return BUS;
    }

    private BusProvider() {
    }
}