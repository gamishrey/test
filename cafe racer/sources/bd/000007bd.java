package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class GamesMetadataClient extends com.google.android.gms.internal.games.zzad {
    private static final PendingResultUtil.ResultConverter<GamesMetadata.LoadGamesResult, Game> zzbd = new zzq();
    private static final com.google.android.gms.games.internal.zzbj<GamesMetadata.LoadGamesResult> zzbe = new zzs();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesMetadataClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesMetadataClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Game> getCurrentGame() {
        return doRead(new zzr(this));
    }

    public Task<AnnotatedData<Game>> loadGame() {
        return com.google.android.gms.games.internal.zzbb.zza(Games.GamesMetadata.loadGame(asGoogleApiClient()), zzbd, zzbe);
    }
}