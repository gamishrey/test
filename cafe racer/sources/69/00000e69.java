package com.soomla.rewards;

import com.soomla.SoomlaUtils;
import com.soomla.data.JSONConsts;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BadgeReward extends Reward {
    private static final String TAG = "SOOMLA BadgeReward";
    private String mIconUrl;

    @Override // com.soomla.rewards.Reward
    protected boolean giveInner() {
        return true;
    }

    @Override // com.soomla.rewards.Reward
    protected boolean takeInner() {
        return true;
    }

    public BadgeReward(String str, String str2) {
        super(str, str2);
    }

    public BadgeReward(String str, String str2, String str3) {
        super(str, str2);
        this.mIconUrl = str3;
    }

    public BadgeReward(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        try {
            this.mIconUrl = jSONObject.getString(JSONConsts.SOOM_REWARD_ICONURL);
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
    }

    @Override // com.soomla.rewards.Reward, com.soomla.SoomlaEntity
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        try {
            jSONObject.put(JSONConsts.SOOM_REWARD_ICONURL, this.mIconUrl);
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
        return jSONObject;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }
}