package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzz extends com.google.android.gms.internal.nearby.zza implements zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.nearby.zzc.zza(obtainAndWriteInterfaceToken, z);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }
}