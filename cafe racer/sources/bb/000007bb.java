package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface GamesMetadata {

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LoadGamesResult extends Releasable, Result {
        GameBuffer getGames();
    }

    Game getCurrentGame(GoogleApiClient googleApiClient);

    PendingResult<LoadGamesResult> loadGame(GoogleApiClient googleApiClient);
}