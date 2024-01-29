package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zaaf implements zabb {
    private final zabe zafv;
    private boolean zafw = false;

    public zaaf(zabe zabeVar) {
        this.zafv = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return (T) execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.zafv.zaeh.zahj.zac(t);
            zaaw zaawVar = this.zafv.zaeh;
            Api.Client client = zaawVar.zahd.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.zafv.zaht.containsKey(t.getClientKey())) {
                t.setFailedResult(new Status(17));
            } else {
                boolean z = client instanceof SimpleClientAdapter;
                Api.SimpleClient simpleClient = client;
                if (z) {
                    simpleClient = ((SimpleClientAdapter) client).getClient();
                }
                t.run(simpleClient);
            }
        } catch (DeadObjectException unused) {
            this.zafv.zaa(new zaai(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final boolean disconnect() {
        if (this.zafw) {
            return false;
        }
        if (this.zafv.zaeh.zaav()) {
            this.zafw = true;
            for (zack zackVar : this.zafv.zaeh.zahi) {
                zackVar.zabt();
            }
            return false;
        }
        this.zafv.zaf(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void connect() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaa(new zaah(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void onConnectionSuspended(int i) {
        this.zafv.zaf(null);
        this.zafv.zahx.zab(i, this.zafw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaak() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaeh.zahj.release();
            disconnect();
        }
    }
}