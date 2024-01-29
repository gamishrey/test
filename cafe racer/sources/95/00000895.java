package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzw<T> extends zzg.zzx<T> {
    private final /* synthetic */ DataHolder zzhj;
    private final /* synthetic */ zzg.zzar zzhm;
    private final /* synthetic */ ArrayList zzhn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzw(zzg.zzar zzarVar, DataHolder dataHolder, ArrayList arrayList) {
        super(null);
        this.zzhm = zzarVar;
        this.zzhj = dataHolder;
        this.zzhn = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        Room zzay;
        zzg.zzar zzarVar = this.zzhm;
        zzay = zzg.zzay(this.zzhj);
        zzarVar.zza(t, zzay, this.zzhn);
    }
}