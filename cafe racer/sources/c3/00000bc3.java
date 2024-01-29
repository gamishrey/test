package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbv extends zzcc {
    private final /* synthetic */ boolean zzkb;
    private final /* synthetic */ int zzkn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbv(zzbu zzbuVar, GoogleApiClient googleApiClient, int i, boolean z) {
        super(googleApiClient);
        this.zzkn = i;
        this.zzkb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zza((BaseImplementation.ResultHolder<Players.LoadPlayersResult>) this, this.zzkn, false, this.zzkb);
    }
}