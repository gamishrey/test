package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbl implements Continuation<Boolean, Task<Void>> {
    final /* synthetic */ String zzdi;
    final /* synthetic */ RoomConfig zzdp;
    final /* synthetic */ ListenerHolder zzdt;
    private final /* synthetic */ RealTimeMultiplayerClient zzdu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbl(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, String str, RoomConfig roomConfig) {
        this.zzdu = realTimeMultiplayerClient;
        this.zzdt = listenerHolder;
        this.zzdi = str;
        this.zzdp = roomConfig;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<Boolean> task) throws Exception {
        return this.zzdu.doRead(new zzbo(this));
    }
}