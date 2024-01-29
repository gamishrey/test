package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbt extends zzc {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzbs();
    private final Bundle zzjt;
    private final IBinder zzju;

    public zzbt(zzbw zzbwVar) {
        this.zzjt = zzbwVar.zzcu();
        this.zzju = zzbwVar.zzju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbt(Bundle bundle, IBinder iBinder) {
        this.zzjt = bundle;
        this.zzju = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzjt, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzju, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}