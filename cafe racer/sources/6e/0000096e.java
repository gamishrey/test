package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzj extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ int zzbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(GamesClient gamesClient, int i) {
        this.zzbc = i;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zzm(this.zzbc);
        taskCompletionSource.setResult(null);
    }
}