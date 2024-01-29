package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzel> CREATOR = new zzem();
    private int statusCode;
    private String zzat;
    private byte[] zzau;

    private zzel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzel(String str, int i, byte[] bArr) {
        this.zzat = str;
        this.statusCode = i;
        this.zzau = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzel) {
            zzel zzelVar = (zzel) obj;
            if (Objects.equal(this.zzat, zzelVar.zzat) && Objects.equal(Integer.valueOf(this.statusCode), Integer.valueOf(zzelVar.statusCode)) && Arrays.equals(this.zzau, zzelVar.zzau)) {
                return true;
            }
        }
        return false;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzat, Integer.valueOf(this.statusCode), Integer.valueOf(Arrays.hashCode(this.zzau)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzat, false);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final byte[] zzj() {
        return this.zzau;
    }
}