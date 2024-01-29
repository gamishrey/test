package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class zzcg extends zzcy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcg(zzca zzcaVar, GoogleApiClient googleApiClient) {
        super(googleApiClient, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        zzxVar.stopAllEndpoints();
    }
}