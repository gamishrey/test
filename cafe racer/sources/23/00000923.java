package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzan implements Parcelable.Creator<PlayerLevelInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayerLevelInfo[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlayerLevelInfo createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PlayerLevel playerLevel = null;
        PlayerLevel playerLevel2 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                j = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 2) {
                j2 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                playerLevel = (PlayerLevel) SafeParcelReader.createParcelable(parcel, readHeader, PlayerLevel.CREATOR);
            } else if (fieldId == 4) {
                playerLevel2 = (PlayerLevel) SafeParcelReader.createParcelable(parcel, readHeader, PlayerLevel.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PlayerLevelInfo(j, j2, playerLevel, playerLevel2);
    }
}