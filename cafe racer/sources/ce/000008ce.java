package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zza implements Parcelable.Creator<RealTimeMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RealTimeMessage[] newArray(int i) {
        return new RealTimeMessage[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RealTimeMessage createFromParcel(Parcel parcel) {
        return new RealTimeMessage(parcel, null);
    }
}