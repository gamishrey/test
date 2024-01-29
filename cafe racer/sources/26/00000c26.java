package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
final class zzab extends zzau<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzen zzbi;
    private final /* synthetic */ Status zzbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzab(zzz zzzVar, zzen zzenVar, Status status) {
        super();
        this.zzbi = zzenVar;
        this.zzbj = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.zzbi.zzg(), new ConnectionResolution(this.zzbj));
    }
}