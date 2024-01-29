package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbx implements PendingResultUtil.ResultConverter<Snapshots.DeleteSnapshotResult, String> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ String convert(Snapshots.DeleteSnapshotResult deleteSnapshotResult) {
        Snapshots.DeleteSnapshotResult deleteSnapshotResult2 = deleteSnapshotResult;
        if (deleteSnapshotResult2 == null) {
            return null;
        }
        return deleteSnapshotResult2.getSnapshotId();
    }
}