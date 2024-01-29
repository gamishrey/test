package com.unity3d.services.ads.adunit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.unity3d.services.core.misc.ViewUtilities;

/* loaded from: classes.dex */
public class AdUnitTransparentActivity extends AdUnitActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.services.ads.adunit.AdUnitActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewUtilities.setBackground(this._layout, new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.services.ads.adunit.AdUnitActivity
    public void createLayout() {
        super.createLayout();
        ViewUtilities.setBackground(this._layout, new ColorDrawable(0));
    }
}