package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.StatusCallback;

/* loaded from: classes.dex */
final class zzhc extends zzha<StatusCallback> {
    private final /* synthetic */ boolean zzjm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(zzhb zzhbVar, boolean z) {
        this.zzjm = z;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.zzjm);
    }
}