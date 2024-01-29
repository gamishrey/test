package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class zzaz<T> extends RegisterListenerMethod<zzah, T> {
    private final /* synthetic */ zzak zzia;
    private final /* synthetic */ zzbd zzid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzak zzakVar, ListenerHolder listenerHolder, zzbd zzbdVar) {
        super(listenerHolder);
        this.zzia = zzakVar;
        this.zzid = zzbdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzah zzahVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ListenerHolder<BaseImplementation.ResultHolder<Status>> zza;
        zzbd zzbdVar = this.zzid;
        zza = this.zzia.zza(taskCompletionSource);
        zzbdVar.zza(zzahVar, zza);
    }
}