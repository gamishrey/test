package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class RoomConfig {
    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    @Deprecated
    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract OnRealTimeMessageReceivedListener getOnMessageReceivedListener();

    public abstract RoomStatusUpdateCallback getRoomStatusUpdateCallback();

    @Deprecated
    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateCallback getRoomUpdateCallback();

    @Deprecated
    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();

    public abstract zzg zzdp();

    @Deprecated
    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Builder builder(RoomUpdateCallback roomUpdateCallback) {
        return new Builder(roomUpdateCallback);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        int zzpe;
        @Deprecated
        final RoomUpdateListener zzps;
        @Deprecated
        RoomStatusUpdateListener zzpt;
        @Deprecated
        RealTimeMessageReceivedListener zzpu;
        final RoomUpdateCallback zzpv;
        RoomStatusUpdateCallback zzpw;
        OnRealTimeMessageReceivedListener zzpy;
        Bundle zzqa;
        String zzqb;
        ArrayList<String> zzqc;

        @Deprecated
        private Builder(RoomUpdateListener roomUpdateListener) {
            this.zzqb = null;
            this.zzpe = -1;
            this.zzqc = new ArrayList<>();
            this.zzps = (RoomUpdateListener) Preconditions.checkNotNull(roomUpdateListener, "Must provide a RoomUpdateListener");
            this.zzpv = null;
        }

        private Builder(RoomUpdateCallback roomUpdateCallback) {
            this.zzqb = null;
            this.zzpe = -1;
            this.zzqc = new ArrayList<>();
            this.zzpv = (RoomUpdateCallback) Preconditions.checkNotNull(roomUpdateCallback, "Must provide a RoomUpdateCallback");
            this.zzps = null;
        }

        public final Builder setInvitationIdToAccept(String str) {
            Preconditions.checkNotNull(str);
            this.zzqb = str;
            return this;
        }

        @Deprecated
        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.zzpt = roomStatusUpdateListener;
            return this;
        }

        public final Builder setRoomStatusUpdateCallback(RoomStatusUpdateCallback roomStatusUpdateCallback) {
            this.zzpw = roomStatusUpdateCallback;
            return this;
        }

        @Deprecated
        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.zzpu = realTimeMessageReceivedListener;
            return this;
        }

        public final Builder setOnMessageReceivedListener(OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
            this.zzpy = onRealTimeMessageReceivedListener;
            return this;
        }

        public final Builder addPlayersToInvite(String... strArr) {
            Preconditions.checkNotNull(strArr);
            this.zzqc.addAll(Arrays.asList(strArr));
            return this;
        }

        public final Builder addPlayersToInvite(ArrayList<String> arrayList) {
            Preconditions.checkNotNull(arrayList);
            this.zzqc.addAll(arrayList);
            return this;
        }

        public final Builder setVariant(int i) {
            Preconditions.checkArgument(i == -1 || i > 0, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzpe = i;
            return this;
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzqa = bundle;
            return this;
        }

        public final RoomConfig build() {
            return new zzd(this);
        }
    }
}