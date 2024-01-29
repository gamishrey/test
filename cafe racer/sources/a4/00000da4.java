package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzw extends com.google.android.gms.internal.nearby.zza implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() throws RemoteException {
        transactOneway(1, obtainAndWriteInterfaceToken());
    }
}