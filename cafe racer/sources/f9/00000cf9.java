package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzz extends zzdk {
    private final ListenerHolder<ConnectionLifecycleCallback> zzbe;
    private final Set<String> zzbf = new ArraySet();
    private final Set<String> zzbg = new ArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        this.zzbe = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void shutdown() {
        for (String str : this.zzbf) {
            this.zzbe.notifyListener(new zzae(this, str));
        }
        this.zzbf.clear();
        for (String str2 : this.zzbg) {
            this.zzbe.notifyListener(new zzaf(this, str2));
        }
        this.zzbg.clear();
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzefVar) {
        this.zzbe.notifyListener(new zzad(this, zzefVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzeh zzehVar) {
        this.zzbf.add(zzehVar.zzg());
        this.zzbe.notifyListener(new zzaa(this, zzehVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzen zzenVar) {
        Status zza;
        this.zzbf.remove(zzenVar.zzg());
        zza = zzx.zza(zzenVar.getStatusCode());
        if (zza.isSuccess()) {
            this.zzbg.add(zzenVar.zzg());
        }
        this.zzbe.notifyListener(new zzab(this, zzenVar, zza));
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final synchronized void zza(zzep zzepVar) {
        this.zzbg.remove(zzepVar.zzg());
        this.zzbe.notifyListener(new zzac(this, zzepVar));
    }
}