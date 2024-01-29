package com.google.games.bridge;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback;

/* loaded from: classes.dex */
public class RoomUpdateCallbackProxy extends RoomUpdateCallback {
    private Callback callback;

    /* loaded from: classes.dex */
    public interface Callback {
        void onJoinedRoom(int i, Room room);

        void onLeftRoom(int i, String str);

        void onRoomConnected(int i, Room room);

        void onRoomCreated(int i, Room room);
    }

    public RoomUpdateCallbackProxy(Callback callback) {
        this.callback = callback;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onRoomCreated(int i, Room room) {
        this.callback.onRoomCreated(i, room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onJoinedRoom(int i, Room room) {
        this.callback.onJoinedRoom(i, room);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onLeftRoom(int i, String str) {
        this.callback.onLeftRoom(i, str);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback, com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onRoomConnected(int i, Room room) {
        this.callback.onRoomConnected(i, room);
    }
}