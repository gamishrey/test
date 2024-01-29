package com.unity3d.scar.adapter.v2000.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;

/* loaded from: classes.dex */
public class ScarRewardedAdListener extends ScarAdListener {
    private final IScarRewardedAdListenerWrapper _adListenerWrapper;
    private final ScarRewardedAd _scarRewardedAd;
    private final RewardedAdLoadCallback _adLoadCallback = new RewardedAdLoadCallback() { // from class: com.unity3d.scar.adapter.v2000.scarads.ScarRewardedAdListener.1
        public void onAdLoaded(RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            ScarRewardedAdListener.this._adListenerWrapper.onAdLoaded();
            rewardedAd.setFullScreenContentCallback(ScarRewardedAdListener.this._fullScreenContentCallback);
            ScarRewardedAdListener.this._scarRewardedAd.setGmaAd(rewardedAd);
            if (ScarRewardedAdListener.this._loadListener != null) {
                ScarRewardedAdListener.this._loadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    private final OnUserEarnedRewardListener _onUserEarnedRewardListener = new OnUserEarnedRewardListener() { // from class: com.unity3d.scar.adapter.v2000.scarads.ScarRewardedAdListener.2
        public void onUserEarnedReward(RewardItem rewardItem) {
            ScarRewardedAdListener.this._adListenerWrapper.onUserEarnedReward();
        }
    };
    private final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() { // from class: com.unity3d.scar.adapter.v2000.scarads.ScarRewardedAdListener.3
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdOpened();
        }

        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarRewardedAdListener.this._adListenerWrapper.onAdImpression();
        }
    };

    public ScarRewardedAdListener(IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper, ScarRewardedAd scarRewardedAd) {
        this._adListenerWrapper = iScarRewardedAdListenerWrapper;
        this._scarRewardedAd = scarRewardedAd;
    }

    public OnUserEarnedRewardListener getOnUserEarnedRewardListener() {
        return this._onUserEarnedRewardListener;
    }

    public RewardedAdLoadCallback getAdLoadListener() {
        return this._adLoadCallback;
    }
}