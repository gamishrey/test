package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class zzy extends ResultReceiver {
    final /* synthetic */ PriceChangeConfirmationListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(BillingClientImpl billingClientImpl, Handler handler, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        super(handler);
        this.zza = priceChangeConfirmationListener;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(i);
        newBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zza.zzh(bundle, "BillingClient"));
        this.zza.onPriceChangeConfirmationResult(newBuilder.build());
    }
}