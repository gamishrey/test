package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbo extends zzbv {
    private final /* synthetic */ zzbw zzio;
    private final /* synthetic */ SubscribeOptions zzip;
    private final /* synthetic */ PendingIntent zziq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbo(zzbi zzbiVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent, zzbw zzbwVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.zziq = pendingIntent;
        this.zzio = zzbwVar;
        this.zzip = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzah zzahVar) throws RemoteException {
        zzahVar.zza(zzah(), this.zziq, this.zzio, this.zzip);
    }
}