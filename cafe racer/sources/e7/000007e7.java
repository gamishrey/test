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
public final class AppContentActionEntity extends com.google.android.gms.games.internal.zzc implements zza {
    public static final Parcelable.Creator<AppContentActionEntity> CREATOR = new zzc();
    private final Bundle extras;
    private final String type;
    private final ArrayList<AppContentConditionEntity> zzfr;
    private final String zzfs;
    private final String zzft;
    private final AppContentAnnotationEntity zzfu;
    private final String zzfv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentActionEntity(ArrayList<AppContentConditionEntity> arrayList, String str, Bundle bundle, String str2, String str3, AppContentAnnotationEntity appContentAnnotationEntity, String str4) {
        this.zzfu = appContentAnnotationEntity;
        this.zzfr = arrayList;
        this.zzfs = str;
        this.extras = bundle;
        this.zzft = str3;
        this.zzfv = str4;
        this.type = str2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zza freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final zzb zzaf() {
        return this.zzfu;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final List<zzf> zzag() {
        return new ArrayList(this.zzfr);
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String zzah() {
        return this.zzfs;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final Bundle getExtras() {
        return this.extras;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String getId() {
        return this.zzft;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String zzai() {
        return this.zzfv;
    }

    @Override // com.google.android.gms.games.appcontent.zza
    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(zzaf(), zzag(), zzah(), Integer.valueOf(com.google.android.gms.games.internal.zzd.zza(getExtras())), getId(), zzai(), getType());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zza) {
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return Objects.equal(zzaVar.zzaf(), zzaf()) && Objects.equal(zzaVar.zzag(), zzag()) && Objects.equal(zzaVar.zzah(), zzah()) && com.google.android.gms.games.internal.zzd.zza(zzaVar.getExtras(), getExtras()) && Objects.equal(zzaVar.getId(), getId()) && Objects.equal(zzaVar.zzai(), zzai()) && Objects.equal(zzaVar.getType(), getType());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Annotation", zzaf()).add("Conditions", zzag()).add("ContentDescription", zzah()).add("Extras", getExtras()).add("Id", getId()).add("OverflowText", zzai()).add("Type", getType()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, zzag(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzfs, false);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.type, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzft, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzfu, i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzfv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}