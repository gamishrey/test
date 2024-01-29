package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbd extends zzbm {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ boolean zzkb;
    private final /* synthetic */ int zzkh;
    private final /* synthetic */ int zzki;
    private final /* synthetic */ int zzkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbd(zzba zzbaVar, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        super(googleApiClient, null);
        this.zzbo = str;
        this.zzkh = i;
        this.zzki = i2;
        this.zzkj = i3;
        this.zzkb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zzb(this, this.zzbo, this.zzkh, this.zzki, this.zzkj, this.zzkb);
    }
}