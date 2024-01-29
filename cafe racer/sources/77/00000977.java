package com.google.android.gms.games;

import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzs implements com.google.android.gms.games.internal.zzbj<GamesMetadata.LoadGamesResult> {
    @Override // com.google.android.gms.games.internal.zzbj
    public final /* synthetic */ void zza(GamesMetadata.LoadGamesResult loadGamesResult) {
        GamesMetadata.LoadGamesResult loadGamesResult2 = loadGamesResult;
        if (loadGamesResult2.getGames() != null) {
            loadGamesResult2.getGames().release();
        }
    }
}