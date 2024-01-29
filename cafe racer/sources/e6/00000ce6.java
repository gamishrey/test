package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class zzhe {
    private static HashMap<String, String> zzjr;
    private static Object zzjw;
    private static boolean zzjx;
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzjn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern zzjo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzjp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzjq = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzjs = new HashMap<>();
    private static final HashMap<String, Integer> zzjt = new HashMap<>();
    private static final HashMap<String, Long> zzju = new HashMap<>();
    private static final HashMap<String, Float> zzjv = new HashMap<>();
    private static String[] zzjy = new String[0];

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzhe.class) {
            if (hashMap.containsKey(str)) {
                T t2 = hashMap.get(str);
                if (t2 != null) {
                    t = t2;
                }
                return t;
            }
            return null;
        }
    }

    private static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzhe.class) {
            zza(contentResolver);
            Object obj = zzjw;
            if (zzjr.containsKey(str)) {
                String str3 = zzjr.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : zzjy) {
                if (str.startsWith(str4)) {
                    if (!zzjx || zzjr.isEmpty()) {
                        zzjr.putAll(zza(contentResolver, zzjy));
                        zzjx = true;
                        if (zzjr.containsKey(str)) {
                            String str5 = zzjr.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        zza(obj, str, string);
                        return string != null ? string : null;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            zza(obj, str, (String) null);
            if (query != null) {
                query.close();
            }
            return null;
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzjn, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzjr == null) {
            zzjq.set(false);
            zzjr = new HashMap<>();
            zzjw = new Object();
            zzjx = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzhf(null));
        } else if (zzjq.getAndSet(false)) {
            zzjr.clear();
            zzjs.clear();
            zzjt.clear();
            zzju.clear();
            zzjv.clear();
            zzjw = new Object();
            zzjx = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzhe.class) {
            if (obj == zzjw) {
                zzjr.put(str, str2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.ContentResolver r5, java.lang.String r6, boolean r7) {
        /*
            java.lang.Object r7 = zzb(r5)
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = com.google.android.gms.internal.nearby.zzhe.zzjs
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            java.lang.Object r0 = zza(r0, r6, r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L18
            boolean r5 = r0.booleanValue()
            return r5
        L18:
            r3 = 0
            java.lang.String r5 = zza(r5, r6, r3)
            r3 = 0
            if (r5 == 0) goto L68
            java.lang.String r4 = ""
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L29
            goto L68
        L29:
            java.util.regex.Pattern r4 = com.google.android.gms.internal.nearby.zzhe.zzjo
            java.util.regex.Matcher r4 = r4.matcher(r5)
            boolean r4 = r4.matches()
            if (r4 == 0) goto L36
            goto L69
        L36:
            java.util.regex.Pattern r2 = com.google.android.gms.internal.nearby.zzhe.zzjp
            java.util.regex.Matcher r2 = r2.matcher(r5)
            boolean r2 = r2.matches()
            if (r2 == 0) goto L48
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r1 = 0
            goto L69
        L48:
            java.lang.String r2 = "Gservices"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "attempt to read gservices key "
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r4 = " (value \""
            r3.append(r4)
            r3.append(r5)
            java.lang.String r5 = "\") as boolean"
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            android.util.Log.w(r2, r5)
        L68:
            r2 = r0
        L69:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r5 = com.google.android.gms.internal.nearby.zzhe.zzjs
            java.lang.Class<com.google.android.gms.internal.nearby.zzhe> r0 = com.google.android.gms.internal.nearby.zzhe.class
            monitor-enter(r0)
            java.lang.Object r3 = com.google.android.gms.internal.nearby.zzhe.zzjw     // Catch: java.lang.Throwable -> L7c
            if (r7 != r3) goto L7a
            r5.put(r6, r2)     // Catch: java.lang.Throwable -> L7c
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.google.android.gms.internal.nearby.zzhe.zzjr     // Catch: java.lang.Throwable -> L7c
            r5.remove(r6)     // Catch: java.lang.Throwable -> L7c
        L7a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            return r1
        L7c:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzhe.zza(android.content.ContentResolver, java.lang.String, boolean):boolean");
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzhe.class) {
            zza(contentResolver);
            obj = zzjw;
        }
        return obj;
    }
}