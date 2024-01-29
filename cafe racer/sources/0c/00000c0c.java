package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzem extends zzel {
    private final zzek zzsv = new zzek();

    @Override // com.google.android.gms.internal.games.zzel
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zzsv.zza(th, true).add(th2);
    }
}