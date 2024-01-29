package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbf extends zzbo {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ long zzbr;
    private final /* synthetic */ String zzbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbf(zzba zzbaVar, GoogleApiClient googleApiClient, String str, long j, String str2) {
        super(googleApiClient);
        this.zzbo = str;
        this.zzbr = j;
        this.zzbs = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zza(this, this.zzbo, this.zzbr, this.zzbs);
    }
}