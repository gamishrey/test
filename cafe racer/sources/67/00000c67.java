package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.connection.Payload;

/* loaded from: classes.dex */
final class zzcm extends zzcy {
    private final /* synthetic */ String zzcv;
    private final /* synthetic */ byte[] zzde;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcm(zzca zzcaVar, GoogleApiClient googleApiClient, String str, byte[] bArr) {
        super(googleApiClient, null);
        this.zzcv = str;
        this.zzde = bArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        zzxVar.zza((BaseImplementation.ResultHolder<Status>) this, new String[]{this.zzcv}, Payload.fromBytes(this.zzde), true);
    }
}