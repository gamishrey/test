package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class ScreenshotEntity extends com.google.android.gms.games.internal.zzc implements Parcelable, Freezable {
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzc();
    private final int height;
    private final Uri uri;
    private final int width;

    public ScreenshotEntity(Uri uri, int i, int i2) {
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.uri, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ScreenshotEntity) {
            if (this == obj) {
                return true;
            }
            ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
            return Objects.equal(screenshotEntity.uri, this.uri) && Objects.equal(Integer.valueOf(screenshotEntity.width), Integer.valueOf(this.width)) && Objects.equal(Integer.valueOf(screenshotEntity.height), Integer.valueOf(this.height));
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.uri).add("Width", Integer.valueOf(this.width)).add("Height", Integer.valueOf(this.height)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.uri, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}