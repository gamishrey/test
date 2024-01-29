package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzdn extends zzb implements zzdm {
    public zzdn() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((zzel) zzc.zza(parcel, zzel.CREATOR));
            return true;
        }
        return false;
    }
}