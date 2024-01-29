package com.google.android.gms.games.event;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface Events {

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface LoadEventsResult extends Releasable, Result {
        EventBuffer getEvents();
    }

    void increment(GoogleApiClient googleApiClient, String str, int i);

    PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z);

    PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr);
}