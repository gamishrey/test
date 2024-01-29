package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class MostRecentGameInfoEntity extends com.google.android.gms.games.internal.zzc implements zza {
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzc();
    private final String zzlt;
    private final String zzlu;
    private final long zzlv;
    private final Uri zzlw;
    private final Uri zzlx;
    private final Uri zzly;

    public MostRecentGameInfoEntity(zza zzaVar) {
        this.zzlt = zzaVar.zzdd();
        this.zzlu = zzaVar.zzde();
        this.zzlv = zzaVar.zzdf();
        this.zzlw = zzaVar.zzdg();
        this.zzlx = zzaVar.zzdh();
        this.zzly = zzaVar.zzdi();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zza freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MostRecentGameInfoEntity(String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zzlt = str;
        this.zzlu = str2;
        this.zzlv = j;
        this.zzlw = uri;
        this.zzlx = uri2;
        this.zzly = uri3;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdd() {
        return this.zzlt;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzde() {
        return this.zzlu;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzdf() {
        return this.zzlv;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdg() {
        return this.zzlw;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdh() {
        return this.zzlx;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdi() {
        return this.zzly;
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zza zzaVar) {
        return Objects.hashCode(zzaVar.zzdd(), zzaVar.zzde(), Long.valueOf(zzaVar.zzdf()), zzaVar.zzdg(), zzaVar.zzdh(), zzaVar.zzdi());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zza zzaVar, Object obj) {
        if (obj instanceof zza) {
            if (zzaVar == obj) {
                return true;
            }
            zza zzaVar2 = (zza) obj;
            return Objects.equal(zzaVar2.zzdd(), zzaVar.zzdd()) && Objects.equal(zzaVar2.zzde(), zzaVar.zzde()) && Objects.equal(Long.valueOf(zzaVar2.zzdf()), Long.valueOf(zzaVar.zzdf())) && Objects.equal(zzaVar2.zzdg(), zzaVar.zzdg()) && Objects.equal(zzaVar2.zzdh(), zzaVar.zzdh()) && Objects.equal(zzaVar2.zzdi(), zzaVar.zzdi());
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zza zzaVar) {
        return Objects.toStringHelper(zzaVar).add("GameId", zzaVar.zzdd()).add("GameName", zzaVar.zzde()).add("ActivityTimestampMillis", Long.valueOf(zzaVar.zzdf())).add("GameIconUri", zzaVar.zzdg()).add("GameHiResUri", zzaVar.zzdh()).add("GameFeaturedUri", zzaVar.zzdi()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzlt, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzlu, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzlv);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzlw, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzlx, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzly, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}