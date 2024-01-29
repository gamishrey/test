package com.google.android.gms.games;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzm extends com.google.android.gms.internal.games.zzar<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(GamesClient gamesClient) {
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Bundle> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zzbb());
    }
}