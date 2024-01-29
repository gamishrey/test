package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements zza {
    private final zzd zzcz;

    public zzb(DataHolder dataHolder, int i, zzd zzdVar) {
        super(dataHolder, i);
        this.zzcz = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdd() {
        return getString(this.zzcz.zzna);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzde() {
        return getString(this.zzcz.zznb);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzdf() {
        return getLong(this.zzcz.zznc);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdg() {
        return parseUri(this.zzcz.zznd);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdh() {
        return parseUri(this.zzcz.zzne);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdi() {
        return parseUri(this.zzcz.zznf);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((zza) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ zza freeze() {
        return new MostRecentGameInfoEntity(this);
    }
}