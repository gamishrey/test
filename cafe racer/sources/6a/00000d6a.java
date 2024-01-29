package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzay implements OnCompleteListener<Boolean> {
    private final /* synthetic */ TaskCompletionSource zzic;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.zzic = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Boolean> task) {
        if (task.isSuccessful()) {
            this.zzic.setResult(null);
        } else {
            this.zzic.setException(task.getException());
        }
    }
}