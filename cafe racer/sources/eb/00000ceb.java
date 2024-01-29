package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzl implements OnFailureListener {
    private final /* synthetic */ RegisterListenerMethod zzap;
    private final /* synthetic */ zzk zzaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(zzk zzkVar, RegisterListenerMethod registerListenerMethod) {
        this.zzaq = zzkVar;
        this.zzap = registerListenerMethod;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Set set;
        synchronized (this.zzaq) {
            set = this.zzaq.zzan;
            set.remove(this.zzap.getListenerKey());
        }
    }
}