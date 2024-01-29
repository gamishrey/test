package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
final class zzbx extends ConnectionLifecycleCallback {
    private final /* synthetic */ zzbd zzcq;
    private final ConnectionLifecycleCallback zzct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbx(zzbd zzbdVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.zzcq = zzbdVar;
        this.zzct = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.zzcq.zzb(str);
        }
        this.zzct.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.zzcq.zzc(str);
        }
        this.zzct.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.zzcq.zzc(str);
        this.zzct.onDisconnected(str);
    }
}