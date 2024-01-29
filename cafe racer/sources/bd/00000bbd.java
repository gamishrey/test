package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbp implements Notifications {
    @Override // com.google.android.gms.games.Notifications
    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, Notifications.NOTIFICATION_TYPES_ALL);
    }

    @Override // com.google.android.gms.games.Notifications
    public final void clear(GoogleApiClient googleApiClient, int i) {
        com.google.android.gms.games.internal.zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzo(i);
        }
    }
}