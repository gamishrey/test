package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzb extends TurnBasedMatchConfig {
    private final int zzpe;
    private final String[] zzpz;
    private final Bundle zzqa;
    private final int zzqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(TurnBasedMatchConfig.Builder builder) {
        this.zzpe = builder.zzpe;
        this.zzqm = builder.zzqm;
        this.zzqa = builder.zzqa;
        this.zzpz = (String[]) builder.zzqc.toArray(new String[builder.zzqc.size()]);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int getVariant() {
        return this.zzpe;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int zzdq() {
        return this.zzqm;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final String[] getInvitedPlayerIds() {
        return this.zzpz;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final Bundle getAutoMatchCriteria() {
        return this.zzqa;
    }
}