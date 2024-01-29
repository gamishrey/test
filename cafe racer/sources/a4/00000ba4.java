package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzar<TResult> extends TaskApiCall<com.google.android.gms.games.internal.zzg, TResult> {
    protected abstract void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zza(zzgVar, taskCompletionSource);
        } catch (RemoteException | SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}