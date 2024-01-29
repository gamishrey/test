package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzba extends zzea {
    private final BaseImplementation.ResultHolder<Status> zzcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzcb = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdz
    public final void zzc(int i) {
        Status zza;
        zza = zzx.zza(i);
        if (zza.isSuccess()) {
            this.zzcb.setResult(zza);
        } else {
            this.zzcb.setFailedResult(zza);
        }
    }
}