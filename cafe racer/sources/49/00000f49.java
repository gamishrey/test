package com.unity3d.scar.adapter.common.scarads;

import android.app.Activity;

/* loaded from: classes.dex */
public interface IScarAd {
    void loadAd(IScarLoadListener iScarLoadListener);

    void show(Activity activity);
}