package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzh implements Games.GetServerAuthCodeResult {
    private final /* synthetic */ Status zzba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(Games.zzc zzcVar, Status status) {
        this.zzba = status;
    }

    @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
    public final String getCode() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzba;
    }
}