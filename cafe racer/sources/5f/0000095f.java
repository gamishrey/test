package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.TurnBasedMultiplayerClient;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzct implements com.google.android.gms.games.internal.zzbg<TurnBasedMatch> {
    @Override // com.google.android.gms.games.internal.zzbg
    public final /* synthetic */ ApiException zza(Status status, TurnBasedMatch turnBasedMatch) {
        TurnBasedMatch turnBasedMatch2 = turnBasedMatch;
        if (status.getStatusCode() == 26593) {
            return new TurnBasedMultiplayerClient.MatchOutOfDateApiException(status, turnBasedMatch2);
        }
        return ApiExceptionUtil.fromStatus(status);
    }
}