package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbt extends RegisterListenerMethod<zzx, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbt(zzbd zzbdVar, ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(null);
    }
}