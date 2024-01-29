package com.unity.purchasing.common;

/* loaded from: classes.dex */
public interface INativeStore {
    void FinishTransaction(String str, String str2);

    void Purchase(String str, String str2);

    void RetrieveProducts(String str);
}