package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class AppContentSectionEntity extends com.google.android.gms.games.internal.zzc implements zzi {
    public static final Parcelable.Creator<AppContentSectionEntity> CREATOR = new zzk();
    private final Bundle extras;
    private final String type;
    private final String zzca;
    private final String zzfs;
    private final String zzft;
    private final ArrayList<AppContentActionEntity> zzgc;
    private final ArrayList<AppContentAnnotationEntity> zzgd;
    private final String zzgf;
    private final ArrayList<AppContentCardEntity> zzgl;
    private final String zzgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentSectionEntity(ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentCardEntity> arrayList2, String str, Bundle bundle, String str2, String str3, String str4, String str5, String str6, ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.zzgc = arrayList;
        this.zzgd = arrayList3;
        this.zzgl = arrayList2;
        this.zzgm = str6;
        this.zzfs = str;
        this.extras = bundle;
        this.zzft = str5;
        this.zzgf = str2;
        this.zzca = str3;
        this.type = str4;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zzi freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zza> getActions() {
        return new ArrayList(this.zzgc);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zzb> zzap() {
        return new ArrayList(this.zzgd);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final List<zze> zzax() {
        return new ArrayList(this.zzgl);
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzay() {
        return this.zzgm;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzah() {
        return this.zzfs;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final Bundle getExtras() {
        return this.extras;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String zzar() {
        return this.zzgf;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getId() {
        return this.zzft;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getTitle() {
        return this.zzca;
    }

    @Override // com.google.android.gms.games.appcontent.zzi
    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzap(), zzax(), zzay(), zzah(), Integer.valueOf(com.google.android.gms.games.internal.zzd.zza(getExtras())), getId(), zzar(), getTitle(), getType());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzi) {
            if (this == obj) {
                return true;
            }
            zzi zziVar = (zzi) obj;
            return Objects.equal(zziVar.getActions(), getActions()) && Objects.equal(zziVar.zzap(), zzap()) && Objects.equal(zziVar.zzax(), zzax()) && Objects.equal(zziVar.zzay(), zzay()) && Objects.equal(zziVar.zzah(), zzah()) && com.google.android.gms.games.internal.zzd.zza(zziVar.getExtras(), getExtras()) && Objects.equal(zziVar.getId(), getId()) && Objects.equal(zziVar.zzar(), zzar()) && Objects.equal(zziVar.getTitle(), getTitle()) && Objects.equal(zziVar.getType(), getType());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzap()).add("Cards", zzax()).add("CardType", zzay()).add("ContentDescription", zzah()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzar()).add("Title", getTitle()).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzax(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfs, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 8, this.type, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzft, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzgm, false);
        SafeParcelWriter.writeTypedList(parcel, 14, zzap(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}