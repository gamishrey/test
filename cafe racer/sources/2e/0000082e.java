package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzaw implements zzg.zzaq {
    static final zzg.zzaq zzjb = new zzaw();

    private zzaw() {
    }

    @Override // com.google.android.gms.games.internal.zzg.zzaq
    public final void zza(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onConnectedToRoom(room);
    }
}