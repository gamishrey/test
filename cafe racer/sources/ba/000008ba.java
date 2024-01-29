package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new zza();
    private final int status;
    private final PlayerEntity zzfl;
    private final String zzj;
    private final Uri zzn;
    private final Uri zzo;
    private final String zzph;
    private final String zzpi;
    private final boolean zzpj;
    private final int zzpk;
    private final ParticipantResult zzpl;
    private final String zzy;
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzc {
        zza() {
        }

        @Override // com.google.android.gms.games.multiplayer.zzc
        public final ParticipantEntity zzf(Parcel parcel) {
            if (ParticipantEntity.zzb(ParticipantEntity.zzf()) || ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new ParticipantEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0 ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }

        @Override // com.google.android.gms.games.multiplayer.zzc, android.os.Parcelable.Creator
        public final /* synthetic */ ParticipantEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public static ArrayList<ParticipantEntity> zza(List<Participant> list) {
        ParticipantEntity participantEntity;
        ArrayList<ParticipantEntity> arrayList = new ArrayList<>(list.size());
        for (Participant participant : list) {
            if (participant instanceof ParticipantEntity) {
                participantEntity = (ParticipantEntity) participant;
            } else {
                participantEntity = new ParticipantEntity(participant);
            }
            arrayList.add(participantEntity);
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public final Participant freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ParticipantEntity(com.google.android.gms.games.multiplayer.Participant r3) {
        /*
            r2 = this;
            com.google.android.gms.games.Player r0 = r3.getPlayer()
            if (r0 != 0) goto L8
            r0 = 0
            goto Le
        L8:
            com.google.android.gms.games.PlayerEntity r1 = new com.google.android.gms.games.PlayerEntity
            r1.<init>(r0)
            r0 = r1
        Le:
            r2.<init>(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.multiplayer.ParticipantEntity.<init>(com.google.android.gms.games.multiplayer.Participant):void");
    }

    private ParticipantEntity(Participant participant, PlayerEntity playerEntity) {
        this.zzph = participant.getParticipantId();
        this.zzj = participant.getDisplayName();
        this.zzn = participant.getIconImageUri();
        this.zzo = participant.getHiResImageUri();
        this.status = participant.getStatus();
        this.zzpi = participant.zzdo();
        this.zzpj = participant.isConnectedToRoom();
        this.zzfl = playerEntity;
        this.zzpk = participant.getCapabilities();
        this.zzpl = participant.getResult();
        this.zzy = participant.getIconImageUrl();
        this.zzz = participant.getHiResImageUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParticipantEntity(String str, String str2, Uri uri, Uri uri2, int i, String str3, boolean z, PlayerEntity playerEntity, int i2, ParticipantResult participantResult, String str4, String str5) {
        this.zzph = str;
        this.zzj = str2;
        this.zzn = uri;
        this.zzo = uri2;
        this.status = i;
        this.zzpi = str3;
        this.zzpj = z;
        this.zzfl = playerEntity;
        this.zzpk = i2;
        this.zzpl = participantResult;
        this.zzy = str4;
        this.zzz = str5;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getStatus() {
        return this.status;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String zzdo() {
        return this.zzpi;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final boolean isConnectedToRoom() {
        return this.zzpj;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getDisplayName() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzj;
        }
        return playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            String str = this.zzj;
            if (str == null) {
                charArrayBuffer.sizeCopied = 0;
                return;
            } else {
                DataUtils.copyStringToBuffer(str, charArrayBuffer);
                return;
            }
        }
        playerEntity.getDisplayName(charArrayBuffer);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getIconImageUri() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzn;
        }
        return playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getIconImageUrl() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzy;
        }
        return playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getHiResImageUri() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzo;
        }
        return playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getHiResImageUrl() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzz;
        }
        return playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getParticipantId() {
        return this.zzph;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Player getPlayer() {
        return this.zzfl;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final ParticipantResult getResult() {
        return this.zzpl;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getCapabilities() {
        return this.zzpk;
    }

    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity != null) {
            playerEntity.setShouldDowngrade(z);
        }
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Participant participant) {
        return Objects.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzdo(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Participant participant, Object obj) {
        if (obj instanceof Participant) {
            if (participant == obj) {
                return true;
            }
            Participant participant2 = (Participant) obj;
            return Objects.equal(participant2.getPlayer(), participant.getPlayer()) && Objects.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && Objects.equal(participant2.zzdo(), participant.zzdo()) && Objects.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && Objects.equal(participant2.getDisplayName(), participant.getDisplayName()) && Objects.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && Objects.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && Objects.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && Objects.equal(participant2.getResult(), participant.getResult()) && Objects.equal(participant2.getParticipantId(), participant.getParticipantId());
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(Participant participant) {
        return Objects.toStringHelper(participant).add("ParticipantId", participant.getParticipantId()).add("Player", participant.getPlayer()).add("Status", Integer.valueOf(participant.getStatus())).add("ClientAddress", participant.zzdo()).add("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).add("DisplayName", participant.getDisplayName()).add("IconImage", participant.getIconImageUri()).add("IconImageUrl", participant.getIconImageUrl()).add("HiResImage", participant.getHiResImageUri()).add("HiResImageUrl", participant.getHiResImageUrl()).add("Capabilities", Integer.valueOf(participant.getCapabilities())).add("Result", participant.getResult()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeInt(parcel, 5, getStatus());
            SafeParcelWriter.writeString(parcel, 6, this.zzpi, false);
            SafeParcelWriter.writeBoolean(parcel, 7, isConnectedToRoom());
            SafeParcelWriter.writeParcelable(parcel, 8, getPlayer(), i, false);
            SafeParcelWriter.writeInt(parcel, 9, this.zzpk);
            SafeParcelWriter.writeParcelable(parcel, 10, getResult(), i, false);
            SafeParcelWriter.writeString(parcel, 11, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 12, getHiResImageUrl(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzph);
        parcel.writeString(this.zzj);
        Uri uri = this.zzn;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzo;
        parcel.writeString(uri2 != null ? uri2.toString() : null);
        parcel.writeInt(this.status);
        parcel.writeString(this.zzpi);
        parcel.writeInt(this.zzpj ? 1 : 0);
        if (this.zzfl == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.zzfl.writeToParcel(parcel, i);
    }

    static /* synthetic */ Integer zzf() {
        return getUnparcelClientVersion();
    }
}