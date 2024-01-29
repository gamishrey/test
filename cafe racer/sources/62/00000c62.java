package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* loaded from: classes.dex */
final class zzch extends zzcw {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ long zzcy;
    private final /* synthetic */ ListenerHolder zzcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzch(zzca zzcaVar, GoogleApiClient googleApiClient, String str, long j, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.val$name = str;
        this.zzcy = j;
        this.zzcz = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        String str = this.val$name;
        long j = this.zzcy;
        ListenerHolder listenerHolder = this.zzcz;
        ((zzdu) zzxVar.getService()).zza(new zzga().zza(new zzbc(this)).zzi(str).zzj("__LEGACY_SERVICE_ID__").zzd(j).zza(new zzag(listenerHolder)).zzg(new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_CLUSTER).build()).zzv());
    }
}