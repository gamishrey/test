package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbw extends com.google.android.gms.internal.games.zzar<Intent> {
    private final /* synthetic */ String zzeg;
    private final /* synthetic */ boolean zzeh;
    private final /* synthetic */ boolean zzei;
    private final /* synthetic */ int zzej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbw(SnapshotsClient snapshotsClient, String str, boolean z, boolean z2, int i) {
        this.zzeg = str;
        this.zzeh = z;
        this.zzei = z2;
        this.zzej = i;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzgVar.zza(this.zzeg, this.zzeh, this.zzei, this.zzej));
    }
}