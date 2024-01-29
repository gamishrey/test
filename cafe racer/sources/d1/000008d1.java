package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzd extends RoomConfig {
    private final String zzoz;
    private final int zzpe;
    @Deprecated
    private final RoomUpdateListener zzps;
    @Deprecated
    private final RoomStatusUpdateListener zzpt;
    @Deprecated
    private final RealTimeMessageReceivedListener zzpu;
    private final RoomUpdateCallback zzpv;
    private final RoomStatusUpdateCallback zzpw;
    private final zzh zzpx;
    private final OnRealTimeMessageReceivedListener zzpy;
    private final String[] zzpz;
    private final Bundle zzqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(RoomConfig.Builder builder) {
        this.zzps = builder.zzps;
        this.zzpt = builder.zzpt;
        this.zzpu = builder.zzpu;
        this.zzpv = builder.zzpv;
        this.zzpw = builder.zzpw;
        OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener = builder.zzpy;
        this.zzpy = onRealTimeMessageReceivedListener;
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            this.zzpx = new zzh(this.zzpv, roomStatusUpdateCallback, onRealTimeMessageReceivedListener);
        } else {
            this.zzpx = null;
        }
        this.zzoz = builder.zzqb;
        this.zzpe = builder.zzpe;
        this.zzqa = builder.zzqa;
        this.zzpz = (String[]) builder.zzqc.toArray(new String[builder.zzqc.size()]);
        if (this.zzpy == null && this.zzpu == null) {
            throw new NullPointerException("Must specify a message listener");
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final zzg zzdp() {
        return this.zzpx;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RoomUpdateListener getRoomUpdateListener() {
        return this.zzps;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomUpdateCallback getRoomUpdateCallback() {
        return this.zzpv;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String getInvitationId() {
        return this.zzoz;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzpt;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomStatusUpdateCallback getRoomStatusUpdateCallback() {
        return this.zzpw;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    @Deprecated
    public final RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzpu;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final OnRealTimeMessageReceivedListener getOnMessageReceivedListener() {
        return this.zzpy;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final int getVariant() {
        return this.zzpe;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String[] getInvitedPlayerIds() {
        return this.zzpz;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final Bundle getAutoMatchCriteria() {
        return this.zzqa;
    }
}