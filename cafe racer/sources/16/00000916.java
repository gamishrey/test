package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzaa implements com.google.android.gms.games.internal.zzbi {
    @Override // com.google.android.gms.games.internal.zzbi
    public final boolean zzb(Status status) {
        return status.isSuccess() || status.getStatusCode() == 5;
    }
}