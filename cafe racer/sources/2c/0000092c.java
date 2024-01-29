package com.google.android.gms.games;

import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzaw implements com.google.android.gms.games.internal.zzbj<Players.LoadPlayersResult> {
    @Override // com.google.android.gms.games.internal.zzbj
    public final /* synthetic */ void zza(Players.LoadPlayersResult loadPlayersResult) {
        Players.LoadPlayersResult loadPlayersResult2 = loadPlayersResult;
        if (loadPlayersResult2.getPlayers() != null) {
            loadPlayersResult2.getPlayers().release();
        }
    }
}