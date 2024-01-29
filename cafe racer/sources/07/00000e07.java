package com.google.games.bridge;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
public class ConnectionLifecycleCallbackProxy extends ConnectionLifecycleCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

        void onConnectionResult(String str, ConnectionResolution connectionResolution);

        void onDisconnected(String str);
    }

    public ConnectionLifecycleCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        this.callback.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public void onDisconnected(String str) {
        this.callback.onDisconnected(str);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        this.callback.onConnectionInitiated(str, connectionInfo);
    }
}