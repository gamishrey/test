package com.soomla.core.unity;

import com.soomla.BusProvider;
import com.soomla.SoomlaUtils;
import com.soomla.events.CustomEvent;
import com.soomla.events.RewardGivenEvent;
import com.soomla.events.RewardTakenEvent;
import com.squareup.otto.Subscribe;
import com.unity3d.player.UnityPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SoomlaEventHandler {
    private static SoomlaEventHandler mLocalEventHandler;

    public static void initialize() {
        SoomlaUtils.LogDebug("SOOMLA Unity SoomlaEventHandler", "Initializing SoomlaEventHandler ...");
        mLocalEventHandler = new SoomlaEventHandler();
    }

    public SoomlaEventHandler() {
        BusProvider.getInstance().register(this);
    }

    @Subscribe
    public void onRewardGiven(RewardGivenEvent rewardGivenEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rewardId", rewardGivenEvent.RewardId);
            UnityPlayer.UnitySendMessage("CoreEvents", "onRewardGiven", jSONObject.toString());
        } catch (JSONException unused) {
            SoomlaUtils.LogError("SOOMLA SoomlaEventHandler", "This is BAD! couldn't create JSON for onRewardGiven event.");
        }
    }

    @Subscribe
    public void onRewardTaken(RewardTakenEvent rewardTakenEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rewardId", rewardTakenEvent.RewardId);
            UnityPlayer.UnitySendMessage("CoreEvents", "onRewardTaken", jSONObject.toString());
        } catch (JSONException unused) {
            SoomlaUtils.LogError("SOOMLA SoomlaEventHandler", "This is BAD! couldn't create JSON for onRewardGiven event.");
        }
    }

    @Subscribe
    public void onCustom(CustomEvent customEvent) {
        if (customEvent.Sender == this) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", customEvent.getName());
            JSONObject jSONObject2 = new JSONObject();
            if (customEvent.getExtra() != null) {
                for (String str : customEvent.getExtra().keySet()) {
                    jSONObject2.put(str, customEvent.getExtra().get(str));
                }
            }
            jSONObject.put("extra", jSONObject2);
            UnityPlayer.UnitySendMessage("CoreEvents", "onCustomEvent", jSONObject.toString());
        } catch (JSONException unused) {
            SoomlaUtils.LogError("SOOMLA SoomlaEventHandler", "This is BAD! couldn't create JSON for onMarketItemsRefreshFinished event.");
        }
    }
}