package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcu extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ String zzfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcu(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.zzfa = str;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zzc(this.zzfa);
        taskCompletionSource.setResult(null);
    }
}