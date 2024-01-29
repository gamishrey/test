package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbv extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ Snapshot zzef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbv(SnapshotsClient snapshotsClient, Snapshot snapshot) {
        this.zzef = snapshot;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zza(this.zzef);
        taskCompletionSource.setResult(null);
    }
}