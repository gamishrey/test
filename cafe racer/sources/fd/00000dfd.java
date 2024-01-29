package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
class AllLeaderboardsUiRequest extends SimpleUiRequest {
    private static final String TAG = "AllLeaderboardsUiRequest";

    @Override // com.google.games.bridge.SimpleUiRequest
    protected Task<Intent> getIntent(Activity activity) {
        return Games.getLeaderboardsClient(activity, HelperFragment.getAccount(activity)).getAllLeaderboardsIntent();
    }
}