package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzx implements PendingResultUtil.ResultConverter<Leaderboards.LoadPlayerScoreResult, LeaderboardScore> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ LeaderboardScore convert(Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult) {
        LeaderboardScore score;
        Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult2 = loadPlayerScoreResult;
        if (loadPlayerScoreResult2 == null || (score = loadPlayerScoreResult2.getScore()) == null) {
            return null;
        }
        return score.freeze();
    }
}