package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* loaded from: classes.dex */
final class zzco extends zzcw {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzcn;
    private final /* synthetic */ AdvertisingOptions zzcp;
    private final /* synthetic */ ListenerHolder zzdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzco(zzca zzcaVar, GoogleApiClient googleApiClient, String str, String str2, ListenerHolder listenerHolder, AdvertisingOptions advertisingOptions) {
        super(googleApiClient, null);
        this.val$name = str;
        this.zzcn = str2;
        this.zzdf = listenerHolder;
        this.zzcp = advertisingOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        zzxVar.zza(this, this.val$name, this.zzcn, this.zzdf, this.zzcp);
    }
}