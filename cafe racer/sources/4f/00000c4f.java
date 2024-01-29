package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbp extends UnregisterListenerMethod<zzx, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(zzbd zzbdVar, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzxVar.stopAdvertising();
        taskCompletionSource.setResult(true);
    }
}