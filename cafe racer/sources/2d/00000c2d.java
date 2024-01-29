package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Connections;

@Deprecated
/* loaded from: classes.dex */
final class zzai extends zzdn {
    private final ListenerHolder<Connections.ConnectionResponseCallback> zzbo;

    public zzai(ListenerHolder<Connections.ConnectionResponseCallback> listenerHolder) {
        this.zzbo = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zza(zzel zzelVar) {
        this.zzbo.notifyListener(new zzaj(this, zzelVar));
    }
}