package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;

/* loaded from: classes.dex */
final class zzas extends zzau<Connections.MessageListener> {
    private final /* synthetic */ zzev zzbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzas(zzar zzarVar, zzev zzevVar) {
        super();
        this.zzbu = zzevVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        Payload zza = zzfl.zza(this.zzbu.zzl());
        if (zza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(this.zzbu.zzl().getId())));
        } else if (zza.getType() == 1) {
            messageListener.onMessageReceived(this.zzbu.zzg(), zza.asBytes(), this.zzbu.zzm());
        }
    }
}