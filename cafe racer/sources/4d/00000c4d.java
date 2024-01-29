package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbn extends TaskApiCall<zzx, Void> {
    private final /* synthetic */ zzbz zzcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbd zzbdVar, zzbz zzbzVar) {
        this.zzcm = zzbzVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzx zzxVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zzcm.zzb(zzxVar);
        taskCompletionSource.setResult(null);
    }
}