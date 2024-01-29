package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public class Logger {
    private final String mTag;
    private final String zzey;
    private final GmsLogger zzfk;
    private final int zzfl;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L6
            java.lang.String r8 = ""
            goto L36
        L6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L28
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L22
            java.lang.String r4 = ","
            r0.append(r4)
        L22:
            r0.append(r3)
            int r2 = r2 + 1
            goto L12
        L28:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L36:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    private Logger(String str, String str2) {
        this.zzey = str2;
        this.mTag = str;
        this.zzfk = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzfl = i;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isLoggable(int i) {
        return this.zzfl <= i;
    }

    public void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public void v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr), th);
        }
    }

    public void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }

    public void d(String str, Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr), th);
        }
    }

    public void i(String str, Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    public void w(String str, Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }

    public void e(String str, Object... objArr) {
        Log.e(this.mTag, format(str, objArr));
    }

    public void e(String str, Throwable th, Object... objArr) {
        Log.e(this.mTag, format(str, objArr), th);
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    public void wtf(Throwable th) {
        Log.wtf(this.mTag, th);
    }

    protected String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzey.concat(str);
    }
}