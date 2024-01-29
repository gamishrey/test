package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbb extends TaskApiCall<zzah, Void> {
    private final /* synthetic */ zzak zzia;
    private final /* synthetic */ zzbd zzif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(zzak zzakVar, zzbd zzbdVar) {
        this.zzia = zzakVar;
        this.zzif = zzbdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzah zzahVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ListenerHolder<BaseImplementation.ResultHolder<Status>> zza;
        zzbd zzbdVar = this.zzif;
        zza = this.zzia.zza((TaskCompletionSource) taskCompletionSource);
        zzbdVar.zza(zzahVar, zza);
    }
}