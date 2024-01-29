package com.soomla.util;

import com.soomla.SoomlaUtils;
import com.soomla.data.JSONConsts;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JSONFactory<T> {
    public static final String TAG = "SOOMLA JSONFactory";

    /* JADX WARN: Multi-variable type inference failed */
    public T create(JSONObject jSONObject, String str) {
        T t = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(JSONConsts.SOOM_CLASSNAME);
            Class<?> cls = Class.forName(str + "." + string);
            SoomlaUtils.LogDebug(TAG, "creating with: " + str + "." + string);
            if (cls != null) {
                t = cls.getDeclaredConstructor(JSONObject.class).newInstance(jSONObject);
            } else {
                SoomlaUtils.LogError(TAG, "unknown class name:" + string);
            }
        } catch (ClassNotFoundException e) {
            SoomlaUtils.LogError(TAG, "fromJSONObject ClassNotFoundException:" + e.getMessage());
        } catch (IllegalAccessException e2) {
            SoomlaUtils.LogError(TAG, "fromJSONObject IllegalAccessException:" + e2.getMessage());
        } catch (InstantiationException e3) {
            SoomlaUtils.LogError(TAG, "fromJSONObject InstantiationException:" + e3.getMessage());
        } catch (NoSuchMethodException e4) {
            SoomlaUtils.LogError(TAG, "fromJSONObject no JSONObject constructor found:" + e4.getMessage());
        } catch (InvocationTargetException e5) {
            SoomlaUtils.LogError(TAG, "fromJSONObject InvocationTargetException:" + e5.getMessage());
            SoomlaUtils.LogError(TAG, "fromJSONObject InvocationTargetException[cause]:" + e5.getCause());
        } catch (JSONException e6) {
            SoomlaUtils.LogError(TAG, "fromJSONObject JSONException:" + e6.getMessage());
        }
        return t;
    }
}