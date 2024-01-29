package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbf extends com.google.android.gms.games.internal.zzb {
    private final /* synthetic */ TaskCompletionSource zzdo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(zzbg zzbgVar, TaskCompletionSource taskCompletionSource) {
        this.zzdo = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
    public final void onLeftRoom(int i, String str) {
        TaskUtil.setResultOrApiException(GamesClientStatusCodes.zza(GamesClientStatusCodes.zzb(i)), str, this.zzdo);
    }
}