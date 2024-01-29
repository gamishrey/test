package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzc;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class ExperienceEventEntity extends zzc implements ExperienceEvent {
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    private final int type;
    private final String zzll;
    private final GameEntity zzlm;
    private final String zzln;
    private final String zzlo;
    private final long zzlp;
    private final long zzlq;
    private final long zzlr;
    private final int zzls;
    private final Uri zzn;
    private final String zzy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExperienceEventEntity(String str, GameEntity gameEntity, String str2, String str3, String str4, Uri uri, long j, long j2, long j3, int i, int i2) {
        this.zzll = str;
        this.zzlm = gameEntity;
        this.zzln = str2;
        this.zzlo = str3;
        this.zzy = str4;
        this.zzn = uri;
        this.zzlp = j;
        this.zzlq = j2;
        this.zzlr = j3;
        this.type = i;
        this.zzls = i2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ ExperienceEvent freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcw() {
        return this.zzll;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Game getGame() {
        return this.zzlm;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcx() {
        return this.zzln;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcy() {
        return this.zzlo;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String getIconImageUrl() {
        return this.zzy;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Uri getIconImageUri() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcz() {
        return this.zzlp;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzda() {
        return this.zzlq;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzdb() {
        return this.zzlr;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int getType() {
        return this.type;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzdc() {
        return this.zzls;
    }

    public final int hashCode() {
        return Objects.hashCode(zzcw(), getGame(), zzcx(), zzcy(), getIconImageUrl(), getIconImageUri(), Long.valueOf(zzcz()), Long.valueOf(zzda()), Long.valueOf(zzdb()), Integer.valueOf(getType()), Integer.valueOf(zzdc()));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExperienceEvent) {
            if (this == obj) {
                return true;
            }
            ExperienceEvent experienceEvent = (ExperienceEvent) obj;
            return Objects.equal(experienceEvent.zzcw(), zzcw()) && Objects.equal(experienceEvent.getGame(), getGame()) && Objects.equal(experienceEvent.zzcx(), zzcx()) && Objects.equal(experienceEvent.zzcy(), zzcy()) && Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && Objects.equal(experienceEvent.getIconImageUri(), getIconImageUri()) && Objects.equal(Long.valueOf(experienceEvent.zzcz()), Long.valueOf(zzcz())) && Objects.equal(Long.valueOf(experienceEvent.zzda()), Long.valueOf(zzda())) && Objects.equal(Long.valueOf(experienceEvent.zzdb()), Long.valueOf(zzdb())) && Objects.equal(Integer.valueOf(experienceEvent.getType()), Integer.valueOf(getType())) && Objects.equal(Integer.valueOf(experienceEvent.zzdc()), Integer.valueOf(zzdc()));
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", zzcw()).add("Game", getGame()).add("DisplayTitle", zzcx()).add("DisplayDescription", zzcy()).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", getIconImageUri()).add("CreatedTimestamp", Long.valueOf(zzcz())).add("XpEarned", Long.valueOf(zzda())).add("CurrentXp", Long.valueOf(zzdb())).add("Type", Integer.valueOf(getType())).add("NewLevel", Integer.valueOf(zzdc())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzll, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzlm, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzln, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzlo, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzn, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzlp);
        SafeParcelWriter.writeLong(parcel, 8, this.zzlq);
        SafeParcelWriter.writeLong(parcel, 9, this.zzlr);
        SafeParcelWriter.writeInt(parcel, 10, this.type);
        SafeParcelWriter.writeInt(parcel, 11, this.zzls);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}