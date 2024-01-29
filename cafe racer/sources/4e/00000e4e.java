package com.soomla;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.soomla.events.AppToBackgroundEvent;
import com.soomla.events.AppToForegroundEvent;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Foreground {
    public static final String TAG = "SOOMLA " + Foreground.class.getName();
    private static Foreground instance;
    public boolean OutsideOperation = false;
    boolean isChangingOrientation = false;

    public abstract boolean isBackground();

    public abstract boolean isForeground();

    public static Foreground init() {
        if (instance == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                instance = new ForegroundNew();
            } else {
                instance = new ForegroundOld();
                SoomlaUtils.LogDebug(TAG, "Tried to instantiate ForegroundOld");
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ForegroundOld extends Foreground {
        private ForegroundOld() {
        }

        @Override // com.soomla.Foreground
        public boolean isForeground() {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) SoomlaApp.getAppContext().getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = SoomlaApp.getAppContext().getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.soomla.Foreground
        public boolean isBackground() {
            return !isForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ForegroundNew extends Foreground implements Application.ActivityLifecycleCallbacks {
        private int count = 0;
        private int refs = 0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public ForegroundNew() {
            SoomlaApp.instance().registerActivityLifecycleCallbacks(this);
        }

        @Override // com.soomla.Foreground
        public boolean isForeground() {
            return this.refs > 0;
        }

        @Override // com.soomla.Foreground
        public boolean isBackground() {
            return this.refs == 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.count++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity.getLocalClassName().equals("com.unity3d.player.UnityPlayerProxyActivity")) {
                return;
            }
            int i = this.refs + 1;
            this.refs = i;
            if (i == 1 && !this.isChangingOrientation) {
                BusProvider.getInstance().post(new AppToForegroundEvent());
                SoomlaUtils.LogDebug(TAG, "became foreground");
                return;
            }
            SoomlaUtils.LogDebug(TAG, "still foreground");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            this.isChangingOrientation = activity.isChangingConfigurations();
            if (activity.getLocalClassName().equals("com.unity3d.player.UnityPlayerProxyActivity")) {
                return;
            }
            int i = this.refs - 1;
            this.refs = i;
            if (i == 0 && !this.isChangingOrientation) {
                BusProvider.getInstance().post(new AppToBackgroundEvent());
                SoomlaUtils.LogDebug(TAG, "became background");
                return;
            }
            SoomlaUtils.LogDebug(TAG, "still foreground");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            int i = this.count - 1;
            this.count = i;
            if (i == 0 && isForeground()) {
                SoomlaUtils.LogDebug(TAG, "destroyed weirdly");
                BusProvider.getInstance().post(new AppToBackgroundEvent());
            }
        }
    }
}