package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IScarRewardedAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onUserEarnedReward();
}