package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzav extends zzdx {
    private final ListenerHolder<PayloadCallback> zzbv;
    private final Map<zzaz, PayloadTransferUpdate> zzbw = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(ListenerHolder<PayloadCallback> listenerHolder) {
        this.zzbv = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void shutdown() {
        for (Map.Entry<zzaz, PayloadTransferUpdate> entry : this.zzbw.entrySet()) {
            this.zzbv.notifyListener(new zzay(this, entry.getKey().zze(), entry.getValue()));
        }
        this.zzbw.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final synchronized void zza(zzev zzevVar) {
        Payload zza = zzfl.zza(zzevVar.zzl());
        if (zza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzevVar.zzl().getId())));
            return;
        }
        this.zzbw.put(new zzaz(zzevVar.zzg(), zzevVar.zzl().getId()), new PayloadTransferUpdate.Builder().setPayloadId(zzevVar.zzl().getId()).build());
        this.zzbv.notifyListener(new zzaw(this, zzevVar, zza));
    }

    @Override // com.google.android.gms.internal.nearby.zzdw
    public final synchronized void zza(zzex zzexVar) {
        if (zzexVar.zzn().getStatus() == 3) {
            this.zzbw.put(new zzaz(zzexVar.zzg(), zzexVar.zzn().getPayloadId()), zzexVar.zzn());
        } else {
            this.zzbw.remove(new zzaz(zzexVar.zzg(), zzexVar.zzn().getPayloadId()));
        }
        this.zzbv.notifyListener(new zzax(this, zzexVar));
    }
}