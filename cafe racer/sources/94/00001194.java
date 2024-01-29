package com.unity3d.services.store.gpbl.bridges;

/* loaded from: classes.dex */
public class PurchaseHistoryRecordBridge extends CommonJsonResponseBridge {
    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.PurchaseHistoryRecord";
    }

    public PurchaseHistoryRecordBridge(Object obj) {
        super(obj);
    }
}