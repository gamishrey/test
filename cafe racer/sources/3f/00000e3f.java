package com.google.games.bridge;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TokenPendingResult extends PendingResult<TokenResult> {
    private static final String TAG = "TokenPendingResult";
    private CountDownLatch latch = new CountDownLatch(1);
    TokenResult result = new TokenResult();
    private ResultCallback<? super TokenResult> resultCallback;

    @Override // com.google.android.gms.common.api.PendingResult
    public TokenResult await() {
        try {
            this.latch.await();
        } catch (InterruptedException unused) {
            setStatus(14);
        }
        return getResult();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public TokenResult await(long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setStatus(15);
            }
        } catch (InterruptedException unused) {
            setStatus(14);
        }
        return getResult();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        setStatus(16);
        this.latch.countDown();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        return getResult() != null && getResult().getStatus().isCanceled();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<? super TokenResult> resultCallback) {
        if (this.latch.getCount() == 0) {
            resultCallback.onResult(getResult());
        } else {
            setCallback(resultCallback);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<? super TokenResult> resultCallback, long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setStatus(15);
            }
        } catch (InterruptedException unused) {
            setStatus(14);
        }
        resultCallback.onResult(getResult());
    }

    private synchronized void setCallback(ResultCallback<? super TokenResult> resultCallback) {
        this.resultCallback = resultCallback;
    }

    private synchronized ResultCallback<? super TokenResult> getCallback() {
        return this.resultCallback;
    }

    private synchronized TokenResult getResult() {
        return this.result;
    }

    public void setStatus(int i) {
        this.result.setStatus(i);
        this.latch.countDown();
        ResultCallback<? super TokenResult> callback = getCallback();
        TokenResult result = getResult();
        if (callback != null) {
            getCallback().onResult(result);
        }
    }

    public void setAccount(GoogleSignInAccount googleSignInAccount) {
        this.result.setAccount(googleSignInAccount);
    }
}