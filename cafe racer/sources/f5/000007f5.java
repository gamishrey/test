package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface zzi extends Parcelable, Freezable<zzi> {
    List<zza> getActions();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    String zzah();

    List<zzb> zzap();

    String zzar();

    List<zze> zzax();

    String zzay();
}