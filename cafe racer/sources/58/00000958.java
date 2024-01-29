package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcm implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ TurnBasedMatch convert(TurnBasedMultiplayer.UpdateMatchResult updateMatchResult) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.UpdateMatchResult updateMatchResult2 = updateMatchResult;
        if (updateMatchResult2 == null || (match = updateMatchResult2.getMatch()) == null) {
            return null;
        }
        return match.freeze();
    }
}