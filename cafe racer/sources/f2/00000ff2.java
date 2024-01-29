package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.metrics.ISDKMetrics;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationSingleThreadedExecutor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class AdModule<T extends IWebViewSharedObject, T2> extends WebViewBridgeSharedObjectStore<T> implements IAdModule<T, T2> {
    protected ExecutorService _executorService = WebViewBridgeInvocationSingleThreadedExecutor.getInstance().getExecutorService();
    protected ISDKMetrics _sdkMetrics;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdModule(ISDKMetrics iSDKMetrics) {
        this._sdkMetrics = iSDKMetrics;
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public ISDKMetrics getMetricSender() {
        return this._sdkMetrics;
    }
}