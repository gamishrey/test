package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
abstract class zzds extends Games.zzb<TurnBasedMultiplayer.UpdateMatchResult> {
    private zzds(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdr(this, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzds(GoogleApiClient googleApiClient, zzcy zzcyVar) {
        this(googleApiClient);
    }
}