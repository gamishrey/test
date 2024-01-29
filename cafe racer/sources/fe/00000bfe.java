package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zze extends AchievementsClient {
    public zze(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public zze(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Intent> getAchievementsIntent() {
        return doRead(zzau.zza(zzg.zzka));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<AnnotatedData<AchievementBuffer>> load(final boolean z) {
        return doRead(zzau.zza(new RemoteCall(z) { // from class: com.google.android.gms.internal.games.zzf
            private final boolean zzjz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjz = z;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zza((TaskCompletionSource) obj2, this.zzjz);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void reveal(final String str) {
        doWrite(zzau.zza(new RemoteCall(str) { // from class: com.google.android.gms.internal.games.zzi
            private final String zzhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ((com.google.android.gms.games.internal.zzg) obj).zza((TaskCompletionSource<Void>) null, this.zzhy);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> revealImmediate(final String str) {
        return doWrite(zzau.zza(new RemoteCall(str) { // from class: com.google.android.gms.internal.games.zzh
            private final String zzhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zza((TaskCompletionSource) obj2, this.zzhy);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void unlock(final String str) {
        doWrite(zzau.zza(new RemoteCall(str) { // from class: com.google.android.gms.internal.games.zzk
            private final String zzhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ((com.google.android.gms.games.internal.zzg) obj).zzb((TaskCompletionSource<Void>) null, this.zzhy);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> unlockImmediate(final String str) {
        return doWrite(zzau.zza(new RemoteCall(str) { // from class: com.google.android.gms.internal.games.zzj
            private final String zzhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zzb((TaskCompletionSource) obj2, this.zzhy);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void increment(final String str, final int i) {
        doWrite(zzau.zza(new RemoteCall(str, i) { // from class: com.google.android.gms.internal.games.zzm
            private final String zzhy;
            private final int zziq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
                this.zziq = i;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ((com.google.android.gms.games.internal.zzg) obj).zza((TaskCompletionSource<Boolean>) null, this.zzhy, this.zziq);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> incrementImmediate(final String str, final int i) {
        return doWrite(zzau.zza(new RemoteCall(str, i) { // from class: com.google.android.gms.internal.games.zzl
            private final String zzhy;
            private final int zziq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
                this.zziq = i;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zza((TaskCompletionSource) obj2, this.zzhy, this.zziq);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void setSteps(final String str, final int i) {
        doWrite(zzau.zza(new RemoteCall(str, i) { // from class: com.google.android.gms.internal.games.zzo
            private final String zzhy;
            private final int zziq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
                this.zziq = i;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ((com.google.android.gms.games.internal.zzg) obj).zzb((TaskCompletionSource<Boolean>) null, this.zzhy, this.zziq);
            }
        }));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> setStepsImmediate(final String str, final int i) {
        return doWrite(zzau.zza(new RemoteCall(str, i) { // from class: com.google.android.gms.internal.games.zzn
            private final String zzhy;
            private final int zziq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = str;
                this.zziq = i;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzg) obj).zzb((TaskCompletionSource) obj2, this.zzhy, this.zziq);
            }
        }));
    }
}