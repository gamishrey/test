package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzs extends zzg.zzu<Videos.CaptureOverlayStateListener> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
    public final void onCaptureOverlayStateChanged(final int i) {
        zzc(new zzg.zzao(i) { // from class: com.google.android.gms.games.internal.zzr
            private final int zzhh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhh = i;
            }

            @Override // com.google.android.gms.games.internal.zzg.zzao
            public final void accept(Object obj) {
                ((Videos.CaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zzhh);
            }
        });
    }
}