package net.codestage.actk.androidnative;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ACTkAndroidRoutines {
    public static long GetSystemCurrentTimeMs() {
        return System.currentTimeMillis();
    }

    public static long GetSystemNanoTimeMs() {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public static long GetSystemNanoTime() {
        return System.nanoTime();
    }
}