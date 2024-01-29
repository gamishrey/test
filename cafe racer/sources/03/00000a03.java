package com.google.android.gms.internal.common;

import android.content.Context;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class zzl {
    private static volatile boolean zzjs = !zzan();
    private static boolean zzjt = false;

    public static boolean zzan() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static Context getDeviceProtectedStorageContext(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }
}