package com.google.android.gms.games.multiplayer.turnbased;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class TurnBasedMatchUpdateCallback implements OnTurnBasedMatchUpdateReceivedListener {
    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public abstract void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public abstract void onTurnBasedMatchRemoved(String str);
}