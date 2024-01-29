package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzdu implements Videos {
    @Override // com.google.android.gms.games.video.Videos
    public final PendingResult<Videos.CaptureCapabilitiesResult> getCaptureCapabilities(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzdt(this, googleApiClient));
    }

    @Override // com.google.android.gms.games.video.Videos
    public final Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzcg();
    }

    @Override // com.google.android.gms.games.video.Videos
    public final PendingResult<Videos.CaptureStateResult> getCaptureState(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzdw(this, googleApiClient));
    }

    @Override // com.google.android.gms.games.video.Videos
    public final PendingResult<Videos.CaptureAvailableResult> isCaptureAvailable(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzdv(this, googleApiClient, i));
    }

    @Override // com.google.android.gms.games.video.Videos
    public final boolean isCaptureSupported(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzci();
    }

    @Override // com.google.android.gms.games.video.Videos
    public final void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient, Videos.CaptureOverlayStateListener captureOverlayStateListener) {
        com.google.android.gms.games.internal.zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzf(googleApiClient.registerListener(captureOverlayStateListener));
        }
    }

    @Override // com.google.android.gms.games.video.Videos
    public final void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient) {
        com.google.android.gms.games.internal.zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzck();
        }
    }
}