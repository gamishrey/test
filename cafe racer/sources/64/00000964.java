package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcy extends com.google.android.gms.games.internal.zzbl<Videos.CaptureOverlayStateListener> {
    private final /* synthetic */ ListenerHolder zzbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(VideosClient videosClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzbg = listenerHolder2;
    }

    @Override // com.google.android.gms.games.internal.zzbl
    protected final void zzc(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zzgVar.zze(this.zzbg);
        taskCompletionSource.setResult(null);
    }
}