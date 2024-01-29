package com.rak24.androidimmersivemode;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes.dex */
public class Main {
    static Main _INSTANCE;
    static BroadcastReceiver br;
    public static boolean gamePaused;
    static int lastHeightDiff;
    static Application unityApp;

    public Main() {
        _INSTANCE = this;
    }

    public static Main instance() {
        Main main = _INSTANCE;
        return main == null ? new Main() : main;
    }

    public void EnableImmersiveMode(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            Activity activity = (Activity) context;
            ImmersiveMode(activity.getWindow().getDecorView());
            SetUIChangeListener(activity.getWindow().getDecorView());
            Application application = UnityPlayer.currentActivity.getApplication();
            unityApp = application;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.rak24.androidimmersivemode.Main.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    Main.ImmersiveMode(activity2.getWindow().getDecorView());
                }
            });
        }
    }

    public static void ImmersiveMode(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(7686);
        }
    }

    public static void ImmersiveModeFromCache(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            new Handler().postDelayed(new Runnable() { // from class: com.rak24.androidimmersivemode.Main.2
                @Override // java.lang.Runnable
                public void run() {
                    Main.ImmersiveMode(activity.getWindow().getDecorView());
                }
            }, 700L);
        }
    }

    public static void EnableAppPin(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startLockTask();
        }
    }

    public static void DisableAppPin(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.stopLockTask();
        }
    }

    void SetUIChangeListener(final View view) {
        view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.rak24.androidimmersivemode.Main.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    Main.ImmersiveMode(view);
                }
            }
        });
    }
}