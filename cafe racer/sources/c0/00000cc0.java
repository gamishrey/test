package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzfu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfu> CREATOR = new zzfx();
    private zzdz zzar;
    private zzfh zzdk;
    private String[] zzee;
    private boolean zzef;

    private zzfu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzfu(android.os.IBinder r3, java.lang.String[] r4, com.google.android.gms.internal.nearby.zzfh r5, boolean r6) {
        /*
            r2 = this;
            if (r3 != 0) goto L4
            r3 = 0
            goto L18
        L4:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.nearby.zzdz
            if (r1 == 0) goto L12
            r3 = r0
            com.google.android.gms.internal.nearby.zzdz r3 = (com.google.android.gms.internal.nearby.zzdz) r3
            goto L18
        L12:
            com.google.android.gms.internal.nearby.zzeb r0 = new com.google.android.gms.internal.nearby.zzeb
            r0.<init>(r3)
            r3 = r0
        L18:
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzfu.<init>(android.os.IBinder, java.lang.String[], com.google.android.gms.internal.nearby.zzfh, boolean):void");
    }

    private zzfu(zzdz zzdzVar, String[] strArr, zzfh zzfhVar, boolean z) {
        this.zzar = zzdzVar;
        this.zzee = strArr;
        this.zzdk = zzfhVar;
        this.zzef = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfu) {
            zzfu zzfuVar = (zzfu) obj;
            if (Objects.equal(this.zzar, zzfuVar.zzar) && Arrays.equals(this.zzee, zzfuVar.zzee) && Objects.equal(this.zzdk, zzfuVar.zzdk) && Objects.equal(Boolean.valueOf(this.zzef), Boolean.valueOf(zzfuVar.zzef))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, Integer.valueOf(Arrays.hashCode(this.zzee)), this.zzdk, Boolean.valueOf(this.zzef));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.zzar;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzee, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdk, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzef);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}