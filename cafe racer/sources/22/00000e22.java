package com.google.games.bridge;

import com.google.android.gms.games.multiplayer.realtime.OnRealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

/* loaded from: classes.dex */
public class RealTimeMessageReceivedListenerProxy implements OnRealTimeMessageReceivedListener {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onRealTimeMessageReceived(boolean z, String str, byte[] bArr);
    }

    public RealTimeMessageReceivedListenerProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.OnRealTimeMessageReceivedListener, com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
    public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
        this.callback.onRealTimeMessageReceived(realTimeMessage.isReliable(), realTimeMessage.getSenderParticipantId(), realTimeMessage.getMessageData());
    }
}