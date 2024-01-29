package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzad extends com.google.android.gms.internal.games.zzar<Intent> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ int zzbp;
    private final /* synthetic */ int zzbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(LeaderboardsClient leaderboardsClient, String str, int i, int i2) {
        this.zzbo = str;
        this.zzbp = i;
        this.zzbq = i2;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zza(this.zzbo, this.zzbp, this.zzbq));
    }
}