package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface zze extends Parcelable, Freezable<zze> {
    List<zza> getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List<zzf> zzag();

    String zzah();

    List<zzb> zzap();

    int zzaq();

    String zzar();

    int zzas();
}