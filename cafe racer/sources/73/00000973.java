package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzo extends com.google.android.gms.internal.games.zzar<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(GamesClient gamesClient) {
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Integer> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Integer.valueOf(zzgVar.zzbv()));
    }
}