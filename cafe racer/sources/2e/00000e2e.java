package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.games.bridge.HelperFragment;

/* loaded from: classes.dex */
class ShowInvitationInboxUIRequest implements HelperFragment.Request {
    private static final String TAG = "ShowInvitationInboxUI";
    private final TaskCompletionSource<Result> resultTaskSource = new TaskCompletionSource<>();

    /* loaded from: classes.dex */
    public class Result {
        public Invitation invitation;
        public int status;

        Result(int i, Invitation invitation) {
            this.status = i;
            this.invitation = invitation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Result> getTask() {
        return this.resultTaskSource.getTask();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(final HelperFragment helperFragment) {
        Activity activity = helperFragment.getActivity();
        Games.getInvitationsClient(activity, HelperFragment.getAccount(activity)).getInvitationInboxIntent().addOnSuccessListener(activity, new OnSuccessListener<Intent>() { // from class: com.google.games.bridge.ShowInvitationInboxUIRequest.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Intent intent) {
                Utils.startActivityForResult(helperFragment, intent, GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE);
            }
        }).addOnFailureListener(activity, new OnFailureListener() { // from class: com.google.games.bridge.ShowInvitationInboxUIRequest.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                ShowInvitationInboxUIRequest.this.setFailure(exc);
            }
        });
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9009) {
            if (i2 == -1) {
                setResult(1, (Invitation) intent.getParcelableExtra(Multiplayer.EXTRA_INVITATION));
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

    void setResult(int i, Invitation invitation) {
        this.resultTaskSource.setResult(new Result(i, invitation));
        HelperFragment.finishRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setResult(int i) {
        setResult(i, null);
    }

    void setFailure(Exception exc) {
        this.resultTaskSource.setException(exc);
        HelperFragment.finishRequest(this);
    }
}