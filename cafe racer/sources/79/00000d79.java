package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;

/* loaded from: classes.dex */
final class zzbm extends zzbv {
    private final /* synthetic */ Message zzil;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(zzbi zzbiVar, GoogleApiClient googleApiClient, Message message) {
        super(googleApiClient);
        this.zzil = message;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzah zzahVar) throws RemoteException {
        zzahVar.zza(zzah(), zzaf.zza(this.zzil));
    }
}