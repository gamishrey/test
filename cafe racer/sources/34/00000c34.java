package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class zzap extends zzau<Connections.EndpointDiscoveryListener> {
    private final /* synthetic */ zzer zzbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzap(zzao zzaoVar, zzer zzerVar) {
        super();
        this.zzbr = zzerVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((Connections.EndpointDiscoveryListener) obj).onEndpointFound(this.zzbr.zze(), this.zzbr.getServiceId(), this.zzbr.getEndpointName());
    }
}