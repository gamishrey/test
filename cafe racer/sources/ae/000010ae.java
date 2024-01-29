package com.unity3d.services.core.configuration;

/* loaded from: classes.dex */
public interface IPrivacyConfigurationListener {
    void onError(String str);

    void onSuccess(PrivacyConfig privacyConfig);
}