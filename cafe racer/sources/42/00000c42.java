package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbc extends zzed {
    private final BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> zzcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbc(BaseImplementation.ResultHolder<Connections.StartAdvertisingResult> resultHolder) {
        this.zzcb = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzec
    public final void zza(zzez zzezVar) {
        Status zza;
        zza = zzx.zza(zzezVar.getStatusCode());
        if (zza.isSuccess()) {
            this.zzcb.setResult(new zzbb(zza, zzezVar.getLocalEndpointName()));
        } else {
            this.zzcb.setFailedResult(zza);
        }
    }
}