package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class zzah extends zzau<Connections.ConnectionRequestListener> {
    private final /* synthetic */ zzej zzbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzah(zzag zzagVar, zzej zzejVar) {
        super();
        this.zzbn = zzejVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.ConnectionRequestListener) obj).onConnectionRequest(this.zzbn.zzg(), this.zzbn.zzh(), this.zzbn.zzj());
    }
}