package com.unity.androidnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes.dex */
public class AndroidNotificationCenterExtensionsOreo extends AndroidNotificationCenterExtensions {
    public AndroidNotificationCenterExtensionsOreo(Context context, NotificationManager notificationManager) {
        super(context, notificationManager);
    }

    @Override // com.unity.androidnotifications.AndroidNotificationCenterExtensions
    public boolean areNotificationsEnabled(String str) {
        if (super.areNotificationsEnabled()) {
            NotificationChannel notificationChannel = this.notificationManager.getNotificationChannel(str);
            return notificationChannel == null || notificationChannel.getImportance() != 0;
        }
        return false;
    }
}