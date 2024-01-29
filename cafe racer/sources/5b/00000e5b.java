package com.soomla;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes.dex */
public class SoomlaMarketUtils {
    private static final String AMAZON_INSTALLER = "com.amazon.venezia";
    private static final String ANDROID_INSTALLER = "com.android.vending";
    private static String TAG = "SOOMLA SoomlaStoreDetector";

    public static void openMarketAppPage(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        String marketAppPageUrl = getMarketAppPageUrl(context);
        if (marketAppPageUrl == null) {
            SoomlaUtils.LogError(TAG, "no valid market app page url found!");
            return;
        }
        intent.setData(Uri.parse(marketAppPageUrl));
        context.startActivity(intent);
    }

    public static String getMarketAppPageUrl(Context context) {
        String packageName = context.getPackageName();
        if (isInstalledFromGooglePlay(context)) {
            return String.format("market://details?id=%s", packageName);
        }
        if (isInstalledFromAmazonStore(context)) {
            return String.format("amzn://apps/android?p=%s", packageName);
        }
        return null;
    }

    public static boolean isInstalledFromGooglePlay(Context context) {
        return isPackageInstaller(context, "com.android.vending");
    }

    public static boolean isInstalledFromAmazonStore(Context context) {
        return isPackageInstaller(context, AMAZON_INSTALLER);
    }

    public static boolean isPackageInstaller(Context context, String str) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null && installerPackageName.equals(str);
    }

    public static boolean hasAmazonClasses() {
        synchronized (SoomlaUtils.class) {
            SoomlaUtils.class.getClassLoader().loadClass("com.amazon.android.Kiwi");
        }
        return true;
    }
}