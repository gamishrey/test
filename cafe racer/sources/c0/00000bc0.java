package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbs extends PlayerStatsClient {
    public zzbs(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public zzbs(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    @Override // com.google.android.gms.games.PlayerStatsClient
    public final Task<AnnotatedData<PlayerStats>> loadPlayerStats(final boolean z) {
        final RemoteCall remoteCall = new RemoteCall(z) { // from class: com.google.android.gms.internal.games.zzbr
            private final boolean zzjz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjz = z;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zzb((TaskCompletionSource) obj2, this.zzjz);
            }
        };
        return doRead(TaskApiCall.builder().run(new RemoteCall(remoteCall) { // from class: com.google.android.gms.internal.games.zzag
            private final RemoteCall zzke;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzke = remoteCall;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                try {
                    this.zzke.accept((com.google.android.gms.games.internal.zzg) obj, taskCompletionSource);
                } catch (RemoteException | SecurityException e) {
                    taskCompletionSource.trySetException(e);
                }
            }
        }).build());
    }
}