package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzt<T> extends zzg.zzx<T> {
    private final /* synthetic */ zzg.zzaq zzhi;
    private final /* synthetic */ DataHolder zzhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzg.zzaq zzaqVar, DataHolder dataHolder) {
        super(null);
        this.zzhi = zzaqVar;
        this.zzhj = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room zzay;
        zzg.zzaq zzaqVar = this.zzhi;
        zzay = zzg.zzay(this.zzhj);
        zzaqVar.zza(t, zzay);
    }
}