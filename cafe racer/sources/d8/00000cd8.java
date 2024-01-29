package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzgr {
    private static final ParcelUuid zzgm = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzgn;
    private final List<ParcelUuid> zzgo;
    private final SparseArray<byte[]> zzgp;
    private final Map<ParcelUuid, byte[]> zzgq;
    private final int zzgr;
    private final String zzgs;
    private final byte[] zzgt;

    private zzgr(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.zzgo = list;
        this.zzgp = sparseArray;
        this.zzgq = map;
        this.zzgs = str;
        this.zzgn = i;
        this.zzgr = i2;
        this.zzgt = bArr;
    }

    private static int zza(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(zze(zza(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.nearby.zzgr zzd(byte[] r13) {
        /*
            r0 = 0
            if (r13 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = -1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r11 = r0
            r9 = -1
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
        L1b:
            int r2 = r13.length     // Catch: java.lang.Exception -> L98
            if (r1 >= r2) goto L87
            int r2 = r1 + 1
            r1 = r13[r1]     // Catch: java.lang.Exception -> L98
            r4 = 255(0xff, float:3.57E-43)
            r1 = r1 & r4
            if (r1 == 0) goto L87
            int r1 = r1 + (-1)
            int r5 = r2 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L98
            r2 = r2 & r4
            r6 = 22
            r12 = 2
            if (r2 == r6) goto L72
            if (r2 == r4) goto L5b
            switch(r2) {
                case 1: goto L56;
                case 2: goto L52;
                case 3: goto L52;
                case 4: goto L4d;
                case 5: goto L4d;
                case 6: goto L47;
                case 7: goto L47;
                case 8: goto L3d;
                case 9: goto L3d;
                case 10: goto L39;
                default: goto L38;
            }     // Catch: java.lang.Exception -> L98
        L38:
            goto L85
        L39:
            r2 = r13[r5]     // Catch: java.lang.Exception -> L98
            r10 = r2
            goto L85
        L3d:
            java.lang.String r11 = new java.lang.String     // Catch: java.lang.Exception -> L98
            byte[] r2 = zza(r13, r5, r1)     // Catch: java.lang.Exception -> L98
            r11.<init>(r2)     // Catch: java.lang.Exception -> L98
            goto L85
        L47:
            r2 = 16
            zza(r13, r5, r1, r2, r3)     // Catch: java.lang.Exception -> L98
            goto L85
        L4d:
            r2 = 4
            zza(r13, r5, r1, r2, r3)     // Catch: java.lang.Exception -> L98
            goto L85
        L52:
            zza(r13, r5, r1, r12, r3)     // Catch: java.lang.Exception -> L98
            goto L85
        L56:
            r2 = r13[r5]     // Catch: java.lang.Exception -> L98
            r2 = r2 & r4
            r9 = r2
            goto L85
        L5b:
            int r2 = r5 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L98
            r2 = r2 & r4
            int r2 = r2 << 8
            r6 = r13[r5]     // Catch: java.lang.Exception -> L98
            r4 = r4 & r6
            int r2 = r2 + r4
            int r4 = r5 + 2
            int r6 = r1 + (-2)
            byte[] r4 = zza(r13, r4, r6)     // Catch: java.lang.Exception -> L98
            r7.put(r2, r4)     // Catch: java.lang.Exception -> L98
            goto L85
        L72:
            byte[] r2 = zza(r13, r5, r12)     // Catch: java.lang.Exception -> L98
            android.os.ParcelUuid r2 = zze(r2)     // Catch: java.lang.Exception -> L98
            int r4 = r5 + 2
            int r6 = r1 + (-2)
            byte[] r4 = zza(r13, r4, r6)     // Catch: java.lang.Exception -> L98
            r8.put(r2, r4)     // Catch: java.lang.Exception -> L98
        L85:
            int r1 = r1 + r5
            goto L1b
        L87:
            boolean r1 = r3.isEmpty()     // Catch: java.lang.Exception -> L98
            if (r1 == 0) goto L8f
            r6 = r0
            goto L90
        L8f:
            r6 = r3
        L90:
            com.google.android.gms.internal.nearby.zzgr r1 = new com.google.android.gms.internal.nearby.zzgr     // Catch: java.lang.Exception -> L98
            r5 = r1
            r12 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L98
            return r1
        L98:
            r1 = move-exception
            java.lang.String r2 = "Unable to parse scan record: "
            java.lang.String r13 = java.util.Arrays.toString(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r3 = r13.length()
            if (r3 == 0) goto Lae
            java.lang.String r13 = r2.concat(r13)
            goto Lb3
        Lae:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r2)
        Lb3:
            java.lang.String r2 = "BleRecord"
            android.util.Log.w(r2, r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzgr.zzd(byte[]):com.google.android.gms.internal.nearby.zzgr");
    }

    private static ParcelUuid zze(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("uuidBytes length invalid - ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString());
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                } else {
                    j = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
                }
                return new ParcelUuid(new UUID(zzgm.getUuid().getMostSignificantBits() + (j << 32), zzgm.getUuid().getLeastSignificantBits()));
            }
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgr) {
            return Arrays.equals(this.zzgt, ((zzgr) obj).zzgt);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzgt);
    }

    public final String toString() {
        String sb;
        int i = this.zzgn;
        String valueOf = String.valueOf(this.zzgo);
        SparseArray<byte[]> sparseArray = this.zzgp;
        StringBuilder sb2 = new StringBuilder();
        String str = "{}";
        int i2 = 0;
        if (sparseArray.size() <= 0) {
            sb = "{}";
        } else {
            sb2.append('{');
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (i3 > 0) {
                    sb2.append(", ");
                }
                int keyAt = sparseArray.keyAt(i3);
                byte[] valueAt = sparseArray.valueAt(i3);
                sb2.append(keyAt);
                sb2.append('=');
                sb2.append(valueAt == null ? null : Hex.bytesToStringUppercase(valueAt));
            }
            sb2.append('}');
            sb = sb2.toString();
        }
        Map<ParcelUuid, byte[]> map = this.zzgq;
        StringBuilder sb3 = new StringBuilder();
        if (map.keySet().size() > 0) {
            sb3.append('{');
            for (Map.Entry<ParcelUuid, byte[]> entry : map.entrySet()) {
                if (i2 > 0) {
                    sb3.append(", ");
                }
                sb3.append(entry.getKey());
                sb3.append('=');
                byte[] value = entry.getValue();
                sb3.append(value == null ? null : Hex.bytesToStringUppercase(value));
                i2++;
            }
            sb3.append('}');
            str = sb3.toString();
        }
        int i4 = this.zzgr;
        String str2 = this.zzgs;
        StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf).length() + 139 + String.valueOf(sb).length() + String.valueOf(str).length() + String.valueOf(str2).length());
        sb4.append("BleRecord [mAdvertiseFlags=");
        sb4.append(i);
        sb4.append(", mServiceUuids=");
        sb4.append(valueOf);
        sb4.append(", mManufacturerSpecificData=");
        sb4.append(sb);
        sb4.append(", mServiceData=");
        sb4.append(str);
        sb4.append(", mTxPowerLevel=");
        sb4.append(i4);
        sb4.append(", mDeviceName=");
        sb4.append(str2);
        sb4.append("]");
        return sb4.toString();
    }
}