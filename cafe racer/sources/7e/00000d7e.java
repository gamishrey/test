package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.nearby.zzgy;

/* loaded from: classes.dex */
final class zzbr extends zzbv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzah zzahVar) throws RemoteException {
        ((zzs) zzahVar.getService()).zza(new zzh(new zzgy(zzah())));
    }
}