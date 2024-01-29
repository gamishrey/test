package com.google.android.gms.games;

import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcd implements com.google.android.gms.games.internal.zzbj<TurnBasedMultiplayer.LoadMatchesResult> {
    @Override // com.google.android.gms.games.internal.zzbj
    public final /* synthetic */ void zza(TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult) {
        TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult2 = loadMatchesResult;
        if (loadMatchesResult2.getMatches() != null) {
            loadMatchesResult2.getMatches().release();
        }
    }
}