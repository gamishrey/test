package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class EventsClient extends com.google.android.gms.internal.games.zzad {
    private static final PendingResultUtil.ResultConverter<Events.LoadEventsResult, EventBuffer> zzh = new zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return com.google.android.gms.games.internal.zzbb.zzb(Games.Events.load(asGoogleApiClient(), z), zzh);
    }

    public Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, String... strArr) {
        return com.google.android.gms.games.internal.zzbb.zzb(Games.Events.loadByIds(asGoogleApiClient(), z, strArr), zzh);
    }

    public void increment(String str, int i) {
        doWrite(new zza(this, str, i));
    }
}