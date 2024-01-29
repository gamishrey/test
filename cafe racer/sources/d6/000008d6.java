package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzaz;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class LoadMatchesResponse {
    private final InvitationBuffer zzqi;
    private final TurnBasedMatchBuffer zzqj;
    private final TurnBasedMatchBuffer zzqk;
    private final TurnBasedMatchBuffer zzql;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zza = zza(bundle, 0);
        if (zza != null) {
            this.zzqi = new InvitationBuffer(zza);
        } else {
            this.zzqi = null;
        }
        DataHolder zza2 = zza(bundle, 1);
        if (zza2 != null) {
            this.zzqj = new TurnBasedMatchBuffer(zza2);
        } else {
            this.zzqj = null;
        }
        DataHolder zza3 = zza(bundle, 2);
        if (zza3 != null) {
            this.zzqk = new TurnBasedMatchBuffer(zza3);
        } else {
            this.zzqk = null;
        }
        DataHolder zza4 = zza(bundle, 3);
        if (zza4 != null) {
            this.zzql = new TurnBasedMatchBuffer(zza4);
        } else {
            this.zzql = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String str;
        if (i == 0) {
            str = "TURN_STATUS_INVITED";
        } else if (i == 1) {
            str = "TURN_STATUS_MY_TURN";
        } else if (i == 2) {
            str = "TURN_STATUS_THEIR_TURN";
        } else if (i != 3) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown match turn status: ");
            sb.append(i);
            zzaz.e("MatchTurnStatus", sb.toString());
            str = "TURN_STATUS_UNKNOWN";
        } else {
            str = "TURN_STATUS_COMPLETE";
        }
        if (bundle.containsKey(str)) {
            return (DataHolder) bundle.getParcelable(str);
        }
        return null;
    }

    public final InvitationBuffer getInvitations() {
        return this.zzqi;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzqj;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzqk;
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzql;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final void release() {
        InvitationBuffer invitationBuffer = this.zzqi;
        if (invitationBuffer != null) {
            invitationBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzqj;
        if (turnBasedMatchBuffer != null) {
            turnBasedMatchBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzqk;
        if (turnBasedMatchBuffer2 != null) {
            turnBasedMatchBuffer2.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzql;
        if (turnBasedMatchBuffer3 != null) {
            turnBasedMatchBuffer3.release();
        }
    }

    public final boolean hasData() {
        InvitationBuffer invitationBuffer = this.zzqi;
        if (invitationBuffer == null || invitationBuffer.getCount() <= 0) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzqj;
            if (turnBasedMatchBuffer == null || turnBasedMatchBuffer.getCount() <= 0) {
                TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzqk;
                if (turnBasedMatchBuffer2 == null || turnBasedMatchBuffer2.getCount() <= 0) {
                    TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzql;
                    return turnBasedMatchBuffer3 != null && turnBasedMatchBuffer3.getCount() > 0;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}