package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzby implements com.google.android.gms.games.internal.zzbg<Snapshots.OpenSnapshotResult> {
    @Override // com.google.android.gms.games.internal.zzbg
    public final /* synthetic */ ApiException zza(Status status, Snapshots.OpenSnapshotResult openSnapshotResult) {
        Snapshots.OpenSnapshotResult openSnapshotResult2 = openSnapshotResult;
        if (status.getStatusCode() == 26572 && openSnapshotResult2.getSnapshot() != null && openSnapshotResult2.getSnapshot().getMetadata() != null) {
            return new SnapshotsClient.SnapshotContentUnavailableApiException(status, openSnapshotResult2.getSnapshot().getMetadata().freeze());
        }
        return ApiExceptionUtil.fromStatus(status);
    }
}