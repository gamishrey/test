package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.GamesStatusCodes;

/* loaded from: classes.dex */
public final class zzdv extends zza implements zzdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzcz zzczVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzczVar);
        transactAndReadExceptionReturnVoid(2009, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfm zzfmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfmVar);
        transactAndReadExceptionReturnVoid(2007, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfq zzfqVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfqVar);
        transactAndReadExceptionReturnVoid(2005, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfu zzfuVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfuVar);
        transactAndReadExceptionReturnVoid(2008, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzfy zzfyVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfyVar);
        transactAndReadExceptionReturnVoid(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgc zzgcVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzgcVar);
        transactAndReadExceptionReturnVoid(2003, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgg zzggVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzggVar);
        transactAndReadExceptionReturnVoid(GamesStatusCodes.STATUS_REQUEST_TOO_MANY_RECIPIENTS, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgj zzgjVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzgjVar);
        transactAndReadExceptionReturnVoid(2010, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzgm zzgmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzgmVar);
        transactAndReadExceptionReturnVoid(2004, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzm zzmVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzmVar);
        transactAndReadExceptionReturnVoid(2006, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzq zzqVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzqVar);
        transactAndReadExceptionReturnVoid(2012, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zza(zzu zzuVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzuVar);
        transactAndReadExceptionReturnVoid(2011, obtainAndWriteInterfaceToken);
    }
}