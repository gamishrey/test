package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface zza extends Parcelable, Freezable<zza> {
    Bundle getExtras();

    String getId();

    String getType();

    zzb zzaf();

    List<zzf> zzag();

    String zzah();

    String zzai();
}