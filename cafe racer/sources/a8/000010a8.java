package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IConfigurationLoaderListener {
    void onError(String str);

    void onSuccess(Configuration configuration);
}