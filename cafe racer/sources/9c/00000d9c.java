package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.internal.nearby.zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzafVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzafVar);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(List<Update> list) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        transactOneway(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzafVar) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, zzafVar);
        transactOneway(2, obtainAndWriteInterfaceToken);
    }
}