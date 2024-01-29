package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.ParticipantResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzdc extends zzds {
    private final /* synthetic */ String zzfa;
    private final /* synthetic */ byte[] zzkx;
    private final /* synthetic */ ParticipantResult[] zzky;
    private final /* synthetic */ String zzkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdc(zzcv zzcvVar, GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        super(googleApiClient, null);
        this.zzfa = str;
        this.zzkx = bArr;
        this.zzkz = str2;
        this.zzky = participantResultArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(com.google.android.gms.games.internal.zzg zzgVar) throws RemoteException {
        zzgVar.zza(this, this.zzfa, this.zzkx, this.zzkz, this.zzky);
    }
}