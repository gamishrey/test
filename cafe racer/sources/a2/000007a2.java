package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class AchievementsClient extends com.google.android.gms.internal.games.zzad {
    /* JADX INFO: Access modifiers changed from: protected */
    public AchievementsClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public abstract Task<Intent> getAchievementsIntent();

    public abstract void increment(String str, int i);

    public abstract Task<Boolean> incrementImmediate(String str, int i);

    public abstract Task<AnnotatedData<AchievementBuffer>> load(boolean z);

    public abstract void reveal(String str);

    public abstract Task<Void> revealImmediate(String str);

    public abstract void setSteps(String str, int i);

    public abstract Task<Boolean> setStepsImmediate(String str, int i);

    public abstract void unlock(String str);

    public abstract Task<Void> unlockImmediate(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public AchievementsClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}