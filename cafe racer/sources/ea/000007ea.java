package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class AppContentConditionEntity extends com.google.android.gms.games.internal.zzc implements zzf {
    public static final Parcelable.Creator<AppContentConditionEntity> CREATOR = new zzh();
    private final String zzgh;
    private final String zzgi;
    private final String zzgj;
    private final Bundle zzgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentConditionEntity(String str, String str2, String str3, Bundle bundle) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgj = str3;
        this.zzgk = bundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zzf freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zzf
    public final String zzat() {
        return this.zzgh;
    }

    @Override // com.google.android.gms.games.appcontent.zzf
    public final String zzau() {
        return this.zzgi;
    }

    @Override // com.google.android.gms.games.appcontent.zzf
    public final String zzav() {
        return this.zzgj;
    }

    @Override // com.google.android.gms.games.appcontent.zzf
    public final Bundle zzaw() {
        return this.zzgk;
    }

    public final int hashCode() {
        return Objects.hashCode(zzat(), zzau(), zzav(), zzaw());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzf) {
            if (this == obj) {
                return true;
            }
            zzf zzfVar = (zzf) obj;
            return Objects.equal(zzfVar.zzat(), zzat()) && Objects.equal(zzfVar.zzau(), zzau()) && Objects.equal(zzfVar.zzav(), zzav()) && Objects.equal(zzfVar.zzaw(), zzaw());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("DefaultValue", zzat()).add("ExpectedValue", zzau()).add("Predicate", zzav()).add("PredicateParameters", zzaw()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgj, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}