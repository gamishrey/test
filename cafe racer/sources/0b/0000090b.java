package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new zzb();
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    private final int zzsc;
    private final int zzsl;
    private final boolean zzsm;
    private final boolean zzsn;
    private final boolean zzso;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ValidCaptureModes {
    }

    public VideoConfiguration(int i, int i2, boolean z, boolean z2, boolean z3) {
        Preconditions.checkArgument(isValidQualityLevel(i, false));
        Preconditions.checkArgument(isValidCaptureMode(i2, false));
        this.zzsl = i;
        this.zzsc = i2;
        this.zzsm = z;
        this.zzsn = z2;
        this.zzso = z3;
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return true;
            }
            if (i != 1) {
                return false;
            }
        }
        return z;
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        if (i != -1) {
            z = true;
            if (i != 0 && i != 1 && i != 2 && i != 3) {
                return false;
            }
        }
        return z;
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private int zzsc;
        private int zzsl;
        private boolean zzsn = true;
        private boolean zzso = true;
        private boolean zzsm = true;

        public Builder(int i, int i2) {
            this.zzsl = i;
            this.zzsc = i2;
        }

        public final Builder setQualityLevel(int i) {
            this.zzsl = i;
            return this;
        }

        public final Builder setCaptureMode(int i) {
            this.zzsc = i;
            return this;
        }

        public final Builder setMicEnabled(boolean z) {
            this.zzso = z;
            return this;
        }

        public final Builder setCameraEnabled(boolean z) {
            this.zzsn = z;
            return this;
        }

        public final VideoConfiguration build() {
            return new VideoConfiguration(this.zzsl, this.zzsc, this.zzsm, this.zzsn, this.zzso);
        }
    }

    public final int getQualityLevel() {
        return this.zzsl;
    }

    public final int getCaptureMode() {
        return this.zzsc;
    }

    public final boolean getCameraEnabled() {
        return this.zzsn;
    }

    public final boolean getMicEnabled() {
        return this.zzso;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getQualityLevel());
        SafeParcelWriter.writeInt(parcel, 2, getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzsm);
        SafeParcelWriter.writeBoolean(parcel, 8, getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel, 9, getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}