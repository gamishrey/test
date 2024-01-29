package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
class LeaderboardUiRequest extends SimpleUiRequest {
    private static final String TAG = "AllLeaderboardsUiRequest";
    private final String leaderboardId;
    private final int timeSpan;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeaderboardUiRequest(String str, int i) {
        this.leaderboardId = str;
        this.timeSpan = i;
    }

    @Override // com.google.games.bridge.SimpleUiRequest
    protected Task<Intent> getIntent(Activity activity) {
        return Games.getLeaderboardsClient(activity, HelperFragment.getAccount(activity)).getLeaderboardIntent(this.leaderboardId, this.timeSpan);
    }
}