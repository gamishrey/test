package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface ExperienceEvent extends Parcelable, Freezable<ExperienceEvent> {
    Game getGame();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    int getType();

    String zzcw();

    String zzcx();

    String zzcy();

    long zzcz();

    long zzda();

    long zzdb();

    int zzdc();
}