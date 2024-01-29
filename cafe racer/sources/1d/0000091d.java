package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzah implements PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, Leaderboard> {
    private static Leaderboard zza(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        if (leaderboardMetadataResult == null) {
            return null;
        }
        LeaderboardBuffer leaderboards = leaderboardMetadataResult.getLeaderboards();
        if (leaderboards != null) {
            try {
                if (leaderboards.getCount() > 0) {
                    return leaderboards.get(0).freeze();
                }
            } finally {
                if (leaderboards != null) {
                    leaderboards.release();
                }
            }
        }
        if (leaderboards != null) {
            leaderboards.release();
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Leaderboard convert(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        return zza(leaderboardMetadataResult);
    }
}