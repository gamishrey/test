package com.google.android.gms.games.leaderboard;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface Leaderboards {

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LeaderboardMetadataResult extends Releasable, Result {
        LeaderboardBuffer getLeaderboards();
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LoadPlayerScoreResult extends Result {
        LeaderboardScore getScore();
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LoadScoresResult extends Releasable, Result {
        Leaderboard getLeaderboard();

        LeaderboardScoreBuffer getScores();
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface SubmitScoreResult extends Releasable, Result {
        ScoreSubmissionData getScoreData();
    }

    Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient);

    Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str);

    Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i);

    Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i, int i2);

    PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, String str, int i, int i2);

    PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, String str, boolean z);

    PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, boolean z);

    PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2);

    PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3);

    PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z);

    PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3);

    PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z);

    void submitScore(GoogleApiClient googleApiClient, String str, long j);

    void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2);

    PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j);

    PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j, String str2);
}