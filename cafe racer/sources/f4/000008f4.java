package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String description;
        private Long zzrb;
        private Long zzrc;
        private BitmapTeleporter zzrd;
        private Uri zzre;

        public final Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public final Builder setPlayedTimeMillis(long j) {
            this.zzrb = Long.valueOf(j);
            return this;
        }

        public final Builder setProgressValue(long j) {
            this.zzrc = Long.valueOf(j);
            return this;
        }

        public final Builder setCoverImage(Bitmap bitmap) {
            this.zzrd = new BitmapTeleporter(bitmap);
            this.zzre = null;
            return this;
        }

        public final Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.description = snapshotMetadata.getDescription();
            this.zzrb = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzrc = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzrb.longValue() == -1) {
                this.zzrb = null;
            }
            Uri coverImageUri = snapshotMetadata.getCoverImageUri();
            this.zzre = coverImageUri;
            if (coverImageUri != null) {
                this.zzrd = null;
            }
            return this;
        }

        public final SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.description, this.zzrb, this.zzrd, this.zzre, this.zzrc);
        }
    }

    Bitmap getCoverImage();

    String getDescription();

    Long getPlayedTimeMillis();

    Long getProgressValue();

    BitmapTeleporter zzds();
}