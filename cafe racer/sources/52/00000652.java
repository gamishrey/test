package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class zzj extends com.google.android.gms.internal.common.zzb implements zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzi
    public final IObjectWrapper zzb() throws RemoteException {
        Parcel zza = zza(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.zzi
    public final int zzc() throws RemoteException {
        Parcel zza = zza(2, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}