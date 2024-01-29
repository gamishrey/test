package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzd {
    /* JADX WARN: Removed duplicated region for block: B:158:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.os.Bundle r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzd.zza(android.os.Bundle, android.os.Bundle):boolean");
    }

    public static int zza(Bundle bundle) {
        int size;
        int hashCode;
        int i;
        int hashCode2;
        Object[] objArr;
        int hashCode3;
        if (bundle == null || (size = bundle.size()) == 0) {
            return 0;
        }
        String[] strArr = (String[]) bundle.keySet().toArray(new String[size]);
        Arrays.sort(strArr);
        int i2 = 1;
        for (String str : strArr) {
            i2 *= 31;
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    hashCode = zza((Bundle) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    hashCode = Arrays.hashCode((CharSequence[]) obj);
                } else {
                    if (obj instanceof Object[]) {
                        i = 1;
                        for (Object obj2 : (Object[]) obj) {
                            i *= 31;
                            if (obj2 instanceof Bundle) {
                                hashCode3 = zza((Bundle) obj2);
                            } else if (obj2 != null) {
                                hashCode3 = obj2.hashCode();
                            }
                            i += hashCode3;
                        }
                    } else if (obj instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) obj;
                        int size2 = sparseArray.size();
                        i = 1;
                        for (int i3 = 0; i3 < size2; i3++) {
                            i = ((i * 31) + sparseArray.keyAt(i3)) * 31;
                            Object valueAt = sparseArray.valueAt(i3);
                            if (valueAt instanceof Bundle) {
                                hashCode2 = zza((Bundle) valueAt);
                            } else if (valueAt != null) {
                                hashCode2 = valueAt.hashCode();
                            }
                            i += hashCode2;
                        }
                    } else {
                        hashCode = obj.hashCode();
                    }
                    i2 += i;
                }
                i2 += hashCode;
            }
        }
        return i2;
    }
}