package net.codestage.actk.androidnative;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class NativeUtils {
    static String LogTag = "ACTk";
    private static Context applicationContext;
    private static final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    NativeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] ^ 144) & 255;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String GetApkPath() throws PackageManager.NameNotFoundException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        GetUnityPlayerActivityIfNeeded();
        Context context = applicationContext;
        if (context == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get Unity context!");
            return null;
        }
        String packageName = context.getPackageName();
        if (packageName == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get package name!");
            return null;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        if (packageManager == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get package manager!");
            return null;
        }
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
        if (applicationInfo == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get ApplicationInfo!");
            return null;
        }
        return applicationInfo.publicSourceDir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ContainsIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    private static void GetUnityPlayerActivityIfNeeded() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (applicationContext != null) {
            return;
        }
        Class<?> cls = Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
        if (cls == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer class!");
            return;
        }
        Field declaredField = cls.getDeclaredField("currentActivity");
        if (declaredField == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get com.unity3d.player.UnityPlayer:currentActivity field!");
            return;
        }
        Activity activity = (Activity) declaredField.get(null);
        if (activity == null) {
            Log.e(LogTag, "[CodeHashGenerator ERROR] Couldn't get Activity from com.unity3d.player.UnityPlayer:currentActivity field!");
        } else {
            applicationContext = activity.getApplicationContext();
        }
    }
}