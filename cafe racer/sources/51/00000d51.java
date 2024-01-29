package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    private final int versionCode;
    private final int zzhb;
    private final int zzhc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(int i, int i2, int i3) {
        this.versionCode = i;
        this.zzhb = i2;
        this.zzhc = (-169 >= i3 || i3 >= 87) ? Integer.MIN_VALUE : Integer.MIN_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BleSignal) {
            BleSignal bleSignal = (BleSignal) obj;
            return this.zzhb == bleSignal.getRssi() && this.zzhc == bleSignal.getTxPower();
        }
        return false;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.zzhb;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.zzhc;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzhb), Integer.valueOf(this.zzhc));
    }

    public final String toString() {
        int i = this.zzhb;
        int i2 = this.zzhc;
        StringBuilder sb = new StringBuilder(48);
        sb.append("BleSignal{rssi=");
        sb.append(i);
        sb.append(", txPower=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}