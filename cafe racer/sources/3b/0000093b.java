package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbk extends com.google.android.gms.games.internal.zzbk<com.google.android.gms.games.multiplayer.realtime.zzg> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbk
    protected final void zzb(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        taskCompletionSource.setResult(true);
    }
}