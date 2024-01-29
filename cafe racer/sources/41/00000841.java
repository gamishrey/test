package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzbo extends com.google.android.gms.internal.games.zza implements zzbp {
    public zzbo() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override // com.google.android.gms.internal.games.zza
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1001) {
            zzbt zzaz = zzaz();
            parcel2.writeNoException();
            com.google.android.gms.internal.games.zzd.zzb(parcel2, zzaz);
            return true;
        }
        return false;
    }
}