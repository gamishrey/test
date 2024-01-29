package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbq extends RegisterListenerMethod<zzx, EndpointDiscoveryCallback> {
    private final /* synthetic */ String zzcn;
    private final /* synthetic */ ListenerHolder zzco;
    private final /* synthetic */ zzbd zzcq;
    private final /* synthetic */ DiscoveryOptions zzcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbq(zzbd zzbdVar, ListenerHolder listenerHolder, String str, ListenerHolder listenerHolder2, DiscoveryOptions discoveryOptions) {
        super(listenerHolder);
        this.zzcq = zzbdVar;
        this.zzcn = str;
        this.zzco = listenerHolder2;
        this.zzcr = discoveryOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzxVar.zza(new zzby(this.zzcq, taskCompletionSource), this.zzcn, this.zzco, this.zzcr);
    }
}