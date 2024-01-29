package com.google.android.gms.games.multiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class InvitationCallback implements OnInvitationReceivedListener {
    @Override // com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public abstract void onInvitationReceived(Invitation invitation);

    @Override // com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public abstract void onInvitationRemoved(String str);
}