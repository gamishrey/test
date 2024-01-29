package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zaaj implements Runnable {
    private final /* synthetic */ zaak zafz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaaj(zaak zaakVar) {
        this.zafz = zaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        googleApiAvailabilityLight = this.zafz.zaey;
        context = this.zafz.mContext;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}