package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzef {
    private final AtomicReference<zzed> zzlj = new AtomicReference<>();

    protected abstract zzed zzba();

    public final void flush() {
        zzed zzedVar = this.zzlj.get();
        if (zzedVar != null) {
            zzedVar.flush();
        }
    }

    public final void zza(String str, int i) {
        zzed zzedVar = this.zzlj.get();
        if (zzedVar == null) {
            zzedVar = zzba();
            if (!this.zzlj.compareAndSet(null, zzedVar)) {
                zzedVar = this.zzlj.get();
            }
        }
        zzedVar.zzg(str, i);
    }
}