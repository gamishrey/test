package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzae extends com.google.android.gms.internal.games.zzar<Intent> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ int zzbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(LeaderboardsClient leaderboardsClient, String str, int i) {
        this.zzbo = str;
        this.zzbp = i;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zza(this.zzbo, this.zzbp, -1));
    }
}