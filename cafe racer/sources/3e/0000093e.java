package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbn implements ListenerHolder.Notifier<com.google.android.gms.games.multiplayer.realtime.zzg> {
    private final /* synthetic */ zzbo zzdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbo zzboVar) {
        this.zzdv = zzboVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        this.zzdv.zzdw.zzdp.getRoomUpdateCallback().onLeftRoom(0, this.zzdv.zzdw.zzdi);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(com.google.android.gms.games.multiplayer.realtime.zzg zzgVar) {
        zzgVar.onLeftRoom(0, this.zzdv.zzdw.zzdi);
    }
}