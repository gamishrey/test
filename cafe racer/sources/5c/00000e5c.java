package com.soomla;

import android.provider.Settings;
import android.util.Log;

/* loaded from: classes.dex */
public class SoomlaUtils {
    private static String TAG = "SOOMLA SoomlaUtils";

    public static void LogDebug(String str, String str2) {
        if (SoomlaConfig.logDebug) {
            Log.d(str, str2);
        }
    }

    public static void LogWarning(String str, String str2) {
        Log.w(str, str2);
    }

    public static void LogError(String str, String str2) {
        Log.e(str, str2);
    }

    public static String deviceId() {
        String string = Settings.Secure.getString(SoomlaApp.getAppContext().getContentResolver(), "android_id");
        if (string == null) {
            LogError("SOOMLA ObscuredSharedPreferences", "Couldn't fetch ANDROID_ID. Using fake id.");
            return "SOOMFAKE";
        }
        return string;
    }

    public static String getClassName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}