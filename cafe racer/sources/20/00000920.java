package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzak extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ int zzbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(NotificationsClient notificationsClient, int i) {
        this.zzbv = i;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zzn(this.zzbv);
        taskCompletionSource.setResult(null);
    }
}