package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* loaded from: classes.dex */
public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfy> CREATOR = new zzgb();
    private long durationMillis;
    private String name;
    private zzdj zzec;
    private zzec zzeh;
    private zzdd zzei;
    private AdvertisingOptions zzej;
    private String zzu;

    private zzfy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzfy(android.os.IBinder r15, android.os.IBinder r16, java.lang.String r17, java.lang.String r18, long r19, com.google.android.gms.nearby.connection.AdvertisingOptions r21, android.os.IBinder r22) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r22
            r3 = 0
            if (r0 != 0) goto La
            r6 = r3
            goto L1d
        La:
            java.lang.String r4 = "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener"
            android.os.IInterface r4 = r15.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.nearby.zzec
            if (r5 == 0) goto L17
            com.google.android.gms.internal.nearby.zzec r4 = (com.google.android.gms.internal.nearby.zzec) r4
            goto L1c
        L17:
            com.google.android.gms.internal.nearby.zzee r4 = new com.google.android.gms.internal.nearby.zzee
            r4.<init>(r15)
        L1c:
            r6 = r4
        L1d:
            if (r1 != 0) goto L21
            r7 = r3
            goto L34
        L21:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback"
            android.os.IInterface r0 = r1.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.nearby.zzdd
            if (r4 == 0) goto L2e
            com.google.android.gms.internal.nearby.zzdd r0 = (com.google.android.gms.internal.nearby.zzdd) r0
            goto L33
        L2e:
            com.google.android.gms.internal.nearby.zzdf r0 = new com.google.android.gms.internal.nearby.zzdf
            r0.<init>(r1)
        L33:
            r7 = r0
        L34:
            if (r2 != 0) goto L38
        L36:
            r13 = r3
            goto L4c
        L38:
            java.lang.String r0 = "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.nearby.zzdj
            if (r1 == 0) goto L46
            r3 = r0
            com.google.android.gms.internal.nearby.zzdj r3 = (com.google.android.gms.internal.nearby.zzdj) r3
            goto L36
        L46:
            com.google.android.gms.internal.nearby.zzdl r3 = new com.google.android.gms.internal.nearby.zzdl
            r3.<init>(r2)
            goto L36
        L4c:
            r5 = r14
            r8 = r17
            r9 = r18
            r10 = r19
            r12 = r21
            r5.<init>(r6, r7, r8, r9, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzfy.<init>(android.os.IBinder, android.os.IBinder, java.lang.String, java.lang.String, long, com.google.android.gms.nearby.connection.AdvertisingOptions, android.os.IBinder):void");
    }

    private zzfy(zzec zzecVar, zzdd zzddVar, String str, String str2, long j, AdvertisingOptions advertisingOptions, zzdj zzdjVar) {
        this.zzeh = zzecVar;
        this.zzei = zzddVar;
        this.name = str;
        this.zzu = str2;
        this.durationMillis = j;
        this.zzej = advertisingOptions;
        this.zzec = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfy) {
            zzfy zzfyVar = (zzfy) obj;
            if (Objects.equal(this.zzeh, zzfyVar.zzeh) && Objects.equal(this.zzei, zzfyVar.zzei) && Objects.equal(this.name, zzfyVar.name) && Objects.equal(this.zzu, zzfyVar.zzu) && Objects.equal(Long.valueOf(this.durationMillis), Long.valueOf(zzfyVar.durationMillis)) && Objects.equal(this.zzej, zzfyVar.zzej) && Objects.equal(this.zzec, zzfyVar.zzec)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzeh, this.zzei, this.name, this.zzu, Long.valueOf(this.durationMillis), this.zzej, this.zzec);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzec zzecVar = this.zzeh;
        SafeParcelWriter.writeIBinder(parcel, 1, zzecVar == null ? null : zzecVar.asBinder(), false);
        zzdd zzddVar = this.zzei;
        SafeParcelWriter.writeIBinder(parcel, 2, zzddVar == null ? null : zzddVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.name, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzu, false);
        SafeParcelWriter.writeLong(parcel, 5, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzej, i, false);
        zzdj zzdjVar = this.zzec;
        SafeParcelWriter.writeIBinder(parcel, 7, zzdjVar != null ? zzdjVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}