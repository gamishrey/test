package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzdl extends zza implements zzdj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzef zzefVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzefVar);
        transactOneway(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzeh zzehVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzehVar);
        transactOneway(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzen zzenVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzenVar);
        transactOneway(3, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdj
    public final void zza(zzep zzepVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzepVar);
        transactOneway(4, obtainAndWriteInterfaceToken);
    }
}