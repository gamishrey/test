package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshots;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzm extends zzg.zzan<Snapshots.CommitSnapshotResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
    public final void zzah(DataHolder dataHolder) {
        setResult(new zzg.zzj(dataHolder));
    }
}