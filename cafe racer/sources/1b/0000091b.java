package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzaf extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ long zzbr;
    private final /* synthetic */ String zzbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(LeaderboardsClient leaderboardsClient, String str, long j, String str2) {
        this.zzbo = str;
        this.zzbr = j;
        this.zzbs = str2;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) null, this.zzbo, this.zzbr, this.zzbs);
    }
}