package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* loaded from: classes.dex */
final class zzad extends zzau<ConnectionLifecycleCallback> {
    private final /* synthetic */ zzef zzbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(zzz zzzVar, zzef zzefVar) {
        super();
        this.zzbl = zzefVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        this.zzbl.zzg();
        new com.google.android.gms.nearby.connection.zze(this.zzbl.getQuality());
    }
}