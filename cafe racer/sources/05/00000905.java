package com.google.android.gms.games.stats;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface Stats {

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LoadPlayerStatsResult extends Releasable, Result {
        PlayerStats getPlayerStats();
    }

    PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient googleApiClient, boolean z);
}