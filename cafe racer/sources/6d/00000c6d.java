package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class zzcs extends zzcy {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzcv;
    private final /* synthetic */ ListenerHolder zzdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzca zzcaVar, GoogleApiClient googleApiClient, String str, String str2, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.val$name = str;
        this.zzcv = str2;
        this.zzdf = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        zzxVar.zza(this, this.val$name, this.zzcv, this.zzdf);
    }
}