package com.unity3d.player;

import android.content.Context;
import com.unity3d.player.b;

/* loaded from: classes.dex */
public class AudioVolumeHandler implements b.InterfaceC0008b {
    private b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioVolumeHandler(Context context) {
        b bVar = new b(context);
        this.a = bVar;
        bVar.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    @Override // com.unity3d.player.b.InterfaceC0008b
    public final native void onAudioVolumeChanged(int i);
}