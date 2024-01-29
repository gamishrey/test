package com.google.games.bridge;

import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationCallback;

/* loaded from: classes.dex */
public class InvitationCallbackProxy extends InvitationCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onInvitationReceived(Invitation invitation);

        void onInvitationRemoved(String str);
    }

    public InvitationCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.games.multiplayer.InvitationCallback, com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public void onInvitationReceived(Invitation invitation) {
        this.callback.onInvitationReceived(invitation);
    }

    @Override // com.google.android.gms.games.multiplayer.InvitationCallback, com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public void onInvitationRemoved(String str) {
        this.callback.onInvitationRemoved(str);
    }
}