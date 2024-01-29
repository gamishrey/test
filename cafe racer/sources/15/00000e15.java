package com.google.games.bridge;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* loaded from: classes.dex */
public class PayloadCallbackProxy extends PayloadCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onPayloadReceived(String str, Payload payload);
    }

    @Override // com.google.android.gms.nearby.connection.PayloadCallback
    public void onPayloadTransferUpdate(String str, PayloadTransferUpdate payloadTransferUpdate) {
    }

    public PayloadCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.nearby.connection.PayloadCallback
    public void onPayloadReceived(String str, Payload payload) {
        this.callback.onPayloadReceived(str, payload);
    }
}