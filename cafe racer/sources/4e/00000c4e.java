package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzbo extends RegisterListenerMethod<zzx, Object> {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzcn;
    private final /* synthetic */ ListenerHolder zzco;
    private final /* synthetic */ AdvertisingOptions zzcp;
    private final /* synthetic */ zzbd zzcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbo(zzbd zzbdVar, ListenerHolder listenerHolder, String str, String str2, ListenerHolder listenerHolder2, AdvertisingOptions advertisingOptions) {
        super(listenerHolder);
        this.zzcq = zzbdVar;
        this.val$name = str;
        this.zzcn = str2;
        this.zzco = listenerHolder2;
        this.zzcp = advertisingOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzx zzxVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzxVar.zza(new zzby(this.zzcq, taskCompletionSource), this.val$name, this.zzcn, this.zzco, this.zzcp);
    }
}