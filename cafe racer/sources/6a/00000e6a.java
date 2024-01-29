package com.soomla.rewards;

import com.soomla.SoomlaUtils;
import com.soomla.data.JSONConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RandomReward extends Reward {
    private static final String TAG = "SOOMLA RandomReward";
    private Reward mLastGivenReward;
    private List<Reward> mRewards;

    public RandomReward(String str, String str2, List<Reward> list) {
        super(str, str2);
        if (list == null || list.isEmpty()) {
            SoomlaUtils.LogError(TAG, "this reward doesn't make sense without items");
        }
        this.mRewards = list;
    }

    public RandomReward(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mRewards = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(JSONConsts.SOOM_REWARDS);
        if (optJSONArray == null) {
            SoomlaUtils.LogWarning(TAG, "reward has no meaning without children");
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Reward fromJSONObject = Reward.fromJSONObject(optJSONArray.getJSONObject(i));
            if (fromJSONObject != null) {
                this.mRewards.add(fromJSONObject);
            }
        }
    }

    @Override // com.soomla.rewards.Reward, com.soomla.SoomlaEntity
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Reward reward : this.mRewards) {
                jSONArray.put(reward.toJSONObject());
            }
            jSONObject.put(JSONConsts.SOOM_REWARDS, jSONArray);
        } catch (JSONException unused) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }
        return jSONObject;
    }

    @Override // com.soomla.rewards.Reward
    protected boolean giveInner() {
        ArrayList arrayList = new ArrayList();
        for (Reward reward : this.mRewards) {
            if (reward.canGive()) {
                arrayList.add(reward);
            }
        }
        if (arrayList.isEmpty()) {
            SoomlaUtils.LogDebug(TAG, "No more rewards to give in this Random Reward: " + this.mID);
            return false;
        }
        Reward reward2 = (Reward) arrayList.get(new Random().nextInt(arrayList.size()));
        reward2.give();
        this.mLastGivenReward = reward2;
        return true;
    }

    @Override // com.soomla.rewards.Reward
    protected boolean takeInner() {
        Reward reward = this.mLastGivenReward;
        if (reward == null) {
            return false;
        }
        boolean take = reward.take();
        this.mLastGivenReward = null;
        return take;
    }

    public List<Reward> getRewards() {
        return this.mRewards;
    }
}