package com.unity.androidnotifications;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AndroidNotificationCenterExtensions {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    protected static AndroidNotificationCenterExtensions extentionsImpl;
    protected Context context;
    protected NotificationManager notificationManager;

    public AndroidNotificationCenterExtensions(Context context, NotificationManager notificationManager) {
        this.context = null;
        this.notificationManager = null;
        this.context = context;
        this.notificationManager = notificationManager;
    }

    public static AndroidNotificationCenterExtensions getExtensionsImpl(Context context, NotificationManager notificationManager) {
        AndroidNotificationCenterExtensions androidNotificationCenterExtensions = extentionsImpl;
        if (androidNotificationCenterExtensions != null) {
            return androidNotificationCenterExtensions;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            extentionsImpl = new AndroidNotificationCenterExtensionsOreo(context, notificationManager);
        } else {
            extentionsImpl = new AndroidNotificationCenterExtensions(context, notificationManager);
        }
        return extentionsImpl;
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.notificationManager.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.context.getSystemService("appops");
            ApplicationInfo applicationInfo = this.context.getApplicationInfo();
            String packageName = this.context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        }
        return true;
    }

    public boolean areNotificationsEnabled(String str) {
        return areNotificationsEnabled();
    }
}