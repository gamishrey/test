package com.soomla.rewards;

import com.soomla.Schedule;
import com.soomla.SoomlaEntity;
import com.soomla.SoomlaUtils;
import com.soomla.data.JSONConsts;
import com.soomla.data.RewardStorage;
import com.soomla.util.JSONFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class Reward extends SoomlaEntity<Reward> {
    private static final String TAG = "SOOMLA Reward";
    private static JSONFactory<Reward> sJSONFactory = new JSONFactory<>();
    protected Schedule mSchedule;

    protected abstract boolean giveInner();

    protected abstract boolean takeInner();

    public Reward(String str, String str2) {
        super(str2, "", str);
        this.mSchedule = Schedule.AnyTimeOnce();
    }

    public Reward(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        if (jSONObject.optJSONObject(JSONConsts.SOOM_SCHEDULE) != null) {
            this.mSchedule = Schedule.AnyTimeOnce();
        } else {
            this.mSchedule = null;
        }
    }

    @Override // com.soomla.SoomlaEntity
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        try {
            jSONObject.put(JSONConsts.SOOM_SCHEDULE, this.mSchedule.toJSONObject());
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
        return jSONObject;
    }

    public static Reward fromJSONString(String str) {
        try {
            return fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Reward fromJSONObject(JSONObject jSONObject) {
        return sJSONFactory.create(jSONObject, Reward.class.getPackage().getName());
    }

    public boolean give() {
        if (!canGive()) {
            SoomlaUtils.LogDebug(TAG, "(Give) Reward is not approved by Schedule. id: " + this.mID);
            return false;
        } else if (giveInner()) {
            RewardStorage.setRewardStatus(getID(), true);
            return true;
        } else {
            return false;
        }
    }

    public boolean take() {
        if (!RewardStorage.isRewardGiven(getID())) {
            SoomlaUtils.LogDebug(TAG, "Reward not given. id: " + this.mID);
            return false;
        } else if (takeInner()) {
            RewardStorage.setRewardStatus(getID(), false);
            return true;
        } else {
            return false;
        }
    }

    public boolean canGive() {
        return this.mSchedule.approve(RewardStorage.getTimesGiven(getID()));
    }

    public boolean isOwned() {
        return RewardStorage.isRewardGiven(getID());
    }

    public Schedule getSchedule() {
        return this.mSchedule;
    }
}