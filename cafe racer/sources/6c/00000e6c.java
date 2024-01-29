package com.soomla.rewards;

import com.soomla.SoomlaUtils;
import com.soomla.data.JSONConsts;
import com.soomla.data.RewardStorage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SequenceReward extends Reward {
    private static final String TAG = "SOOMLA SequenceReward";
    private List<Reward> mRewards;

    public SequenceReward(String str, String str2, List<Reward> list) {
        super(str, str2);
        if (list == null || list.isEmpty()) {
            SoomlaUtils.LogError(TAG, "this reward doesn't make sense without items");
        }
        this.mRewards = list;
    }

    public SequenceReward(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mRewards = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(JSONConsts.SOOM_REWARDS);
        if (optJSONArray == null) {
            SoomlaUtils.LogWarning(TAG, "reward has no meaning without children");
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Reward fromJSONObject = fromJSONObject(optJSONArray.getJSONObject(i));
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

    public Reward getLastGivenReward() {
        int lastSeqIdxGiven = RewardStorage.getLastSeqIdxGiven(getID());
        if (lastSeqIdxGiven < 0) {
            return null;
        }
        return this.mRewards.get(lastSeqIdxGiven);
    }

    public boolean hasMoreToGive() {
        return RewardStorage.getLastSeqIdxGiven(getID()) < this.mRewards.size();
    }

    public boolean forceNextRewardToGive(Reward reward) {
        for (int i = 0; i < this.mRewards.size(); i++) {
            if (this.mRewards.get(i).getID().equals(reward.getID())) {
                RewardStorage.setLastSeqIdxGiven(getID(), i - 1);
                return true;
            }
        }
        return false;
    }

    @Override // com.soomla.rewards.Reward
    protected boolean giveInner() {
        int lastSeqIdxGiven = RewardStorage.getLastSeqIdxGiven(getID());
        if (lastSeqIdxGiven >= this.mRewards.size()) {
            return false;
        }
        RewardStorage.setLastSeqIdxGiven(getID(), lastSeqIdxGiven + 1);
        return true;
    }

    @Override // com.soomla.rewards.Reward
    protected boolean takeInner() {
        int lastSeqIdxGiven = RewardStorage.getLastSeqIdxGiven(getID());
        if (lastSeqIdxGiven <= 0) {
            return false;
        }
        RewardStorage.setLastSeqIdxGiven(getID(), lastSeqIdxGiven - 1);
        return true;
    }

    public List<Reward> getRewards() {
        return this.mRewards;
    }
}