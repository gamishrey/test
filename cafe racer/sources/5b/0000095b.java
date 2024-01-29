package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcp extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ String zzdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcp(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.zzdn = str;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zzd(this.zzdn, 1);
        taskCompletionSource.setResult(null);
    }
}