package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbn extends zzbv {
    private final /* synthetic */ ListenerHolder zzco;
    private final /* synthetic */ zzbw zzio;
    private final /* synthetic */ SubscribeOptions zzip;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbn(zzbi zzbiVar, GoogleApiClient googleApiClient, ListenerHolder listenerHolder, zzbw zzbwVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.zzco = listenerHolder;
        this.zzio = zzbwVar;
        this.zzip = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzah zzahVar) throws RemoteException {
        zzahVar.zza(zzah(), this.zzco, this.zzio, this.zzip, (byte[]) null);
    }
}