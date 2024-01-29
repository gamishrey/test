package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzq implements PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> {
    private static Game zza(GamesMetadata.LoadGamesResult loadGamesResult) {
        GameBuffer games;
        if (loadGamesResult == null || (games = loadGamesResult.getGames()) == null) {
            return null;
        }
        try {
            if (games.getCount() > 0) {
                return ((Game) games.get(0)).freeze();
            }
            return null;
        } finally {
            games.release();
        }
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Game convert(GamesMetadata.LoadGamesResult loadGamesResult) {
        return zza(loadGamesResult);
    }
}