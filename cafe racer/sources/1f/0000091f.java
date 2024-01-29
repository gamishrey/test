package com.google.android.gms.games;

import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzaj implements com.google.android.gms.games.internal.zzbj<Leaderboards.LeaderboardMetadataResult> {
    @Override // com.google.android.gms.games.internal.zzbj
    public final /* synthetic */ void zza(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult2 = leaderboardMetadataResult;
        if (leaderboardMetadataResult2.getLeaderboards() != null) {
            leaderboardMetadataResult2.getLeaderboards().release();
        }
    }
}