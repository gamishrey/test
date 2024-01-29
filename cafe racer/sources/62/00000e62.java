package com.soomla.data;

import android.text.TextUtils;
import com.soomla.BusProvider;
import com.soomla.SoomlaUtils;
import com.soomla.events.RewardGivenEvent;
import com.soomla.events.RewardTakenEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RewardStorage {
    private static final String DB_KEY_REWARDS = "soomla.rewards.";
    private static final String TAG = "SOOMLA RewardStorage";

    private static String keyRewards(String str, String str2) {
        return DB_KEY_REWARDS + str + "." + str2;
    }

    private static String keyRewardTimesGiven(String str) {
        return keyRewards(str, "timesGiven");
    }

    private static String keyRewardLastGiven(String str) {
        return keyRewards(str, "lastGiven");
    }

    private static String keyRewardIdxSeqGiven(String str) {
        return keyRewards(str, "seq.idx");
    }

    public static void setRewardStatus(String str, boolean z) {
        setRewardStatus(str, z, true);
    }

    public static void setRewardStatus(String str, boolean z, boolean z2) {
        setTimesGiven(str, z, z2);
    }

    public static boolean isRewardGiven(String str) {
        return getTimesGiven(str) > 0;
    }

    public static int getLastSeqIdxGiven(String str) {
        String value = KeyValueStorage.getValue(keyRewardIdxSeqGiven(str));
        if (value == null) {
            return -1;
        }
        return Integer.parseInt(value);
    }

    public static void setLastSeqIdxGiven(String str, int i) {
        KeyValueStorage.setValue(keyRewardIdxSeqGiven(str), String.valueOf(i));
    }

    public static int getTimesGiven(String str) {
        String value = KeyValueStorage.getValue(keyRewardTimesGiven(str));
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public static Date getLastGivenTime(String str) {
        long lastGivenTimeMillis = getLastGivenTimeMillis(str);
        if (lastGivenTimeMillis == 0) {
            return null;
        }
        Date date = new Date();
        date.setTime(lastGivenTimeMillis);
        return date;
    }

    public static long getLastGivenTimeMillis(String str) {
        String value = KeyValueStorage.getValue(keyRewardLastGiven(str));
        if (TextUtils.isEmpty(value)) {
            return 0L;
        }
        return Long.parseLong(value);
    }

    public static void setLastGivenTimeMillis(String str, long j) {
        KeyValueStorage.setValue(keyRewardLastGiven(str), String.valueOf(j));
    }

    private static void setTimesGiven(String str, boolean z, boolean z2) {
        resetTimesGiven(str, getTimesGiven(str) + (z ? 1 : -1));
        if (z) {
            setLastGivenTimeMillis(str, new Date().getTime());
        }
        if (z2) {
            if (z) {
                BusProvider.getInstance().post(new RewardGivenEvent(str));
            } else {
                BusProvider.getInstance().post(new RewardTakenEvent(str));
            }
        }
    }

    public static void resetTimesGiven(String str, int i) {
        KeyValueStorage.setValue(keyRewardTimesGiven(str), String.valueOf(i));
    }

    public static JSONObject getRewardsState() {
        List<String> rewardIds = getRewardIds();
        JSONObject jSONObject = new JSONObject();
        for (String str : rewardIds) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("timesGiven", getTimesGiven(str));
                jSONObject2.put("lastGiven", getLastGivenTimeMillis(str));
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e) {
                SoomlaUtils.LogDebug(TAG, "Unable to set reward " + str + " state. error: " + e.getLocalizedMessage());
            }
        }
        return jSONObject;
    }

    public static boolean resetRewardsState(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        List<String> rewardIds = getRewardIds();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.has("timesGiven")) {
                    resetTimesGiven(next, jSONObject2.getInt("timesGiven"));
                }
                if (jSONObject2.has("lastGiven")) {
                    setLastGivenTimeMillis(next, jSONObject2.getLong("lastGiven"));
                }
                rewardIds.remove(next);
            }
            for (String str : rewardIds) {
                KeyValueStorage.deleteKeyValue(keyRewardTimesGiven(str));
                KeyValueStorage.deleteKeyValue(keyRewardLastGiven(str));
                KeyValueStorage.deleteKeyValue(keyRewardIdxSeqGiven(str));
            }
            return true;
        } catch (JSONException e) {
            SoomlaUtils.LogError(TAG, "Unable to set state for rewards. error: " + e.getLocalizedMessage());
            return false;
        }
    }

    private static List<String> getRewardIds() {
        List<String> encryptedKeys = KeyValueStorage.getEncryptedKeys();
        ArrayList arrayList = new ArrayList();
        if (encryptedKeys == null) {
            return arrayList;
        }
        for (String str : encryptedKeys) {
            if (str.startsWith(DB_KEY_REWARDS)) {
                String replace = str.replace(DB_KEY_REWARDS, "");
                int indexOf = replace.indexOf(46);
                if (indexOf != -1) {
                    replace = replace.substring(0, indexOf);
                }
                if (!arrayList.contains(replace)) {
                    arrayList.add(replace);
                }
            }
        }
        return arrayList;
    }
}