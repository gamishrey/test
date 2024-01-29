package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zza();
    private final String name;
    private String zzbw;
    private final long zzbx;
    private final int zzby;
    private final long zzbz;
    private final String zzca;
    private final MostRecentGameInfoEntity zzcb;
    private final PlayerLevelInfo zzcc;
    private final boolean zzcd;
    private final boolean zzce;
    private final String zzcf;
    private final Uri zzcg;
    private final String zzch;
    private final Uri zzci;
    private final String zzcj;
    private final int zzck;
    private final long zzcl;
    private final boolean zzcm;
    private final long zzcn;
    private final zzao zzco;
    private String zzj;
    private final Uri zzn;
    private final Uri zzo;
    private final String zzy;
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzal {
        zza() {
        }

        @Override // com.google.android.gms.games.zzal
        public final PlayerEntity zzc(Parcel parcel) {
            if (PlayerEntity.zzb(PlayerEntity.zzf()) || PlayerEntity.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1, -1L, false, -1L, null);
        }

        @Override // com.google.android.gms.games.zzal, android.os.Parcelable.Creator
        public final /* synthetic */ PlayerEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public PlayerEntity(Player player) {
        this.zzbw = player.getPlayerId();
        this.zzj = player.getDisplayName();
        this.zzn = player.getIconImageUri();
        this.zzy = player.getIconImageUrl();
        this.zzo = player.getHiResImageUri();
        this.zzz = player.getHiResImageUrl();
        this.zzbx = player.getRetrievedTimestamp();
        this.zzby = player.zzj();
        this.zzbz = player.getLastPlayedWithTimestamp();
        this.zzca = player.getTitle();
        this.zzcd = player.zzk();
        com.google.android.gms.games.internal.player.zza zzl = player.zzl();
        this.zzcb = zzl == null ? null : new MostRecentGameInfoEntity(zzl);
        this.zzcc = player.getLevelInfo();
        this.zzce = player.zzi();
        this.zzcf = player.zzh();
        this.name = player.getName();
        this.zzcg = player.getBannerImageLandscapeUri();
        this.zzch = player.getBannerImageLandscapeUrl();
        this.zzci = player.getBannerImagePortraitUri();
        this.zzcj = player.getBannerImagePortraitUrl();
        this.zzck = player.zzm();
        this.zzcl = player.zzn();
        this.zzcm = player.isMuted();
        this.zzcn = player.zzo();
        zzap zzp = player.zzp();
        this.zzco = zzp != null ? (zzao) zzp.freeze() : null;
        Asserts.checkNotNull(this.zzbw);
        Asserts.checkNotNull(this.zzj);
        Asserts.checkState(this.zzbx > 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public final Player freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j, int i, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, int i2, long j3, boolean z3, long j4, zzao zzaoVar) {
        this.zzbw = str;
        this.zzj = str2;
        this.zzn = uri;
        this.zzy = str3;
        this.zzo = uri2;
        this.zzz = str4;
        this.zzbx = j;
        this.zzby = i;
        this.zzbz = j2;
        this.zzca = str5;
        this.zzcd = z;
        this.zzcb = mostRecentGameInfoEntity;
        this.zzcc = playerLevelInfo;
        this.zzce = z2;
        this.zzcf = str6;
        this.name = str7;
        this.zzcg = uri3;
        this.zzch = str8;
        this.zzci = uri4;
        this.zzcj = str9;
        this.zzck = i2;
        this.zzcl = j3;
        this.zzcm = z3;
        this.zzcn = j4;
        this.zzco = zzaoVar;
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return this.zzbw;
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzh() {
        return this.zzcf;
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return this.name;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzi() {
        return this.zzce;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return this.zzy;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return this.zzz;
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return this.zzbx;
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        return this.zzbz;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzj() {
        return this.zzby;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzk() {
        return this.zzcd;
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return this.zzca;
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzca, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzcc;
    }

    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzl() {
        return this.zzcb;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return this.zzcg;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return this.zzch;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return this.zzci;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return this.zzcj;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzm() {
        return this.zzck;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzn() {
        return this.zzcl;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean isMuted() {
        return this.zzcm;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzo() {
        return this.zzcn;
    }

    @Override // com.google.android.gms.games.Player
    public final zzap zzp() {
        return this.zzco;
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzi()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzh(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Integer.valueOf(player.zzm()), Long.valueOf(player.zzn()), Boolean.valueOf(player.isMuted()), Long.valueOf(player.zzo()), player.zzp());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Player player, Object obj) {
        if (obj instanceof Player) {
            if (player == obj) {
                return true;
            }
            Player player2 = (Player) obj;
            return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzi()), Boolean.valueOf(player.zzi())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzh(), player.zzh()) && Objects.equal(player2.getName(), player.getName()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Integer.valueOf(player2.zzm()), Integer.valueOf(player.zzm())) && Objects.equal(Long.valueOf(player2.zzn()), Long.valueOf(player.zzn())) && Objects.equal(Boolean.valueOf(player2.isMuted()), Boolean.valueOf(player.isMuted())) && Objects.equal(Long.valueOf(player2.zzo()), Long.valueOf(player.zzo())) && Objects.equal(player2.zzp(), player.zzp());
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(Player player) {
        Objects.ToStringHelper add = Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzi())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zzh()).add("Name", player.getName()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("GamerFriendStatus", Integer.valueOf(player.zzm())).add("GamerFriendUpdateTimestamp", Long.valueOf(player.zzn())).add("IsMuted", Boolean.valueOf(player.isMuted())).add("totalUnlockedAchievement", Long.valueOf(player.zzo()));
        char[] cArr = {143, 171, 160, 184, 147, 174, 166, 164, 179, 167, 164, 177, 136, 173, 165, 174};
        for (int i = 0; i < 16; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        return add.add(new String(cArr), player.zzp()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
            SafeParcelWriter.writeInt(parcel, 6, this.zzby);
            SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
            SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
            SafeParcelWriter.writeParcelable(parcel, 15, this.zzcb, i, false);
            SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzcd);
            SafeParcelWriter.writeBoolean(parcel, 19, this.zzce);
            SafeParcelWriter.writeString(parcel, 20, this.zzcf, false);
            SafeParcelWriter.writeString(parcel, 21, this.name, false);
            SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
            SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
            SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
            SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
            SafeParcelWriter.writeInt(parcel, 26, this.zzck);
            SafeParcelWriter.writeLong(parcel, 27, this.zzcl);
            SafeParcelWriter.writeBoolean(parcel, 28, this.zzcm);
            SafeParcelWriter.writeLong(parcel, 29, this.zzcn);
            SafeParcelWriter.writeParcelable(parcel, 33, this.zzco, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzbw);
        parcel.writeString(this.zzj);
        Uri uri = this.zzn;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzo;
        parcel.writeString(uri2 != null ? uri2.toString() : null);
        parcel.writeLong(this.zzbx);
    }

    static /* synthetic */ Integer zzf() {
        return getUnparcelClientVersion();
    }
}