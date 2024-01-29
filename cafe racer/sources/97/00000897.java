package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zzg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzy extends zzg.zzan<Games.GetServerAuthCodeResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
    public final void zza(int i, String str) {
        setResult(new zzg.zzm(GamesStatusCodes.zza(i), str));
    }
}