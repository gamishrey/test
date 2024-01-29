package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgz extends zzha<BaseImplementation.ResultHolder<Status>> {
    private final /* synthetic */ Status zzbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgz(zzgy zzgyVar, Status status) {
        this.zzbj = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        BaseImplementation.ResultHolder resultHolder = (BaseImplementation.ResultHolder) obj;
        if (this.zzbj.isSuccess()) {
            resultHolder.setResult(this.zzbj);
        } else {
            resultHolder.setFailedResult(this.zzbj);
        }
    }
}