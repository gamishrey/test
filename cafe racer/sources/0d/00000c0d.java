package com.google.android.gms.internal.games;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzen extends WeakReference<Throwable> {
    private final int zzsw;

    public zzen(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzsw = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zzsw;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzen zzenVar = (zzen) obj;
            if (this.zzsw == zzenVar.zzsw && get() == zzenVar.get()) {
                return true;
            }
        }
        return false;
    }
}