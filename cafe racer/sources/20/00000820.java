package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzai implements zzg.zzav {
    static final zzg.zzav zziu = new zzai();

    private zzai() {
    }

    @Override // com.google.android.gms.games.internal.zzg.zzav
    public final void zza(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onRoomCreated(i, room);
    }
}