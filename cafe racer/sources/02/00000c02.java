package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzed {
    private Handler zzlf;
    private boolean zzlg;
    private final Object zzle = new Object();
    private HashMap<String, AtomicInteger> zzlh = new HashMap<>();
    private int zzli = 1000;

    public zzed(Looper looper, int i) {
        this.zzlf = new zzeh(looper);
    }

    protected abstract void zzf(String str, int i);

    public final void zzg(String str, int i) {
        synchronized (this.zzle) {
            if (!this.zzlg) {
                this.zzlg = true;
                this.zzlf.postDelayed(new zzeg(this), this.zzli);
            }
            AtomicInteger atomicInteger = this.zzlh.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzlh.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    public final void flush() {
        synchronized (this.zzle) {
            for (Map.Entry<String, AtomicInteger> entry : this.zzlh.entrySet()) {
                zzf(entry.getKey(), entry.getValue().get());
            }
            this.zzlh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcv() {
        synchronized (this.zzle) {
            this.zzlg = false;
            flush();
        }
    }
}