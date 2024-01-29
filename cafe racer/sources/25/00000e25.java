package com.google.games.bridge;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback;
import java.util.List;

/* loaded from: classes.dex */
public class RoomStatusUpdateCallbackProxy extends RoomStatusUpdateCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onConnectedToRoom(Room room);

        void onDisconnectedFromRoom(Room room);

        void onP2PConnected(String str);

        void onP2PDisconnected(String str);

        void onPeerDeclined(Room room, List<String> list);

        void onPeerInvitedToRoom(Room room, List<String> list);

        void onPeerJoined(Room room, List<String> list);

        void onPeerLeft(Room room, List<String> list);

        void onPeersConnected(Room room, List<String> list);

        void onPeersDisconnected(Room room, List<String> list);

        void onRoomAutoMatching(Room room);

        void onRoomConnecting(Room room);
    }

    public RoomStatusUpdateCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onRoomConnecting(Room room) {
        this.callback.onRoomConnecting(room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onRoomAutoMatching(Room room) {
        this.callback.onRoomAutoMatching(room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerInvitedToRoom(Room room, List<String> list) {
        this.callback.onPeerInvitedToRoom(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerDeclined(Room room, List<String> list) {
        this.callback.onPeerDeclined(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerJoined(Room room, List<String> list) {
        this.callback.onPeerJoined(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerLeft(Room room, List<String> list) {
        this.callback.onPeerLeft(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onConnectedToRoom(Room room) {
        this.callback.onConnectedToRoom(room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onDisconnectedFromRoom(Room room) {
        this.callback.onDisconnectedFromRoom(room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeersConnected(Room room, List<String> list) {
        this.callback.onPeersConnected(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeersDisconnected(Room room, List<String> list) {
        this.callback.onPeersDisconnected(room, list);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onP2PConnected(String str) {
        this.callback.onP2PConnected(str);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onP2PDisconnected(String str) {
        this.callback.onP2PDisconnected(str);
    }
}