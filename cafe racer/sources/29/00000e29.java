package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
class RtmpSelectOpponentsUiRequest extends BaseSelectOpponentsUiRequest {
    public RtmpSelectOpponentsUiRequest(int i, int i2) {
        super(i, i2);
    }

    @Override // com.google.games.bridge.BaseSelectOpponentsUiRequest
    Task<Intent> getIntentTask(Activity activity, GoogleSignInAccount googleSignInAccount) {
        return Games.getRealTimeMultiplayerClient(activity, googleSignInAccount).getSelectOpponentsIntent(getMinPlayers(), getMaxPlayers());
    }
}