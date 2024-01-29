package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzz implements PendingResultUtil.ResultConverter<Leaderboards.SubmitScoreResult, ScoreSubmissionData> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ ScoreSubmissionData convert(Leaderboards.SubmitScoreResult submitScoreResult) {
        Leaderboards.SubmitScoreResult submitScoreResult2 = submitScoreResult;
        if (submitScoreResult2 == null) {
            return null;
        }
        return submitScoreResult2.getScoreData();
    }
}