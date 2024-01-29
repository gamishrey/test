package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* loaded from: classes.dex */
final class zzcq extends zzcy {
    private final /* synthetic */ String zzcn;
    private final /* synthetic */ DiscoveryOptions zzcr;
    private final /* synthetic */ ListenerHolder zzdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcq(zzca zzcaVar, GoogleApiClient googleApiClient, String str, ListenerHolder listenerHolder, DiscoveryOptions discoveryOptions) {
        super(googleApiClient, null);
        this.zzcn = str;
        this.zzdg = listenerHolder;
        this.zzcr = discoveryOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        zzxVar.zza(this, this.zzcn, this.zzdg, this.zzcr);
    }
}