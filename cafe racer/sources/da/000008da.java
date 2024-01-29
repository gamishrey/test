package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class TurnBasedMatchBuffer extends EntityBuffer<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* synthetic */ TurnBasedMatch getEntry(int i, int i2) {
        return new zzc(this.mDataHolder, i, i2);
    }
}