package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzbl<L> extends RegisterListenerMethod<zzg, L> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbl(ListenerHolder<L> listenerHolder) {
        super(listenerHolder);
    }

    protected abstract void zzc(zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public /* synthetic */ void registerListener(zzg zzgVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzc(zzgVar, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}