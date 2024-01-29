package com.google.android.gms.games.video;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class CaptureState {
    private final boolean zzsb;
    private final int zzsc;
    private final int zzsd;
    private final boolean zzse;
    private final boolean zzsf;

    private CaptureState(boolean z, int i, int i2, boolean z2, boolean z3) {
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(i, true));
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(i2, true));
        this.zzsb = z;
        this.zzsc = i;
        this.zzsd = i2;
        this.zzse = z2;
        this.zzsf = z3;
    }

    public final boolean isCapturing() {
        return this.zzsb;
    }

    public final int getCaptureMode() {
        return this.zzsc;
    }

    public final int getCaptureQuality() {
        return this.zzsd;
    }

    public final boolean isOverlayVisible() {
        return this.zzse;
    }

    public final boolean isPaused() {
        return this.zzsf;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("IsCapturing", Boolean.valueOf(this.zzsb)).add("CaptureMode", Integer.valueOf(this.zzsc)).add("CaptureQuality", Integer.valueOf(this.zzsd)).add("IsOverlayVisible", Boolean.valueOf(this.zzse)).add("IsPaused", Boolean.valueOf(this.zzsf)).toString();
    }

    public static CaptureState zzb(Bundle bundle) {
        if (bundle == null || bundle.get("IsCapturing") == null) {
            return null;
        }
        return new CaptureState(bundle.getBoolean("IsCapturing", false), bundle.getInt("CaptureMode", -1), bundle.getInt("CaptureQuality", -1), bundle.getBoolean("IsOverlayVisible", false), bundle.getBoolean("IsPaused", false));
    }
}