package com.unity3d.services.store.gpbl.proxies;

import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import com.unity3d.services.store.listeners.IPurchaseHistoryResponseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PurchaseHistoryResponseListenerProxy extends GenericListenerProxy {
    private static final String onPurchaseHistoryResponseMethodName = "onPurchaseHistoryResponse";
    private int _maxPurchases;
    private IPurchaseHistoryResponseListener _purchaseUpdatedResponseListener;

    public PurchaseHistoryResponseListenerProxy(IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener, int i) {
        this._purchaseUpdatedResponseListener = iPurchaseHistoryResponseListener;
        this._maxPurchases = i;
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy
    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.PurchaseHistoryResponseListener");
    }

    @Override // com.unity3d.services.core.reflection.GenericListenerProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals(onPurchaseHistoryResponseMethodName)) {
            onPurchaseHistoryResponse(objArr[0], (List) objArr[1]);
            return null;
        }
        return super.invoke(obj, method, objArr);
    }

    public void onPurchaseHistoryResponse(Object obj, List<Object> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < this._maxPurchases && i < list.size(); i++) {
                arrayList.add(new PurchaseHistoryRecordBridge(list.get(i)));
            }
        } else {
            arrayList = null;
        }
        IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener = this._purchaseUpdatedResponseListener;
        if (iPurchaseHistoryResponseListener != null) {
            iPurchaseHistoryResponseListener.onBillingResponse(new BillingResultBridge(obj), arrayList);
        }
    }
}