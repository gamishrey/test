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
public final class AppContentCardEntity extends com.google.android.gms.games.internal.zzc implements zze {
    public static final Parcelable.Creator<AppContentCardEntity> CREATOR = new zzg();
    private final String description;
    private final Bundle extras;
    private final String type;
    private final String zzca;
    private final ArrayList<AppContentConditionEntity> zzfr;
    private final String zzfs;
    private final String zzft;
    private final ArrayList<AppContentActionEntity> zzgc;
    private final ArrayList<AppContentAnnotationEntity> zzgd;
    private final int zzge;
    private final String zzgf;
    private final int zzgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentCardEntity(ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i, String str2, Bundle bundle, String str3, String str4, int i2, String str5, String str6) {
        this.zzgc = arrayList;
        this.zzgd = arrayList2;
        this.zzfr = arrayList3;
        this.zzfs = str;
        this.zzge = i;
        this.description = str2;
        this.extras = bundle;
        this.zzft = str6;
        this.zzgf = str3;
        this.zzca = str4;
        this.zzgg = i2;
        this.type = str5;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zze freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zza> getActions() {
        return new ArrayList(this.zzgc);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zzb> zzap() {
        return new ArrayList(this.zzgd);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final List<zzf> zzag() {
        return new ArrayList(this.zzfr);
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String zzah() {
        return this.zzfs;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final int zzaq() {
        return this.zzge;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final Bundle getExtras() {
        return this.extras;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getId() {
        return this.zzft;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String zzar() {
        return this.zzgf;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getTitle() {
        return this.zzca;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final int zzas() {
        return this.zzgg;
    }

    @Override // com.google.android.gms.games.appcontent.zze
    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzap(), zzag(), zzah(), Integer.valueOf(zzaq()), getDescription(), Integer.valueOf(com.google.android.gms.games.internal.zzd.zza(getExtras())), getId(), zzar(), getTitle(), Integer.valueOf(zzas()), getType());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            if (this == obj) {
                return true;
            }
            zze zzeVar = (zze) obj;
            return Objects.equal(zzeVar.getActions(), getActions()) && Objects.equal(zzeVar.zzap(), zzap()) && Objects.equal(zzeVar.zzag(), zzag()) && Objects.equal(zzeVar.zzah(), zzah()) && Objects.equal(Integer.valueOf(zzeVar.zzaq()), Integer.valueOf(zzaq())) && Objects.equal(zzeVar.getDescription(), getDescription()) && com.google.android.gms.games.internal.zzd.zza(zzeVar.getExtras(), getExtras()) && Objects.equal(zzeVar.getId(), getId()) && Objects.equal(zzeVar.zzar(), zzar()) && Objects.equal(zzeVar.getTitle(), getTitle()) && Objects.equal(Integer.valueOf(zzeVar.zzas()), Integer.valueOf(zzas())) && Objects.equal(zzeVar.getType(), getType());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzap()).add("Conditions", zzag()).add("ContentDescription", zzah()).add("CurrentSteps", Integer.valueOf(zzaq())).add("Description", getDescription()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzar()).add("Title", getTitle()).add("TotalSteps", Integer.valueOf(zzas())).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, zzap(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzag(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfs, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzge);
        SafeParcelWriter.writeString(parcel, 6, this.description, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.extras, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzgf, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzca, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzgg);
        SafeParcelWriter.writeString(parcel, 13, this.type, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzft, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}