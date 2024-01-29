package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class zzba<T> extends UnregisterListenerMethod<zzah, T> {
    private final /* synthetic */ zzak zzia;
    private final /* synthetic */ zzbd zzie;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzba(zzak zzakVar, ListenerHolder.ListenerKey listenerKey, zzbd zzbdVar) {
        super(listenerKey);
        this.zzia = zzakVar;
        this.zzie = zzbdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzah zzahVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ListenerHolder<BaseImplementation.ResultHolder<Status>> zza;
        zzbd zzbdVar = this.zzie;
        zza = this.zzia.zza(taskCompletionSource);
        zzbdVar.zza(zzahVar, zza);
    }
}