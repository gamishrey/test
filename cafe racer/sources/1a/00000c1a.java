package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzq implements Achievements {
    @Override // com.google.android.gms.games.achievement.Achievements
    public final Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbk();
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzp(this, googleApiClient, z));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void reveal(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new zzr(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzu(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void unlock(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new zzt(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzw(this, str, googleApiClient, str));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.execute(new zzv(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.execute(new zzy(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.execute(new zzx(this, str, googleApiClient, str, i));
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public final PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.execute(new zzs(this, str, googleApiClient, str, i));
    }
}