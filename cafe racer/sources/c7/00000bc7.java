package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbz extends zzcc {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbz(zzbu zzbuVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.zzkb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zza(this, this.zzkb);
    }
}