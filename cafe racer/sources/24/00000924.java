package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzao extends com.google.android.gms.games.internal.zzc implements zzap {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    private final int zzcw;
    private final String zzcx;
    private final String zzcy;

    public zzao(zzap zzapVar) {
        this.zzcw = zzapVar.zzq();
        this.zzcx = zzapVar.zzr();
        this.zzcy = zzapVar.zzs();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zzap freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public zzao(int i, String str, String str2) {
        this.zzcw = i;
        this.zzcx = str;
        this.zzcy = str2;
    }

    @Override // com.google.android.gms.games.zzap
    public final int zzq() {
        return this.zzcw;
    }

    @Override // com.google.android.gms.games.zzap
    public final String zzr() {
        return this.zzcx;
    }

    @Override // com.google.android.gms.games.zzap
    public final String zzs() {
        return this.zzcy;
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzap zzapVar) {
        return Objects.hashCode(Integer.valueOf(zzapVar.zzq()), zzapVar.zzr(), zzapVar.zzs());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzap zzapVar, Object obj) {
        if (obj instanceof zzap) {
            if (obj == zzapVar) {
                return true;
            }
            zzap zzapVar2 = (zzap) obj;
            return zzapVar2.zzq() == zzapVar.zzq() && Objects.equal(zzapVar2.zzr(), zzapVar.zzr()) && Objects.equal(zzapVar2.zzs(), zzapVar.zzs());
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zzap zzapVar) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(zzapVar);
        char[] cArr = {133, 177, 168, 164, 173, 163, 146, 179, 160, 179, 180, 178};
        for (int i = 0; i < 12; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        Objects.ToStringHelper add = stringHelper.add(new String(cArr), Integer.valueOf(zzapVar.zzq()));
        char[] cArr2 = {141, 168, 162, 170, 173, 160, 172, 164};
        for (int i2 = 0; i2 < 8; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - '?');
        }
        Objects.ToStringHelper add2 = add.add(new String(cArr2), zzapVar.zzr());
        char[] cArr3 = {136, 173, 181, 168, 179, 160, 179, 168, 174, 173, 141, 168, 162, 170, 173, 160, 172, 164};
        for (int i3 = 0; i3 < 18; i3++) {
            cArr3[i3] = (char) (cArr3[i3] - '?');
        }
        return add2.add(new String(cArr3), zzapVar.zzs()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzcw);
        SafeParcelWriter.writeString(parcel, 2, this.zzcx, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}