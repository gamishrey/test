package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzfq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfq> CREATOR = new zzft();
    private String name;
    private zzdz zzar;
    private zzdg zzas;
    private String zzat;
    private byte[] zzau;
    private zzdm zzeb;
    private zzdj zzec;

    private zzfq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzfq(android.os.IBinder r15, android.os.IBinder r16, android.os.IBinder r17, java.lang.String r18, java.lang.String r19, byte[] r20, android.os.IBinder r21) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r21
            r4 = 0
            if (r0 != 0) goto Lc
            r7 = r4
            goto L1f
        Lc:
            java.lang.String r5 = "com.google.android.gms.nearby.internal.connection.IResultListener"
            android.os.IInterface r5 = r15.queryLocalInterface(r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.nearby.zzdz
            if (r6 == 0) goto L19
            com.google.android.gms.internal.nearby.zzdz r5 = (com.google.android.gms.internal.nearby.zzdz) r5
            goto L1e
        L19:
            com.google.android.gms.internal.nearby.zzeb r5 = new com.google.android.gms.internal.nearby.zzeb
            r5.<init>(r15)
        L1e:
            r7 = r5
        L1f:
            if (r1 != 0) goto L23
            r8 = r4
            goto L36
        L23:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionEventListener"
            android.os.IInterface r0 = r1.queryLocalInterface(r0)
            boolean r5 = r0 instanceof com.google.android.gms.internal.nearby.zzdg
            if (r5 == 0) goto L30
            com.google.android.gms.internal.nearby.zzdg r0 = (com.google.android.gms.internal.nearby.zzdg) r0
            goto L35
        L30:
            com.google.android.gms.internal.nearby.zzdi r0 = new com.google.android.gms.internal.nearby.zzdi
            r0.<init>(r1)
        L35:
            r8 = r0
        L36:
            if (r2 != 0) goto L3a
            r9 = r4
            goto L4d
        L3a:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.nearby.zzdm
            if (r1 == 0) goto L47
            com.google.android.gms.internal.nearby.zzdm r0 = (com.google.android.gms.internal.nearby.zzdm) r0
            goto L4c
        L47:
            com.google.android.gms.internal.nearby.zzdo r0 = new com.google.android.gms.internal.nearby.zzdo
            r0.<init>(r2)
        L4c:
            r9 = r0
        L4d:
            if (r3 != 0) goto L51
        L4f:
            r13 = r4
            goto L65
        L51:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.nearby.zzdj
            if (r1 == 0) goto L5f
            r4 = r0
            com.google.android.gms.internal.nearby.zzdj r4 = (com.google.android.gms.internal.nearby.zzdj) r4
            goto L4f
        L5f:
            com.google.android.gms.internal.nearby.zzdl r4 = new com.google.android.gms.internal.nearby.zzdl
            r4.<init>(r3)
            goto L4f
        L65:
            r6 = r14
            r10 = r18
            r11 = r19
            r12 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzfq.<init>(android.os.IBinder, android.os.IBinder, android.os.IBinder, java.lang.String, java.lang.String, byte[], android.os.IBinder):void");
    }

    private zzfq(zzdz zzdzVar, zzdg zzdgVar, zzdm zzdmVar, String str, String str2, byte[] bArr, zzdj zzdjVar) {
        this.zzar = zzdzVar;
        this.zzas = zzdgVar;
        this.zzeb = zzdmVar;
        this.name = str;
        this.zzat = str2;
        this.zzau = bArr;
        this.zzec = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfq) {
            zzfq zzfqVar = (zzfq) obj;
            if (Objects.equal(this.zzar, zzfqVar.zzar) && Objects.equal(this.zzas, zzfqVar.zzas) && Objects.equal(this.zzeb, zzfqVar.zzeb) && Objects.equal(this.name, zzfqVar.name) && Objects.equal(this.zzat, zzfqVar.zzat) && Arrays.equals(this.zzau, zzfqVar.zzau) && Objects.equal(this.zzec, zzfqVar.zzec)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzar, this.zzas, this.zzeb, this.name, this.zzat, Integer.valueOf(Arrays.hashCode(this.zzau)), this.zzec);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdz zzdzVar = this.zzar;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdzVar == null ? null : zzdzVar.asBinder(), false);
        zzdg zzdgVar = this.zzas;
        SafeParcelWriter.writeIBinder(parcel, 2, zzdgVar == null ? null : zzdgVar.asBinder(), false);
        zzdm zzdmVar = this.zzeb;
        SafeParcelWriter.writeIBinder(parcel, 3, zzdmVar == null ? null : zzdmVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.name, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzau, false);
        zzdj zzdjVar = this.zzec;
        SafeParcelWriter.writeIBinder(parcel, 7, zzdjVar != null ? zzdjVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}