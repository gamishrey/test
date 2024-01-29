package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzv<T> extends zzg.zzx<T> {
    private final /* synthetic */ DataHolder zzhj;
    private final /* synthetic */ zzg.zzav zzhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(zzg.zzav zzavVar, DataHolder dataHolder) {
        super(null);
        this.zzhl = zzavVar;
        this.zzhj = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room zzay;
        zzg.zzav zzavVar = this.zzhl;
        int statusCode = this.zzhj.getStatusCode();
        zzay = zzg.zzay(this.zzhj);
        zzavVar.zza(t, statusCode, zzay);
    }
}