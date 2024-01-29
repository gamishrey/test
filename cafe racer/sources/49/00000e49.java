package com.soomla;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

/* loaded from: classes.dex */
public class AndroidBus extends Bus {
    private final Handler mainThread = new Handler(Looper.getMainLooper());

    @Override // com.squareup.otto.Bus
    public void post(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(obj);
        } else {
            this.mainThread.post(new Runnable() { // from class: com.soomla.AndroidBus.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidBus.this.post(obj);
                }
            });
        }
    }

    @Override // com.squareup.otto.Bus
    public void register(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.register(obj);
        } else {
            this.mainThread.post(new Runnable() { // from class: com.soomla.AndroidBus.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidBus.this.register(obj);
                }
            });
        }
    }

    @Override // com.squareup.otto.Bus
    public void unregister(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.unregister(obj);
        } else {
            this.mainThread.post(new Runnable() { // from class: com.soomla.AndroidBus.3
                @Override // java.lang.Runnable
                public void run() {
                    AndroidBus.this.unregister(obj);
                }
            });
        }
    }
}