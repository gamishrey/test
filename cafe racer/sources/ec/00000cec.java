package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzp();
    private zzdz zzar;
    private zzdg zzas;
    private String zzat;
    private byte[] zzau;
    private zzdw zzav;

    private zzm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzm(android.os.IBinder r9, android.os.IBinder r10, java.lang.String r11, byte[] r12, android.os.IBinder r13) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L5
            r3 = r0
            goto L18
        L5:
            java.lang.String r1 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r1 = r9.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.nearby.zzdz
            if (r2 == 0) goto L12
            com.google.android.gms.internal.nearby.zzdz r1 = (com.google.android.gms.internal.nearby.zzdz) r1
            goto L17
        L12:
            com.google.android.gms.internal.nearby.zzeb r1 = new com.google.android.gms.internal.nearby.zzeb
            r1.<init>(r9)
        L17:
            r3 = r1
        L18:
            if (r10 != 0) goto L1c
            r4 = r0
            goto L2f
        L1c:
            java.lang.String r9 = "com.google.android.gms.nearby.internal.connection.IConnectionEventListener"
            android.os.IInterface r9 = r10.queryLocalInterface(r9)
            boolean r1 = r9 instanceof com.google.android.gms.internal.nearby.zzdg
            if (r1 == 0) goto L29
            com.google.android.gms.internal.nearby.zzdg r9 = (com.google.android.gms.internal.nearby.zzdg) r9
            goto L2e
        L29:
            com.google.android.gms.internal.nearby.zzdi r9 = new com.google.android.gms.internal.nearby.zzdi
            r9.<init>(r10)
        L2e:
            r4 = r9
        L2f:
            if (r13 != 0) goto L33
        L31:
            r7 = r0
            goto L47
        L33:
            java.lang.String r9 = "com.google.android.gms.nearby.internal.connection.IPayloadListener"
            android.os.IInterface r9 = r13.queryLocalInterface(r9)
            boolean r10 = r9 instanceof com.google.android.gms.internal.nearby.zzdw
            if (r10 == 0) goto L41
            r0 = r9
            com.google.android.gms.internal.nearby.zzdw r0 = (com.google.android.gms.internal.nearby.zzdw) r0
            goto L31
        L41:
            com.google.android.gms.internal.nearby.zzdy r0 = new com.google.android.gms.internal.nearby.zzdy
            r0.<init>(r13)
            goto L31
        L47:
            r2 = r8
            r5 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzm.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, byte[], android.os.IBinder):void");
    }

    private zzm(zzdz zzdzVar, zzdg zzdgVar, String str, byte[] bArr, zzdw zzdwVar) {
        this.zzar = zzdzVar;
        this.zzas = zzdgVar;
        this.zzat = str;
        this.zzau = bArr;
        this.zzav = zzdwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzm) {
            zzm zzmVar = (zzm) obj;
            if (Objects.equal(this.zzar, zzmVar.zzar) && Objects.equal(this.zzas, zzmVar.zzas) && Objects.equal(this.zzat, zzmVar.zzat) && Arrays.equals(this.zzau, zzmVar.zzau) && Objects.equal(this.zzav, zzmVar.zzav)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzas, this.zzat, Integer.valueOf(Arrays.hashCode(this.zzau)), this.zzav);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.zzar;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdg zzdgVar = this.zzas;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdgVar == null ? null : zzdgVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzau, false);
        zzdw zzdwVar = this.zzav;
        SafeParcelWriter.writeIBinder(parcel, 5, zzdwVar != null ? zzdwVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}