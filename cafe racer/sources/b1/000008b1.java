package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new zza();
    private final GameEntity zzlm;
    private final String zzoz;
    private final long zzpa;
    private final int zzpb;
    private final ParticipantEntity zzpc;
    private final ArrayList<ParticipantEntity> zzpd;
    private final int zzpe;
    private final int zzpf;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    static final class zza extends com.google.android.gms.games.multiplayer.zza {
        zza() {
        }

        @Override // com.google.android.gms.games.multiplayer.zza
        public final InvitationEntity zze(Parcel parcel) {
            if (InvitationEntity.zzb(InvitationEntity.zzf()) || InvitationEntity.canUnparcelSafely(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }

        @Override // com.google.android.gms.games.multiplayer.zza, android.os.Parcelable.Creator
        public final /* synthetic */ InvitationEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationEntity(Invitation invitation) {
        this(invitation, ParticipantEntity.zza(invitation.getParticipants()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public final Invitation freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    private InvitationEntity(Invitation invitation, ArrayList<ParticipantEntity> arrayList) {
        ParticipantEntity participantEntity;
        this.zzlm = new GameEntity(invitation.getGame());
        this.zzoz = invitation.getInvitationId();
        this.zzpa = invitation.getCreationTimestamp();
        this.zzpb = invitation.getInvitationType();
        this.zzpe = invitation.getVariant();
        this.zzpf = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        this.zzpd = arrayList;
        ArrayList<ParticipantEntity> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                participantEntity = null;
                break;
            }
            ParticipantEntity participantEntity2 = arrayList2.get(i);
            i++;
            participantEntity = participantEntity2;
            if (participantEntity.getParticipantId().equals(participantId)) {
                break;
            }
        }
        Preconditions.checkNotNull(participantEntity, "Must have a valid inviter!");
        this.zzpc = participantEntity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationEntity(GameEntity gameEntity, String str, long j, int i, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int i2, int i3) {
        this.zzlm = gameEntity;
        this.zzoz = str;
        this.zzpa = j;
        this.zzpb = i;
        this.zzpc = participantEntity;
        this.zzpd = arrayList;
        this.zzpe = i2;
        this.zzpf = i3;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Game getGame() {
        return this.zzlm;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final String getInvitationId() {
        return this.zzoz;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Participant getInviter() {
        return this.zzpc;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final long getCreationTimestamp() {
        return this.zzpa;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpd);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getInvitationType() {
        return this.zzpb;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getVariant() {
        return this.zzpe;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getAvailableAutoMatchSlots() {
        return this.zzpf;
    }

    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        this.zzlm.setShouldDowngrade(z);
        this.zzpc.setShouldDowngrade(z);
        int size = this.zzpd.size();
        for (int i = 0; i < size; i++) {
            this.zzpd.get(i).setShouldDowngrade(z);
        }
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Invitation invitation) {
        return Objects.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Invitation invitation, Object obj) {
        if (obj instanceof Invitation) {
            if (invitation == obj) {
                return true;
            }
            Invitation invitation2 = (Invitation) obj;
            return Objects.equal(invitation2.getGame(), invitation.getGame()) && Objects.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && Objects.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && Objects.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && Objects.equal(invitation2.getInviter(), invitation.getInviter()) && Objects.equal(invitation2.getParticipants(), invitation.getParticipants()) && Objects.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && Objects.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(Invitation invitation) {
        return Objects.toStringHelper(invitation).add("Game", invitation.getGame()).add("InvitationId", invitation.getInvitationId()).add("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).add("InvitationType", Integer.valueOf(invitation.getInvitationType())).add("Inviter", invitation.getInviter()).add("Participants", invitation.getParticipants()).add("Variant", Integer.valueOf(invitation.getVariant())).add("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
            SafeParcelWriter.writeString(parcel, 2, getInvitationId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getInvitationType());
            SafeParcelWriter.writeParcelable(parcel, 5, getInviter(), i, false);
            SafeParcelWriter.writeTypedList(parcel, 6, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 7, getVariant());
            SafeParcelWriter.writeInt(parcel, 8, getAvailableAutoMatchSlots());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        this.zzlm.writeToParcel(parcel, i);
        parcel.writeString(this.zzoz);
        parcel.writeLong(this.zzpa);
        parcel.writeInt(this.zzpb);
        this.zzpc.writeToParcel(parcel, i);
        int size = this.zzpd.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.zzpd.get(i2).writeToParcel(parcel, i);
        }
    }

    static /* synthetic */ Integer zzf() {
        return getUnparcelClientVersion();
    }
}