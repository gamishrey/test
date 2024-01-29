package com.google.android.gms.internal.games;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzek {
    private final ConcurrentHashMap<zzen, List<Throwable>> zzss = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzst = new ReferenceQueue<>();

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzst.poll();
        while (poll != null) {
            this.zzss.remove(poll);
            poll = this.zzst.poll();
        }
        List<Throwable> list = this.zzss.get(new zzen(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzss.putIfAbsent(new zzen(th, this.zzst), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}