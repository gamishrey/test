package com.google.android.gms.internal.games;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzeg implements Runnable {
    private final /* synthetic */ zzed zzlk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeg(zzed zzedVar) {
        this.zzlk = zzedVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzlk.zzcv();
    }
}