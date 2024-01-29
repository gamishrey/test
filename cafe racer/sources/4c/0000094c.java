package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzca implements PendingResultUtil.ResultConverter<Snapshots.CommitSnapshotResult, SnapshotMetadata> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ SnapshotMetadata convert(Snapshots.CommitSnapshotResult commitSnapshotResult) {
        SnapshotMetadata snapshotMetadata;
        Snapshots.CommitSnapshotResult commitSnapshotResult2 = commitSnapshotResult;
        if (commitSnapshotResult2 == null || (snapshotMetadata = commitSnapshotResult2.getSnapshotMetadata()) == null) {
            return null;
        }
        return snapshotMetadata.freeze();
    }
}