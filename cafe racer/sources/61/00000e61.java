package com.soomla.data;

import android.text.TextUtils;
import com.soomla.SoomlaApp;
import com.soomla.SoomlaConfig;
import com.soomla.SoomlaUtils;
import com.soomla.util.AESObfuscator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class KeyValueStorage {
    private static final String TAG = "SOOMLA KeyValueStorage";
    private static KeyValDatabase mKvDatabase;
    private static AESObfuscator mObfuscator;

    public static String getValue(String str) {
        SoomlaUtils.LogDebug(TAG, "trying to fetch a value for key: " + str);
        String keyVal = getDatabase().getKeyVal(getAESObfuscator().obfuscateString(str));
        if (keyVal != null && !TextUtils.isEmpty(keyVal)) {
            try {
                keyVal = getAESObfuscator().unobfuscateToString(keyVal);
            } catch (AESObfuscator.ValidationException e) {
                SoomlaUtils.LogError(TAG, e.getMessage());
                keyVal = "";
            }
            SoomlaUtils.LogDebug(TAG, "the fetched value is " + keyVal);
        }
        return keyVal;
    }

    public static void setNonEncryptedKeyValue(String str, String str2) {
        SoomlaUtils.LogDebug(TAG, "setting " + str2 + " for key: " + str);
        getDatabase().setKeyVal(str, getAESObfuscator().obfuscateString(str2));
    }

    public static void deleteNonEncryptedKeyValue(String str) {
        SoomlaUtils.LogDebug(TAG, "deleting " + str);
        getDatabase().deleteKeyVal(str);
    }

    public static String getNonEncryptedKeyValue(String str) {
        SoomlaUtils.LogDebug(TAG, "trying to fetch a value for key: " + str);
        String keyVal = getDatabase().getKeyVal(str);
        if (keyVal != null && !TextUtils.isEmpty(keyVal)) {
            try {
                keyVal = getAESObfuscator().unobfuscateToString(keyVal);
            } catch (AESObfuscator.ValidationException e) {
                SoomlaUtils.LogError(TAG, e.getMessage());
                keyVal = "";
            }
            SoomlaUtils.LogDebug(TAG, "the fetched value is " + keyVal);
        }
        return keyVal;
    }

    public static HashMap<String, String> getNonEncryptedQueryValues(String str) {
        SoomlaUtils.LogDebug(TAG, "trying to fetch values for query: " + str);
        HashMap<String, String> queryVals = getDatabase().getQueryVals(str);
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : queryVals.keySet()) {
            String str3 = queryVals.get(str2);
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                try {
                    hashMap.put(str2, getAESObfuscator().unobfuscateToString(str3));
                } catch (AESObfuscator.ValidationException e) {
                    SoomlaUtils.LogError(TAG, e.getMessage());
                }
            }
        }
        SoomlaUtils.LogDebug(TAG, "fetched " + hashMap.size() + " results");
        return hashMap;
    }

    public static String getOneForNonEncryptedQuery(String str) {
        SoomlaUtils.LogDebug(TAG, "trying to fetch one for query: " + str);
        String queryOne = getDatabase().getQueryOne(str);
        if (queryOne == null || TextUtils.isEmpty(queryOne)) {
            return null;
        }
        try {
            return getAESObfuscator().unobfuscateToString(queryOne);
        } catch (AESObfuscator.ValidationException e) {
            SoomlaUtils.LogError(TAG, e.getMessage());
            return null;
        }
    }

    public static int getCountForNonEncryptedQuery(String str) {
        SoomlaUtils.LogDebug(TAG, "trying to fetch count for query: " + str);
        return getDatabase().getQueryCount(str);
    }

    public static List<String> getEncryptedKeys() {
        SoomlaUtils.LogDebug(TAG, "trying to fetch all keys");
        List<String> allKeys = getDatabase().getAllKeys();
        ArrayList arrayList = new ArrayList();
        for (String str : allKeys) {
            try {
                arrayList.add(getAESObfuscator().unobfuscateToString(str));
            } catch (AESObfuscator.ValidationException e) {
                SoomlaUtils.LogDebug(TAG, e.getMessage());
            } catch (RuntimeException e2) {
                SoomlaUtils.LogError(TAG, e2.getMessage());
            }
        }
        return arrayList;
    }

    public static void setValue(String str, String str2) {
        SoomlaUtils.LogDebug(TAG, "setting " + str2 + " for key: " + str);
        getDatabase().setKeyVal(getAESObfuscator().obfuscateString(str), getAESObfuscator().obfuscateString(str2));
    }

    public static void deleteKeyValue(String str) {
        SoomlaUtils.LogDebug(TAG, "deleting " + str);
        getDatabase().deleteKeyVal(getAESObfuscator().obfuscateString(str));
    }

    public static void purge() {
        SoomlaUtils.LogDebug(TAG, "purging database");
        getDatabase().purgeDatabaseEntries(SoomlaApp.getAppContext());
    }

    private static synchronized KeyValDatabase getDatabase() {
        KeyValDatabase keyValDatabase;
        synchronized (KeyValueStorage.class) {
            if (mKvDatabase == null) {
                mKvDatabase = new KeyValDatabase(SoomlaApp.getAppContext());
            }
            keyValDatabase = mKvDatabase;
        }
        return keyValDatabase;
    }

    private static AESObfuscator getAESObfuscator() {
        if (mObfuscator == null) {
            mObfuscator = new AESObfuscator(SoomlaConfig.obfuscationSalt, SoomlaApp.getAppContext().getPackageName(), SoomlaUtils.deviceId());
        }
        return mObfuscator;
    }
}