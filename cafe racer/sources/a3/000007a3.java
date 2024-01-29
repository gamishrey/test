package com.google.android.gms.games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class AnnotatedData<T> {
    private final T data;
    private final boolean zze;

    public AnnotatedData(T t, boolean z) {
        this.data = t;
        this.zze = z;
    }

    public T get() {
        return this.data;
    }

    public boolean isStale() {
        return this.zze;
    }
}