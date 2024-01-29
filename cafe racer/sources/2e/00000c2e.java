package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class zzaj extends zzau<Connections.ConnectionResponseCallback> {
    private final /* synthetic */ zzel zzbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(zzai zzaiVar, zzel zzelVar) {
        super();
        this.zzbp = zzelVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        Status zza;
        String zzg = this.zzbp.zzg();
        zza = zzx.zza(this.zzbp.getStatusCode());
        ((Connections.ConnectionResponseCallback) obj).onConnectionResponse(zzg, zza, this.zzbp.zzj());
    }
}