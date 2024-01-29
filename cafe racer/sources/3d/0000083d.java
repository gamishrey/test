package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzbk<L> extends UnregisterListenerMethod<zzg, L> {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbk(ListenerHolder.ListenerKey<L> listenerKey) {
        super(listenerKey);
    }

    protected abstract void zzb(zzg zzgVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public /* synthetic */ void unregisterListener(zzg zzgVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzb(zzgVar, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}