package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzdh implements TurnBasedMultiplayer.CancelMatchResult {
    private final /* synthetic */ Status zzba;
    private final /* synthetic */ zzdi zzlc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(zzdi zzdiVar, Status status) {
        this.zzlc = zzdiVar;
        this.zzba = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzba;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    public final String getMatchId() {
        String str;
        str = this.zzlc.zzft;
        return str;
    }
}