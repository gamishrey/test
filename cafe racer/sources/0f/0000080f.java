package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class StockProfileImageEntity extends com.google.android.gms.games.internal.zzc implements StockProfileImage {
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzf();
    private final Uri zzfw;
    private final String zzns;

    public StockProfileImageEntity(String str, Uri uri) {
        this.zzns = str;
        this.zzfw = uri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ StockProfileImage freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final String getImageUrl() {
        return this.zzns;
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zzal() {
        return this.zzfw;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzns, this.zzfw);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof StockProfileImage) {
            if (obj == this) {
                return true;
            }
            StockProfileImage stockProfileImage = (StockProfileImage) obj;
            return Objects.equal(this.zzns, stockProfileImage.getImageUrl()) && Objects.equal(this.zzfw, stockProfileImage.zzal());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.zzns).add("ImageUri", this.zzfw).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfw, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}