package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.games.bridge.HelperFragment;
import java.util.List;

/* loaded from: classes.dex */
abstract class BaseSelectOpponentsUiRequest implements HelperFragment.Request {
    private static final String TAG = "SelectOpponents";
    private final int maxPlayers;
    private final int minPlayers;
    private final TaskCompletionSource<Result> resultTaskSource = new TaskCompletionSource<>();

    abstract Task<Intent> getIntentTask(Activity activity, GoogleSignInAccount googleSignInAccount);

    /* loaded from: classes.dex */
    public class Result {
        public int maxAutomatchingPlayers;
        public int minAutomatchingPlayers;
        public List<String> playerIdsToInvite;
        public int status;

        Result(int i, int i2, int i3, List<String> list) {
            this.status = i;
            this.minAutomatchingPlayers = i2;
            this.maxAutomatchingPlayers = i3;
            this.playerIdsToInvite = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseSelectOpponentsUiRequest(int i, int i2) {
        this.minPlayers = i;
        this.maxPlayers = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Result> getTask() {
        return this.resultTaskSource.getTask();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(final HelperFragment helperFragment) {
        Activity activity = helperFragment.getActivity();
        getIntentTask(activity, HelperFragment.getAccount(activity)).addOnSuccessListener(new OnSuccessListener<Intent>() { // from class: com.google.games.bridge.BaseSelectOpponentsUiRequest.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Intent intent) {
                Utils.startActivityForResult(helperFragment, intent, GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.games.bridge.BaseSelectOpponentsUiRequest.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                BaseSelectOpponentsUiRequest.this.setFailure(exc);
            }
        });
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9006) {
            if (i2 == -1) {
                setResult(1, intent.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, this.minPlayers), intent.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, this.maxPlayers), intent.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS));
            } else if (i2 == 0) {
                setResult(-6);
            } else if (i2 == 10001) {
                setResult(-3);
            } else {
                Log.d(TAG, "onActivityResult unknown resultCode: " + i2);
                setResult(-2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMinPlayers() {
        return this.minPlayers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    void setResult(int i, int i2, int i3, List<String> list) {
        this.resultTaskSource.setResult(new Result(i, i2, i3, list));
        HelperFragment.finishRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setResult(int i) {
        setResult(i, 0, 0, null);
    }

    void setFailure(Exception exc) {
        this.resultTaskSource.setException(exc);
        HelperFragment.finishRequest(this);
    }
}