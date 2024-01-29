package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zza extends com.google.android.gms.internal.games.zzar<Void> {
    private final /* synthetic */ String zzf;
    private final /* synthetic */ int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(EventsClient eventsClient, String str, int i) {
        this.zzf = str;
        this.zzg = i;
    }

    @Override // com.google.android.gms.internal.games.zzar
    protected final void zza(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzgVar.zza(this.zzf, this.zzg);
    }
}