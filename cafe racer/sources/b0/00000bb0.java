package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbc extends zzbi {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbc(zzba zzbaVar, GoogleApiClient googleApiClient, String str, boolean z) {
        super(googleApiClient, null);
        this.zzbo = str;
        this.zzkb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zzb(this, this.zzbo, this.zzkb);
    }
}