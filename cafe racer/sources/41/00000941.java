package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbq implements Continuation<String, Task<Boolean>> {
    private final /* synthetic */ ListenerHolder zzdt;
    private final /* synthetic */ RealTimeMultiplayerClient zzdu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder) {
        this.zzdu = realTimeMultiplayerClient;
        this.zzdt = listenerHolder;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Boolean> then(Task<String> task) throws Exception {
        return this.zzdu.doUnregisterEventListener(this.zzdt.getListenerKey());
    }
}