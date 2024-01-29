package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbj extends com.google.android.gms.games.internal.zzbl<com.google.android.gms.games.multiplayer.realtime.zzg> {
    private final /* synthetic */ ListenerHolder zzbg;
    private final /* synthetic */ RoomConfig zzdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbj(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2, RoomConfig roomConfig) {
        super(listenerHolder);
        this.zzbg = listenerHolder2;
        this.zzdp = roomConfig;
    }

    @Override // com.google.android.gms.games.internal.zzbl
    protected final void zzc(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        ListenerHolder<? extends RoomUpdateListener> listenerHolder = this.zzbg;
        zzgVar.zzc(listenerHolder, listenerHolder, listenerHolder, this.zzdp);
        taskCompletionSource.setResult(null);
    }
}