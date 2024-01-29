package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import java.util.Set;

/* loaded from: classes.dex */
final class zzak extends zzds {
    private final ListenerHolder<EndpointDiscoveryCallback> zzbe;
    private final Set<String> zzbq = new ArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(ListenerHolder<EndpointDiscoveryCallback> listenerHolder) {
        this.zzbe = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void shutdown() {
        for (String str : this.zzbq) {
            this.zzbe.notifyListener(new zzan(this, str));
        }
        this.zzbq.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final synchronized void zza(zzer zzerVar) {
        this.zzbq.add(zzerVar.zze());
        this.zzbe.notifyListener(new zzal(this, zzerVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final synchronized void zza(zzet zzetVar) {
        this.zzbq.remove(zzetVar.zze());
        this.zzbe.notifyListener(new zzam(this, zzetVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdr
    public final void zza(zzfd zzfdVar) {
    }
}