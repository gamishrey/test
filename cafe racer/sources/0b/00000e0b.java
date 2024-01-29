package com.google.games.bridge;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.tasks.Task;
import com.google.games.bridge.BaseSelectOpponentsUiRequest;
import com.google.games.bridge.InboxUiRequest;
import com.google.games.bridge.SelectSnapshotUiRequest;
import com.google.games.bridge.ShowInvitationInboxUIRequest;
import com.google.games.bridge.ShowWaitingRoomUiRequest;

/* loaded from: classes.dex */
public class HelperFragment extends Fragment {
    private static final String FRAGMENT_TAG = "gpg.HelperFragment";
    static final int RC_CAPTURE_OVERLAY_UI = 9005;
    static final int RC_INBOX_UI = 9007;
    static final int RC_SELECT_OPPONENTS_UI = 9006;
    static final int RC_SELECT_SNAPSHOT_UI = 9004;
    static final int RC_SHOW_INVITATION_INBOX_UI = 9009;
    static final int RC_SHOW_REQUEST_PERMISSIONS_UI = 9010;
    static final int RC_SHOW_WAITING_ROOM_UI = 9008;
    static final int RC_SIGN_IN = 9002;
    static final int RC_SIMPLE_UI = 9003;
    private static final String TAG = "HelperFragment";
    private static HelperFragment helperFragment;
    private static final Object lock = new Object();
    private static boolean mStartUpSignInCheckPerformed = false;
    private static Request pendingRequest;
    private static Request runningRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Request {
        void onActivityResult(int i, int i2, Intent intent);

        void process(HelperFragment helperFragment);
    }

    public static PendingResult fetchToken(Activity activity, boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, String[] strArr, boolean z6, String str2) {
        SignInRequest signInRequest = new SignInRequest(z, z2, z3, z4, str, z5, strArr, z6, str2);
        if (!startRequest(activity, signInRequest)) {
            signInRequest.setFailure(10);
        }
        return signInRequest.getPendingResponse();
    }

    public static Task<Integer> showAchievementUi(Activity activity) {
        AchievementUiRequest achievementUiRequest = new AchievementUiRequest();
        if (!startRequest(activity, achievementUiRequest)) {
            achievementUiRequest.setResult(-12);
        }
        return achievementUiRequest.getTask();
    }

    public static void showCaptureOverlayUi(Activity activity) {
        startRequest(activity, new CaptureOverlayUiRequest());
    }

    public static Task<Integer> showAllLeaderboardsUi(Activity activity) {
        AllLeaderboardsUiRequest allLeaderboardsUiRequest = new AllLeaderboardsUiRequest();
        if (!startRequest(activity, allLeaderboardsUiRequest)) {
            allLeaderboardsUiRequest.setResult(-12);
        }
        return allLeaderboardsUiRequest.getTask();
    }

    public static Task<Integer> showLeaderboardUi(Activity activity, String str, int i) {
        LeaderboardUiRequest leaderboardUiRequest = new LeaderboardUiRequest(str, i);
        if (!startRequest(activity, leaderboardUiRequest)) {
            leaderboardUiRequest.setResult(-12);
        }
        return leaderboardUiRequest.getTask();
    }

    public static Task<SelectSnapshotUiRequest.Result> showSelectSnapshotUi(Activity activity, String str, boolean z, boolean z2, int i) {
        SelectSnapshotUiRequest selectSnapshotUiRequest = new SelectSnapshotUiRequest(str, z, z2, i);
        if (!startRequest(activity, selectSnapshotUiRequest)) {
            selectSnapshotUiRequest.setResult(-5);
        }
        return selectSnapshotUiRequest.getTask();
    }

    public static Task<BaseSelectOpponentsUiRequest.Result> showRtmpSelectOpponentsUi(Activity activity, int i, int i2) {
        RtmpSelectOpponentsUiRequest rtmpSelectOpponentsUiRequest = new RtmpSelectOpponentsUiRequest(i, i2);
        if (!startRequest(activity, rtmpSelectOpponentsUiRequest)) {
            rtmpSelectOpponentsUiRequest.setResult(-12);
        }
        return rtmpSelectOpponentsUiRequest.getTask();
    }

    public static Task<BaseSelectOpponentsUiRequest.Result> showTbmpSelectOpponentsUi(Activity activity, int i, int i2) {
        TbmpSelectOpponentsUiRequest tbmpSelectOpponentsUiRequest = new TbmpSelectOpponentsUiRequest(i, i2);
        if (!startRequest(activity, tbmpSelectOpponentsUiRequest)) {
            tbmpSelectOpponentsUiRequest.setResult(-12);
        }
        return tbmpSelectOpponentsUiRequest.getTask();
    }

