package com.google.android.gms.games;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzi extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ View zzbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(GamesClient gamesClient, View view) {
        this.zzbb = view;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zza(this.zzbb);
        taskCompletionSource.setResult(null);
    }
}