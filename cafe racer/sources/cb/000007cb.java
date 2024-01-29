package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class PlayerLevelInfo extends com.google.android.gms.games.internal.zzc {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzan();
    private final long zzcs;
    private final long zzct;
    private final PlayerLevel zzcu;
    private final PlayerLevel zzcv;

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zzcs = j;
        this.zzct = j2;
        this.zzcu = playerLevel;
        this.zzcv = playerLevel2;
    }

    public final long getCurrentXpTotal() {
        return this.zzcs;
    }

    public final long getLastLevelUpTimestamp() {
        return this.zzct;
    }

    public final PlayerLevel getCurrentLevel() {
        return this.zzcu;
    }

    public final PlayerLevel getNextLevel() {
        return this.zzcv;
    }

    public final boolean isMaxLevel() {
        return this.zzcu.equals(this.zzcv);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PlayerLevelInfo) {
            if (obj == this) {
                return true;
            }
            PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
            return Objects.equal(Long.valueOf(this.zzcs), Long.valueOf(playerLevelInfo.zzcs)) && Objects.equal(Long.valueOf(this.zzct), Long.valueOf(playerLevelInfo.zzct)) && Objects.equal(this.zzcu, playerLevelInfo.zzcu) && Objects.equal(this.zzcv, playerLevelInfo.zzcv);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzcs), Long.valueOf(this.zzct), this.zzcu, this.zzcv);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}