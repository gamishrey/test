package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbb extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(RealTimeMultiplayerClient realTimeMultiplayerClient, byte[] bArr, String str) {
        this.zzdh = bArr;
        this.zzdi = str;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        if (zzgVar.zza(this.zzdh, this.zzdi) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza((int) GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}