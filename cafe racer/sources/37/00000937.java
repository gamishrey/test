package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzbg extends com.google.android.gms.internal.games.zzar<String> {
    private final /* synthetic */ String zzdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.zzdi = str;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        ((com.google.android.gms.games.internal.zzbr) zzgVar.getService()).zza(new zzbf(this, taskCompletionSource), this.zzdi);
    }
}