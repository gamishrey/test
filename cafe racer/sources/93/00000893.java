package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzu<T> extends zzg.zzx<T> {
    private final /* synthetic */ zzg.zzao zzhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzu(zzg.zzao zzaoVar) {
        super(null);
        this.zzhk = zzaoVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void notifyListener(T t) {
        this.zzhk.accept(t);
    }
}