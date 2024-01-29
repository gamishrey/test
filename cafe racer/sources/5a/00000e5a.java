package com.soomla;

import android.text.TextUtils;
import com.soomla.data.JSONConsts;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class SoomlaEntity<T> {
    private static final String TAG = "SOOMLA SoomlaEntity";
    protected String mDescription;
    protected String mID;
    protected String mName;

    public SoomlaEntity(String str, String str2, String str3) {
        this.mName = str;
        this.mDescription = str2;
        this.mID = str3.trim();
    }

    public SoomlaEntity(JSONObject jSONObject) throws JSONException {
        this.mName = jSONObject.optString("name");
        this.mDescription = jSONObject.optString(JSONConsts.SOOM_ENTITY_DESCRIPTION);
        this.mID = jSONObject.getString(JSONConsts.SOOM_ENTITY_ID);
    }

    public JSONObject toJSONObject() {
        if (TextUtils.isEmpty(this.mID)) {
            SoomlaUtils.LogError(TAG, "This is BAD! We don't have ID in the this SoomlaEntity. Stopping here.");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            jSONObject.put(JSONConsts.SOOM_ENTITY_DESCRIPTION, this.mDescription);
            jSONObject.put(JSONConsts.SOOM_ENTITY_ID, this.mID);
            jSONObject.put(JSONConsts.SOOM_CLASSNAME, SoomlaUtils.getClassName(this));
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SoomlaEntity) {
            return this.mID.equals(((SoomlaEntity) obj).mID);
        }
        return false;
    }

    public int hashCode() {
        String str = this.mID;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public T clone(String str) {
        JSONObject jSONObject = toJSONObject();
        try {
            jSONObject.put(JSONConsts.SOOM_ENTITY_ID, str);
            return (T) getClass().getDeclaredConstructor(JSONObject.class).newInstance(jSONObject);
        } catch (IllegalAccessException e) {
            SoomlaUtils.LogError(TAG, "Error when trying to clone SoomlaEntity(" + getClass().getSimpleName() + "): " + e.getLocalizedMessage());
            return null;
        } catch (InstantiationException e2) {
            SoomlaUtils.LogError(TAG, "Error when trying to clone SoomlaEntity(" + getClass().getSimpleName() + "): " + e2.getLocalizedMessage());
            return null;
        } catch (NoSuchMethodException e3) {
            SoomlaUtils.LogError(TAG, "Error when trying to clone SoomlaEntity(" + getClass().getSimpleName() + "): " + e3.getLocalizedMessage());
            return null;
        } catch (InvocationTargetException e4) {
            SoomlaUtils.LogError(TAG, "Error when trying to clone SoomlaEntity(" + getClass().getSimpleName() + "): " + e4.getLocalizedMessage());
            return null;
        } catch (JSONException e5) {
            SoomlaUtils.LogError(TAG, "Error when trying to clone SoomlaEntity(" + getClass().getSimpleName() + "): " + e5.getLocalizedMessage());
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getID() {
        return this.mID;
    }
}