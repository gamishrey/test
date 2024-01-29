package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzab extends com.google.android.gms.internal.games.zzar<Intent> {
    private final /* synthetic */ String zzbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(LeaderboardsClient leaderboardsClient, String str) {
        this.zzbo = str;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zza(this.zzbo, -1, -1));
    }
}