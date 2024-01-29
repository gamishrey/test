package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class AppContentTupleEntity extends com.google.android.gms.games.internal.zzc implements zzj {
    public static final Parcelable.Creator<AppContentTupleEntity> CREATOR = new zzl();
    private final String name;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentTupleEntity(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zzj freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.appcontent.zzj
    public final String getName() {
        return this.name;
    }

    @Override // com.google.android.gms.games.appcontent.zzj
    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), getValue());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzj) {
            if (this == obj) {
                return true;
            }
            zzj zzjVar = (zzj) obj;
            return Objects.equal(zzjVar.getName(), getName()) && Objects.equal(zzjVar.getValue(), getValue());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Name", getName()).add("Value", getValue()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}