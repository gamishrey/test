package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* loaded from: classes.dex */
public final class zzgc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgc> CREATOR = new zzgf();
    private long durationMillis;
    private zzdz zzar;
    private zzdp zzel;
    private DiscoveryOptions zzem;
    private zzdr zzen;
    private String zzu;

    private zzgc() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzgc(android.os.IBinder r14, android.os.IBinder r15, java.lang.String r16, long r17, com.google.android.gms.nearby.connection.DiscoveryOptions r19, android.os.IBinder r20) {
        /*
            r13 = this;
            r0 = r14
            r1 = r15
            r2 = r20
            r3 = 0
            if (r0 != 0) goto L9
            r6 = r3
            goto L1c
        L9:
            java.lang.String r4 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r4 = r14.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.nearby.zzdz
            if (r5 == 0) goto L16
            com.google.android.gms.internal.nearby.zzdz r4 = (com.google.android.gms.internal.nearby.zzdz) r4
            goto L1b
        L16:
            com.google.android.gms.internal.nearby.zzeb r4 = new com.google.android.gms.internal.nearby.zzeb
            r4.<init>(r14)
        L1b:
            r6 = r4
        L1c:
            if (r1 != 0) goto L20
            r7 = r3
            goto L33
        L20:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IDiscoveryCallback"
            android.os.IInterface r0 = r15.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.nearby.zzdp
            if (r4 == 0) goto L2d
            com.google.android.gms.internal.nearby.zzdp r0 = (com.google.android.gms.internal.nearby.zzdp) r0
            goto L32
        L2d:
            com.google.android.gms.internal.nearby.zzdq r0 = new com.google.android.gms.internal.nearby.zzdq
            r0.<init>(r15)
        L32:
            r7 = r0
        L33:
            if (r2 != 0) goto L37
        L35:
            r12 = r3
            goto L4b
        L37:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IDiscoveryListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.nearby.zzdr
            if (r1 == 0) goto L45
            r3 = r0
            com.google.android.gms.internal.nearby.zzdr r3 = (com.google.android.gms.internal.nearby.zzdr) r3
            goto L35
        L45:
            com.google.android.gms.internal.nearby.zzdt r3 = new com.google.android.gms.internal.nearby.zzdt
            r3.<init>(r2)
            goto L35
        L4b:
            r5 = r13
            r8 = r16
            r9 = r17
            r11 = r19
            r5.<init>(r6, r7, r8, r9, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzgc.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, long, com.google.android.gms.nearby.connection.DiscoveryOptions, android.os.IBinder):void");
    }

    private zzgc(zzdz zzdzVar, zzdp zzdpVar, String str, long j, DiscoveryOptions discoveryOptions, zzdr zzdrVar) {
        this.zzar = zzdzVar;
        this.zzel = zzdpVar;
        this.zzu = str;
        this.durationMillis = j;
        this.zzem = discoveryOptions;
        this.zzen = zzdrVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgc) {
            zzgc zzgcVar = (zzgc) obj;
            if (Objects.equal(this.zzar, zzgcVar.zzar) && Objects.equal(this.zzel, zzgcVar.zzel) && Objects.equal(this.zzu, zzgcVar.zzu) && Objects.equal(Long.valueOf(this.durationMillis), Long.valueOf(zzgcVar.durationMillis)) && Objects.equal(this.zzem, zzgcVar.zzem) && Objects.equal(this.zzen, zzgcVar.zzen)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzel, this.zzu, Long.valueOf(this.durationMillis), this.zzem, this.zzen);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.zzar;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdp zzdpVar = this.zzel;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdpVar == null ? null : zzdpVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzu, false);
        SafeParcelWriter.writeLong(parcel, 4, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzem, i, false);
        zzdr zzdrVar = this.zzen;
        SafeParcelWriter.writeIBinder(parcel, 6, zzdrVar != null ? zzdrVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}