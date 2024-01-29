package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzaw implements Invitations {
    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbm();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        com.google.android.gms.games.internal.zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzb(googleApiClient.registerListener(onInvitationReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        com.google.android.gms.games.internal.zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbo();
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzav(this, googleApiClient, i));
    }
}