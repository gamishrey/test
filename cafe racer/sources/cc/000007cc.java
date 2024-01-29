package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class PlayerRef extends zzp implements Player {
    private final PlayerLevelInfo zzcc;
    private final com.google.android.gms.games.internal.player.zzd zzcz;
    private final com.google.android.gms.games.internal.player.zzb zzda;
    private final zzaq zzdb;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    private PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        com.google.android.gms.games.internal.player.zzd zzdVar = new com.google.android.gms.games.internal.player.zzd(null);
        this.zzcz = zzdVar;
        this.zzda = new com.google.android.gms.games.internal.player.zzb(dataHolder, i, zzdVar);
        this.zzdb = new zzaq(dataHolder, i, this.zzcz);
        if ((hasNull(this.zzcz.zzmr) || getLong(this.zzcz.zzmr) == -1) ? false : true) {
            int integer = getInteger(this.zzcz.zzms);
            int integer2 = getInteger(this.zzcz.zzmv);
            PlayerLevel playerLevel = new PlayerLevel(integer, getLong(this.zzcz.zzmt), getLong(this.zzcz.zzmu));
            this.zzcc = new PlayerLevelInfo(getLong(this.zzcz.zzmr), getLong(this.zzcz.zzmx), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(this.zzcz.zzmu), getLong(this.zzcz.zzmw)) : playerLevel);
            return;
        }
        this.zzcc = null;
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return getString(this.zzcz.zzmi);
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return getString(this.zzcz.zzmj);
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zzcz.zzmj, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzh() {
        return getString(this.zzcz.zzcf);
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return getString(this.zzcz.name);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzi() {
        return getBoolean(this.zzcz.zzng);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return parseUri(this.zzcz.zzmk);
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return getString(this.zzcz.zzml);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return parseUri(this.zzcz.zzmm);
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return getString(this.zzcz.zzmn);
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return getLong(this.zzcz.zzmo);
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zzcz.zzmq) || hasNull(this.zzcz.zzmq)) {
            return -1L;
        }
        return getLong(this.zzcz.zzmq);
    }

    @Override // com.google.android.gms.games.Player
    public final int zzj() {
        return getInteger(this.zzcz.zzmp);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzk() {
        return getBoolean(this.zzcz.zzmz);
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return getString(this.zzcz.zzca);
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zzcz.zzca, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzcc;
    }

    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzl() {
        if (hasNull(this.zzcz.zzna)) {
            return null;
        }
        return this.zzda;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zzcz.zznh);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return getString(this.zzcz.zzni);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zzcz.zznj);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return getString(this.zzcz.zznk);
    }

    @Override // com.google.android.gms.games.Player
    public final int zzm() {
        return getInteger(this.zzcz.zznl);
    }

    @Override // com.google.android.gms.games.Player
    public final long zzn() {
        return getLong(this.zzcz.zznm);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean isMuted() {
        return getBoolean(this.zzcz.zznn);
    }

    @Override // com.google.android.gms.games.Player
    public final long zzo() {
        String str = this.zzcz.zzno;
        if (!hasColumn(str) || hasNull(str)) {
            return -1L;
        }
        return getLong(str);
    }

    @Override // com.google.android.gms.games.Player
    public final zzap zzp() {
        if (this.zzdb.zzt()) {
            return this.zzdb;
        }
        return null;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.zza(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public final String toString() {
        return PlayerEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) ((Player) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Player freeze() {
        return new PlayerEntity(this);
    }
}