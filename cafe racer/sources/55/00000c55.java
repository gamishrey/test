package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbv extends TaskApiCall<zzx, Void> {
    private final /* synthetic */ zzbd zzcq;
    private final /* synthetic */ zzbw zzcs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbv(zzbd zzbdVar, zzbw zzbwVar) {
        this.zzcq = zzbdVar;
        this.zzcs = zzbwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzx zzxVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zzcs.zza(zzxVar, new zzby(this.zzcq, taskCompletionSource));
    }
}