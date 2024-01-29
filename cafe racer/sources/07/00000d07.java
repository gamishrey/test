package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class zzn<E> extends zzl<E> {
    private final zzp<E> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzp<E> zzpVar, int i) {
        super(zzpVar.size(), i);
        this.zza = zzpVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzl
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}