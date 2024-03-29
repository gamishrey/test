package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzax implements PendingResultUtil.ResultConverter<Players.LoadPlayersResult, PlayerBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ PlayerBuffer convert(Players.LoadPlayersResult loadPlayersResult) {
        Players.LoadPlayersResult loadPlayersResult2 = loadPlayersResult;
        if (loadPlayersResult2 == null) {
            return null;
        }
        return loadPlayersResult2.getPlayers();
    }
}