package com.google.games.bridge;

import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback;

/* loaded from: classes.dex */
public class TurnBasedMatchUpdateCallbackProxy extends TurnBasedMatchUpdateCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

        void onTurnBasedMatchRemoved(String str);
    }

    public TurnBasedMatchUpdateCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback, com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch) {
        this.callback.onTurnBasedMatchReceived(turnBasedMatch);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback, com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public void onTurnBasedMatchRemoved(String str) {
        this.callback.onTurnBasedMatchRemoved(str);
    }
}