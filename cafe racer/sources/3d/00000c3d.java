package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzay extends zzau<PayloadCallback> {
    private final /* synthetic */ String zzbm;
    private final /* synthetic */ PayloadTransferUpdate zzbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzay(zzav zzavVar, String str, PayloadTransferUpdate payloadTransferUpdate) {
        super();
        this.zzbm = str;
        this.zzbz = payloadTransferUpdate;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadTransferUpdate(this.zzbm, new PayloadTransferUpdate.Builder(this.zzbz).setStatus(2).build());
    }
}