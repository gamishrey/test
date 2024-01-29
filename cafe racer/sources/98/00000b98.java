package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzaf implements Events {
    @Override // com.google.android.gms.games.event.Events
    public final PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new zzai(this, googleApiClient, z, strArr));
    }

    @Override // com.google.android.gms.games.event.Events
    public final PendingResult<Events.LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzah(this, googleApiClient, z));
    }

    @Override // com.google.android.gms.games.event.Events
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        com.google.android.gms.games.internal.zzg zzb = Games.zzb(googleApiClient, false);
        if (zzb == null) {
            return;
        }
        if (zzb.isConnected()) {
            zzb.zza(str, i);
        } else {
            googleApiClient.execute(new zzak(this, googleApiClient, str, i));
        }
    }
}