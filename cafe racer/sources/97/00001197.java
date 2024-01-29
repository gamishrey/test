package com.unity3d.services.store.gpbl.bridges;

/* loaded from: classes.dex */
public class SkuDetailsBridge extends CommonJsonResponseBridge {
    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetails";
    }

    public SkuDetailsBridge(Object obj) {
        super(obj);
    }
}