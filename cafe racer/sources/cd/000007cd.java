package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class PlayerStatsClient extends com.google.android.gms.internal.games.zzad {
    /* JADX INFO: Access modifiers changed from: protected */
    public PlayerStatsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public abstract Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public PlayerStatsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}