    public static Task<ShowWaitingRoomUiRequest.Result> showWaitingRoomUI(Activity activity, Room room, int i) {
        ShowWaitingRoomUiRequest showWaitingRoomUiRequest = new ShowWaitingRoomUiRequest(room, i);
        if (!startRequest(activity, showWaitingRoomUiRequest)) {
            showWaitingRoomUiRequest.setResult(-1, null);
        }
        return showWaitingRoomUiRequest.getTask();
    }

    public static Task<ShowInvitationInboxUIRequest.Result> showInvitationInboxUI(Activity activity) {
        ShowInvitationInboxUIRequest showInvitationInboxUIRequest = new ShowInvitationInboxUIRequest();
        if (!startRequest(activity, showInvitationInboxUIRequest)) {
            showInvitationInboxUIRequest.setResult(-12);
        }
        return showInvitationInboxUIRequest.getTask();
    }

    public static Task<InboxUiRequest.Result> showInboxUi(Activity activity) {
        InboxUiRequest inboxUiRequest = new InboxUiRequest();
        if (!startRequest(activity, inboxUiRequest)) {
            inboxUiRequest.setResult(-12);
        }
        return inboxUiRequest.getTask();
    }

    public static Task<GoogleSignInAccount> showRequestPermissionsUi(Activity activity, String[] strArr) {
        RequestPermissionsRequest requestPermissionsRequest = new RequestPermissionsRequest(toScopeList(strArr));
        if (!startRequest(activity, requestPermissionsRequest)) {
            requestPermissionsRequest.setFailure(-12);
        }
        return requestPermissionsRequest.getTask();
    }

    public static boolean hasPermissions(Activity activity, String[] strArr) {
        return GoogleSignIn.hasPermissions(getAccount(activity), toScopeList(strArr));
    }

    private static Scope[] toScopeList(String[] strArr) {
        Scope[] scopeArr = new Scope[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            scopeArr[i] = new Scope(strArr[i]);
        }
        return scopeArr;
    }

    public static void signOut(Activity activity) {
        GoogleSignIn.getClient(activity, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).signOut();
        synchronized (lock) {
            pendingRequest = null;
            runningRequest = null;
        }
    }

    private static boolean startRequest(Activity activity, Request request) {
        boolean z;
        synchronized (lock) {
            if (pendingRequest == null && runningRequest == null) {
                pendingRequest = request;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            HelperFragment helperFragment2 = getHelperFragment(activity);
            if (helperFragment2.isResumed()) {
                helperFragment2.processRequest();
            }
        }
        return z;
    }

    private static HelperFragment getHelperFragment(Activity activity) {
        HelperFragment helperFragment2 = (HelperFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (helperFragment2 == null) {
            try {
                Log.d(TAG, "Creating fragment");
                HelperFragment helperFragment3 = new HelperFragment();
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(helperFragment3, FRAGMENT_TAG);
                beginTransaction.commit();
                return helperFragment3;
            } catch (Throwable th) {
                Log.e(TAG, "Cannot launch token fragment:" + th.getMessage(), th);
                return null;
            }
        }
        return helperFragment2;
    }

    private void processRequest() {
        synchronized (lock) {
            if (runningRequest != null) {
                return;
            }
            Request request = pendingRequest;
            pendingRequest = null;
            runningRequest = request;
            if (request == null) {
                return;
            }
            request.process(this);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Request request;
        super.onActivityResult(i, i2, intent);
        synchronized (lock) {
            request = runningRequest;
        }
        if (request == null) {
            return;
        }
        request.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Fragment
    public void onResume() {
        Log.d(TAG, "onResume called");
        super.onResume();
        if (helperFragment == null) {
            helperFragment = this;
        }
        processRequest();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void finishRequest(Request request) {
        synchronized (lock) {
            if (runningRequest == request) {
                runningRequest = null;
            }
        }
    }

    public static GoogleSignInAccount getAccount(Activity activity) {
        return GoogleSignIn.getLastSignedInAccount(activity);
    }

    public static View createInvisibleView(Activity activity) {
        View view = new View(activity);
        view.setVisibility(4);
        view.setClickable(false);
        return view;
    }

    public static View getDecorView(Activity activity) {
        return activity.getWindow().getDecorView();
    }
}