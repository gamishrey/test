package com.unity3d.services.core.misc;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IJsonStorageReader {
    Object get(String str);

    JSONObject getData();
}