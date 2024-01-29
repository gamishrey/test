package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzab implements Achievements.UpdateAchievementResult {
    private final /* synthetic */ Status zzba;
    private final /* synthetic */ zzac zzkd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzac zzacVar, Status status) {
        this.zzkd = zzacVar;
        this.zzba = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzba;
    }

    @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    public final String getAchievementId() {
        String str;
        str = this.zzkd.zzft;
        return str;
    }
}