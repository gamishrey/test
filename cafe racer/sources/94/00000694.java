package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class DeviceProperties {
    private static Boolean zzhb;
    private static Boolean zzhc;
    private static Boolean zzhd;
    private static Boolean zzhe;
    private static Boolean zzhf;
    private static Boolean zzhg;
    private static Boolean zzhh;
    private static Boolean zzhi;
    private static Boolean zzhj;

    private DeviceProperties() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (com.google.android.gms.common.util.DeviceProperties.zzhc.booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isTablet(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.zzhb
            if (r1 != 0) goto L45
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            if (r1 != 0) goto L3e
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.zzhc
            if (r1 != 0) goto L36
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L2f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.common.util.DeviceProperties.zzhc = r4
        L36:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.zzhc
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3f
        L3e:
            r0 = 1
        L3f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzhb = r4
        L45:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.zzhb
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    public static boolean isWearable(Context context) {
        if (zzhd == null) {
            zzhd = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzhd.booleanValue();
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context)) {
            if (PlatformVersion.isAtLeastN()) {
                return zzf(context) && !PlatformVersion.isAtLeastO();
            }
            return true;
        }
        return false;
    }

    public static boolean isSidewinder(Context context) {
        return zzf(context);
    }

    private static boolean zzf(Context context) {
        if (zzhe == null) {
            zzhe = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzhe.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        if (zzhf == null) {
            PackageManager packageManager = context.getPackageManager();
            zzhf = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return zzhf.booleanValue();
    }

    public static boolean zzg(Context context) {
        if (zzhg == null) {
            zzhg = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzhg.booleanValue();
    }

    public static boolean isFeaturePhone(Context context) {
        if (zzhj == null) {
            zzhj = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.featurephone"));
        }
        return zzhj.booleanValue();
    }

    public static boolean isAuto(Context context) {
        if (zzhh == null) {
            zzhh = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return zzhh.booleanValue();
    }

    public static boolean isTv(Context context) {
        if (zzhi == null) {
            PackageManager packageManager = context.getPackageManager();
            zzhi = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return zzhi.booleanValue();
    }

    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }
}