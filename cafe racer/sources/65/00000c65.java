package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class zzck extends zzcy {
    private final /* synthetic */ String zzcv;
    private final /* synthetic */ byte[] zzdb;
    private final /* synthetic */ ListenerHolder zzdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzck(zzca zzcaVar, GoogleApiClient googleApiClient, String str, byte[] bArr, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zzcv = str;
        this.zzdb = bArr;
        this.zzdd = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        String str = this.zzcv;
        ((zzdu) zzxVar.getService()).zza(new zzo().zza(new zzba(this)).zza(str).zza(this.zzdb).zza(new zzar(this.zzdd)).zzb());
    }
}