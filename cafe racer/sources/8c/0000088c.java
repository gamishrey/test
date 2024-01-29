package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzn extends zzg.zzan<Videos.CaptureStateResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
    public final void zze(int i, Bundle bundle) {
        setResult(new zzg.C0003zzg(new Status(i), CaptureState.zzb(bundle)));
    }
}