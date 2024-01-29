package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.games.bridge.HelperFragment;

/* loaded from: classes.dex */
class ShowWaitingRoomUiRequest implements HelperFragment.Request {
    private static final String TAG = "ShowWaitingRoomRequest";
    static final int UI_STATUS_BUSY = -1;
    static final int UI_STATUS_CANCELLED = 2;
    static final int UI_STATUS_INVALID_ROOM = 4;
    static final int UI_STATUS_LEFT_ROOM = 3;
    static final int UI_STATUS_VALID = 1;
    private int minParticipantsToStart;
    private final TaskCompletionSource<Result> resultTaskSource = new TaskCompletionSource<>();
    private Room room;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShowWaitingRoomUiRequest(Room room, int i) {
        this.room = room;
        this.minParticipantsToStart = i;
    }

    /* loaded from: classes.dex */
    public class Result {
        public Room room;
        public int status;

        Result(int i, Room room) {
            this.status = i;
            this.room = room;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Result> getTask() {
        return this.resultTaskSource.getTask();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(final HelperFragment helperFragment) {
        Activity activity = helperFragment.getActivity();
        Games.getRealTimeMultiplayerClient(activity, HelperFragment.getAccount(activity)).getWaitingRoomIntent(this.room, this.minParticipantsToStart).addOnSuccessListener(activity, new OnSuccessListener<Intent>() { // from class: com.google.games.bridge.ShowWaitingRoomUiRequest.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Intent intent) {
                Utils.startActivityForResult(helperFragment, intent, 9008);
            }
        }).addOnFailureListener(activity, new OnFailureListener() { // from class: com.google.games.bridge.ShowWaitingRoomUiRequest.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                ShowWaitingRoomUiRequest.this.setFailure(exc);
            }
        });
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9008) {
            Room room = (Room) intent.getParcelableExtra(Multiplayer.EXTRA_ROOM);
            if (i2 == -1) {
                setResult(1, room);
            } else if (i2 == 0) {
                setResult(2, room);
            } else if (i2 == 10005) {
                setResult(3, room);
            } else if (i2 == 10008) {
                setResult(4, room);
            } else {
                Log.d(TAG, "onActivityResult unknown resultCode: " + i2);
                setResult(-2, room);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setResult(int i, Room room) {
        this.resultTaskSource.setResult(new Result(i, room));
        HelperFragment.finishRequest(this);
    }

    void setFailure(Exception exc) {
        this.resultTaskSource.setException(exc);
        HelperFragment.finishRequest(this);
    }
}