package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements com.google.android.gms.games.internal.game.zza {
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zza();
    private String description;
    private int type;
    private String zzca;
    private Uri zzn;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzb {
        zza() {
        }

        @Override // com.google.android.gms.games.internal.game.zzb
        public final GameBadgeEntity zzd(Parcel parcel) {
            if (GameBadgeEntity.zzb(GameBadgeEntity.zzf()) || GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }

        @Override // com.google.android.gms.games.internal.game.zzb, android.os.Parcelable.Creator
        public final /* synthetic */ GameBadgeEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameBadgeEntity(int i, String str, String str2, Uri uri) {
        this.type = i;
        this.zzca = str;
        this.description = str2;
        this.zzn = uri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ com.google.android.gms.games.internal.game.zza freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final int getType() {
        return this.type;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final String getTitle() {
        return this.zzca;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final Uri getIconImageUri() {
        return this.zzn;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getType()), getTitle(), getDescription(), getIconImageUri());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof com.google.android.gms.games.internal.game.zza) {
            if (this == obj) {
                return true;
            }
            com.google.android.gms.games.internal.game.zza zzaVar = (com.google.android.gms.games.internal.game.zza) obj;
            return Objects.equal(Integer.valueOf(zzaVar.getType()), getTitle()) && Objects.equal(zzaVar.getDescription(), getIconImageUri());
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(getType())).add("Title", getTitle()).add("Description", getDescription()).add("IconImageUri", getIconImageUri()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.type);
            SafeParcelWriter.writeString(parcel, 2, this.zzca, false);
            SafeParcelWriter.writeString(parcel, 3, this.description, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzn, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.zzca);
        parcel.writeString(this.description);
        Uri uri = this.zzn;
        parcel.writeString(uri == null ? null : uri.toString());
    }

    static /* synthetic */ Integer zzf() {
        return getUnparcelClientVersion();
    }
}