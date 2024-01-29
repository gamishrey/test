package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class ProfileSettingsEntity extends com.google.android.gms.games.internal.zzc implements Players.zza {
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    private final boolean zzcd;
    private final String zzcf;
    private final Status zzhq;
    private final boolean zzlz;
    private final boolean zzma;
    private final StockProfileImageEntity zzmb;
    private final boolean zzmc;
    private final boolean zzmd;
    private final int zzme;
    private final boolean zzmf;
    private final boolean zzmg;
    private final int zzmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileSettingsEntity(Status status, String str, boolean z, boolean z2, boolean z3, StockProfileImageEntity stockProfileImageEntity, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2) {
        this.zzhq = status;
        this.zzcf = str;
        this.zzlz = z;
        this.zzcd = z2;
        this.zzma = z3;
        this.zzmb = stockProfileImageEntity;
        this.zzmc = z4;
        this.zzmd = z5;
        this.zzme = i;
        this.zzmf = z6;
        this.zzmg = z7;
        this.zzmh = i2;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final String zzh() {
        return this.zzcf;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzw() {
        return this.zzlz;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzk() {
        return this.zzcd;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzu() {
        return this.zzma;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final StockProfileImage zzv() {
        return this.zzmb;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzx() {
        return this.zzmc;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzy() {
        return this.zzmd;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzz() {
        return this.zzmf;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final boolean zzaa() {
        return this.zzmg;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzhq;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final int zzab() {
        return this.zzme;
    }

    @Override // com.google.android.gms.games.Players.zza
    public final int zzac() {
        return this.zzmh;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzcf, Boolean.valueOf(this.zzlz), Boolean.valueOf(this.zzcd), Boolean.valueOf(this.zzma), this.zzhq, this.zzmb, Boolean.valueOf(this.zzmc), Boolean.valueOf(this.zzmd), Integer.valueOf(this.zzme), Boolean.valueOf(this.zzmf), Boolean.valueOf(this.zzmg), Integer.valueOf(this.zzmh));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Players.zza) {
            if (this == obj) {
                return true;
            }
            Players.zza zzaVar = (Players.zza) obj;
            return Objects.equal(this.zzcf, zzaVar.zzh()) && Objects.equal(Boolean.valueOf(this.zzlz), Boolean.valueOf(zzaVar.zzw())) && Objects.equal(Boolean.valueOf(this.zzcd), Boolean.valueOf(zzaVar.zzk())) && Objects.equal(Boolean.valueOf(this.zzma), Boolean.valueOf(zzaVar.zzu())) && Objects.equal(this.zzhq, zzaVar.getStatus()) && Objects.equal(this.zzmb, zzaVar.zzv()) && Objects.equal(Boolean.valueOf(this.zzmc), Boolean.valueOf(zzaVar.zzx())) && Objects.equal(Boolean.valueOf(this.zzmd), Boolean.valueOf(zzaVar.zzy())) && this.zzme == zzaVar.zzab() && this.zzmf == zzaVar.zzz() && this.zzmg == zzaVar.zzaa() && this.zzmh == zzaVar.zzac();
        }
        return false;
    }

    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("GamerTag", this.zzcf).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzlz)).add("IsProfileVisible", Boolean.valueOf(this.zzcd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zzma)).add("Status", this.zzhq).add("StockProfileImage", this.zzmb).add("IsProfileDiscoverable", Boolean.valueOf(this.zzmc)).add("AutoSignIn", Boolean.valueOf(this.zzmd)).add("httpErrorCode", Integer.valueOf(this.zzme)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzmf));
        char[] cArr = {128, 171, 171, 174, 182, 133, 177, 168, 164, 173, 163, 136, 173, 181, 168, 179, 164, 178};
        for (int i = 0; i < 18; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        return add.add(new String(cArr), Boolean.valueOf(this.zzmg)).add("ProfileVisibility", Integer.valueOf(this.zzmh)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcf, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzlz);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzcd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzma);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzmc);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzmd);
        SafeParcelWriter.writeInt(parcel, 9, this.zzme);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzmf);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzmg);
        SafeParcelWriter.writeInt(parcel, 12, this.zzmh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}