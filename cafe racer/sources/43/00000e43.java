package com.google.games.bridge;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public final class Utils {
    private static final String TAG = "Utils";

    private Utils() {
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i) {
        try {
            fragment.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
            Log.e(TAG, "Activity not found. Please install Play Games App.");
        }
    }
}