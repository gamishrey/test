package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzco implements Snapshots.DeleteSnapshotResult {
    private final /* synthetic */ Status zzba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzco(zzcl zzclVar, Status status) {
        this.zzba = status;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
    public final String getSnapshotId() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzba;
    }
}