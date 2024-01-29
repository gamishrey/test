package com.soomla;

import android.app.Application;
import android.content.Context;
import com.soomla.events.AppToBackgroundEvent;
import java.lang.Thread;

/* loaded from: classes.dex */
public class SoomlaApp extends Application {
    public static Foreground ForegroundService;
    private static Context context;
    protected static SoomlaApp mInstance;
    private Thread.UncaughtExceptionHandler defaultUEH;

    public static SoomlaApp instance() {
        return mInstance;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable unused) {
        }
        ForegroundService = Foreground.init();
        this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.soomla.SoomlaApp.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                BusProvider.getInstance().post(new AppToBackgroundEvent());
                SoomlaApp.this.defaultUEH.uncaughtException(thread, th);
            }
        });
    }

    public static void setExternalContext(Context context2) {
        context = context2;
    }

    public static Context getAppContext() {
        return context;
    }
}