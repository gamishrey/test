package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class AppContentAnnotationEntity extends com.google.android.gms.games.internal.zzc implements zzb {
    public static final Parcelable.Creator<AppContentAnnotationEntity> CREATOR = new zzd();
    private final String description;
    private final String zzca;
    private final String zzft;
    private final Uri zzfw;
    private final String zzfx;
    private final String zzfy;
    private final int zzfz;
    private final int zzga;
    private final Bundle zzgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentAnnotationEntity(String str, Uri uri, String str2, String str3, String str4, String str5, int i, int i2, Bundle bundle) {
        this.description = str;
        this.zzft = str3;
        this.zzfy = str5;
        this.zzfz = i;
        this.zzfw = uri;
        this.zzga = i2;
        this.zzfx = str4;
        this.zzgb = bundle;
        this.zzca = str2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zzb freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final String getId() {
        return this.zzft;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final String zzaj() {
        return this.zzfy;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final int zzak() {
        return this.zzfz;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final Uri zzal() {
        return this.zzfw;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final int zzan() {
        return this.zzga;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final String zzao() {
        return this.zzfx;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final Bundle zzam() {
        return this.zzgb;
    }

    @Override // com.google.android.gms.games.appcontent.zzb
    public final String getTitle() {
        return this.zzca;
    }

    public final int hashCode() {
        return Objects.hashCode(getDescription(), getId(), zzaj(), Integer.valueOf(zzak()), zzal(), Integer.valueOf(zzan()), zzao(), Integer.valueOf(com.google.android.gms.games.internal.zzd.zza(zzam())), getTitle());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzb) {
            if (this == obj) {
                return true;
            }
            zzb zzbVar = (zzb) obj;
            return Objects.equal(zzbVar.getDescription(), getDescription()) && Objects.equal(zzbVar.getId(), getId()) && Objects.equal(zzbVar.zzaj(), zzaj()) && Objects.equal(Integer.valueOf(zzbVar.zzak()), Integer.valueOf(zzak())) && Objects.equal(zzbVar.zzal(), zzal()) && Objects.equal(Integer.valueOf(zzbVar.zzan()), Integer.valueOf(zzan())) && Objects.equal(zzbVar.zzao(), zzao()) && com.google.android.gms.games.internal.zzd.zza(zzbVar.zzam(), zzam()) && Objects.equal(zzbVar.getTitle(), getTitle());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Description", getDescription()).add("Id", getId()).add("ImageDefaultId", zzaj()).add("ImageHeight", Integer.valueOf(zzak())).add("ImageUri", zzal()).add("ImageWidth", Integer.valueOf(zzan())).add("LayoutSlot", zzao()).add("Modifiers", zzam()).add("Title", getTitle()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.description, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfw, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzft, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzfx, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzfy, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzfz);
        SafeParcelWriter.writeInt(parcel, 9, this.zzga);
        SafeParcelWriter.writeBundle(parcel, 10, this.zzgb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}