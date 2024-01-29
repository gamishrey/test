package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzu extends com.google.android.gms.games.internal.zzbk<OnInvitationReceivedListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(InvitationsClient invitationsClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    @Override // com.google.android.gms.games.internal.zzbk
    protected final void zzb(com.google.android.gms.games.internal.zzg zzgVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zzgVar.zzbn();
        taskCompletionSource.setResult(true);
    }
}