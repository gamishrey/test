package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzau {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResultT> TaskApiCall<com.google.android.gms.games.internal.zzg, ResultT> zza(RemoteCall<com.google.android.gms.games.internal.zzg, TaskCompletionSource<ResultT>> remoteCall) {
        return TaskApiCall.builder().run(new RemoteCall(remoteCall) { // from class: com.google.android.gms.internal.games.zzat
            private final RemoteCall zzke;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzke = remoteCall;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                try {
                    this.zzke.accept((com.google.android.gms.games.internal.zzg) obj, taskCompletionSource);
                } catch (RemoteException | SecurityException e) {
                    taskCompletionSource.trySetException(e);
                }
            }
        }).build();
    }
}