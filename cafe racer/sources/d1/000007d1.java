package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Players;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class PlayersClient extends com.google.android.gms.internal.games.zzad {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
    public static final String zzdc;
    private static final PendingResultUtil.ResultConverter<Players.LoadPlayersResult, PlayerBuffer> zzdd;
    private static final com.google.android.gms.games.internal.zzbj<Players.LoadPlayersResult> zzde;
    private static final PendingResultUtil.ResultConverter<Players.LoadPlayersResult, Player> zzdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayersClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayersClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<String> getCurrentPlayerId() {
        return doRead(new zzat(this));
    }

    public Task<Player> getCurrentPlayer() {
        return doRead(new zzas(this));
    }

    public Task<AnnotatedData<Player>> loadPlayer(String str) {
        return loadPlayer(str, false);
    }

    public Task<AnnotatedData<Player>> loadPlayer(String str, boolean z) {
        return com.google.android.gms.games.internal.zzbb.zza(Games.Players.loadPlayer(asGoogleApiClient(), str, z), zzdf, zzde);
    }

    public Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return com.google.android.gms.games.internal.zzbb.zzb(Games.Players.loadRecentlyPlayedWithPlayers(asGoogleApiClient(), i, z), zzdd);
    }

    public Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i) {
        return com.google.android.gms.games.internal.zzbb.zzb(Games.Players.loadMoreRecentlyPlayedWithPlayers(asGoogleApiClient(), i), zzdd);
    }

    public Task<Intent> getCompareProfileIntent(Player player) {
        return doRead(new zzav(this, player));
    }

    public Task<Intent> getPlayerSearchIntent() {
        return doRead(new zzau(this));
    }

    static {
        char[] cArr = {165, 177, 168, 164, 173, 163, 178, 158, 160, 171, 171};
        for (int i = 0; i < 11; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        zzdc = new String(cArr);
        zzdd = new zzax();
        zzde = new zzaw();
        zzdf = new zzay();
    }
}