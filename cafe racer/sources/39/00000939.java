package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbi extends com.google.android.gms.internal.games.zzar<Intent> {
    private final /* synthetic */ int zzdq;
    private final /* synthetic */ int zzdr;
    private final /* synthetic */ boolean zzds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(RealTimeMultiplayerClient realTimeMultiplayerClient, int i, int i2, boolean z) {
        this.zzdq = i;
        this.zzdr = i2;
        this.zzds = z;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zzc(this.zzdq, this.zzdr, this.zzds));
    }
}