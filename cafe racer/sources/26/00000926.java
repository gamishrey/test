package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzaq extends zzp implements zzap {
    private final com.google.android.gms.games.internal.player.zzd zzcz;

    public zzaq(DataHolder dataHolder, int i, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i);
        this.zzcz = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.zzap
    public final int zzq() {
        String str = this.zzcz.zznp;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getInteger(str);
    }

    @Override // com.google.android.gms.games.zzap
    public final String zzr() {
        return zza(this.zzcz.zznq, null);
    }

    @Override // com.google.android.gms.games.zzap
    public final String zzs() {
        return zza(this.zzcz.zznr, null);
    }

    public final boolean zzt() {
        return (zzq() == -1 && zzr() == null && zzs() == null) ? false : true;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zzao.zza(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return zzao.zza(this, obj);
    }

    public final String toString() {
        return zzao.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new zzao(this).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ zzap freeze() {
        return new zzao(this);
    }
}