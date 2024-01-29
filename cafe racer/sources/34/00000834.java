package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbb {
    private static final zzbi zzjl = zzbh.zzjs;

    public static <R, PendingR extends Result, ExceptionData> Task<R> zza(PendingResult<PendingR> pendingResult, zzbi zzbiVar, PendingResultUtil.ResultConverter<PendingR, R> resultConverter, PendingResultUtil.ResultConverter<PendingR, ExceptionData> resultConverter2, zzbg<ExceptionData> zzbgVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, zzbiVar, taskCompletionSource, resultConverter, resultConverter2, zzbgVar) { // from class: com.google.android.gms.games.internal.zzba
            private final PendingResult zzjf;
            private final zzbi zzjg;
            private final TaskCompletionSource zzjh;
            private final PendingResultUtil.ResultConverter zzji;
            private final PendingResultUtil.ResultConverter zzjj;
            private final zzbg zzjk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjf = pendingResult;
                this.zzjg = zzbiVar;
                this.zzjh = taskCompletionSource;
                this.zzji = resultConverter;
                this.zzjj = resultConverter2;
                this.zzjk = zzbgVar;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbb.zza(this.zzjf, this.zzjg, this.zzjh, this.zzji, this.zzjj, this.zzjk, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<R> toTask(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, taskCompletionSource, resultConverter) { // from class: com.google.android.gms.games.internal.zzbd
            private final PendingResult zzjf;
            private final TaskCompletionSource zzjm;
            private final PendingResultUtil.ResultConverter zzjn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjf = pendingResult;
                this.zzjm = taskCompletionSource;
                this.zzjn = resultConverter;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbb.zza(this.zzjf, this.zzjm, this.zzjn, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter, zzbj<PendingR> zzbjVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(pendingResult, taskCompletionSource, resultConverter, zzbjVar) { // from class: com.google.android.gms.games.internal.zzbc
            private final PendingResult zzjf;
            private final TaskCompletionSource zzjm;
            private final PendingResultUtil.ResultConverter zzjn;
            private final zzbj zzjo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjf = pendingResult;
                this.zzjm = taskCompletionSource;
                this.zzjn = resultConverter;
                this.zzjo = zzbjVar;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbb.zza(this.zzjf, this.zzjm, this.zzjn, this.zzjo, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        return zza(pendingResult, resultConverter, (zzbj) null);
    }

    public static <R extends Releasable, PendingR extends Result> Task<AnnotatedData<R>> zzb(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(resultConverter, pendingResult, taskCompletionSource) { // from class: com.google.android.gms.games.internal.zzbf
            private final TaskCompletionSource zzjh;
            private final PendingResult zzjq;
            private final PendingResultUtil.ResultConverter zzjr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjr = resultConverter;
                this.zzjq = pendingResult;
                this.zzjh = taskCompletionSource;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbb.zza(this.zzjr, this.zzjq, this.zzjh, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<R> zza(PendingResult<PendingR> pendingResult, zzbi zzbiVar, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new PendingResult.StatusListener(zzbiVar, pendingResult, taskCompletionSource, resultConverter) { // from class: com.google.android.gms.games.internal.zzbe
            private final TaskCompletionSource zzjh;
            private final PendingResultUtil.ResultConverter zzji;
            private final zzbi zzjp;
            private final PendingResult zzjq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzjp = zzbiVar;
                this.zzjq = pendingResult;
                this.zzjh = taskCompletionSource;
                this.zzji = resultConverter;
            }

            @Override // com.google.android.gms.common.api.PendingResult.StatusListener
            public final void onComplete(Status status) {
                zzbb.zza(this.zzjp, this.zzjq, this.zzjh, this.zzji, status);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static final /* synthetic */ void zza(zzbi zzbiVar, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        if (zzbiVar.zzb(status)) {
            taskCompletionSource.setResult(resultConverter.convert(pendingResult.await(0L, TimeUnit.MILLISECONDS)));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }

    public static final /* synthetic */ void zza(PendingResultUtil.ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, Status status) {
        boolean z = status.getStatusCode() == 3;
        Releasable releasable = (Releasable) resultConverter.convert(pendingResult.await(0L, TimeUnit.MILLISECONDS));
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(releasable, z));
            return;
        }
        if (releasable != null) {
            releasable.release();
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
    }

    public static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zzbj zzbjVar, Status status) {
        boolean z = status.getStatusCode() == 3;
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(resultConverter.convert(await), z));
            return;
        }
        if (await != null && zzbjVar != null) {
            zzbjVar.zza(await);
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
    }

    public static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultConverter.convert(await));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }

    public static final /* synthetic */ void zza(PendingResult pendingResult, zzbi zzbiVar, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.ResultConverter resultConverter2, zzbg zzbgVar, Status status) {
        Result await = pendingResult.await(0L, TimeUnit.MILLISECONDS);
        if (zzbiVar.zzb(status)) {
            taskCompletionSource.setResult(resultConverter.convert(await));
            return;
        }
        Object convert = resultConverter2.convert(await);
        if (convert != null) {
            taskCompletionSource.setException(zzbgVar.zza(GamesClientStatusCodes.zza(status), convert));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }
}