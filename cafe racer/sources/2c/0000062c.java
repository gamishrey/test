package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class Common {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zah> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zapv;
    public static final zab zapw;

    static {
        zac zacVar = new zac();
        zapv = zacVar;
        API = new Api<>("Common.API", zacVar, CLIENT_KEY);
        zapw = new zae();
    }
}