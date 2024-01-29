package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzt extends com.google.android.gms.internal.nearby.zza implements zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, subscribeRequest);
        transactOneway(3, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzbz zzbzVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzbzVar);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcb zzcbVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzcbVar);
        transactOneway(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzce zzceVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzceVar);
        transactOneway(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcg zzcgVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzcgVar);
        transactOneway(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzh zzhVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzhVar);
        transactOneway(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzj zzjVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzjVar);
        transactOneway(9, obtainAndWriteInterfaceToken);
    }
}