package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* loaded from: classes.dex */
public class HFPStatus {
    private Context a;
    private AudioManager e;
    private BroadcastReceiver b = null;
    private Intent c = null;
    private boolean d = false;
    private boolean f = false;
    private int g = a.a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {1, 2};
    }

    public HFPStatus(Context context) {
        this.e = null;
        this.a = context;
        this.e = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    private void b() {
        BroadcastReceiver broadcastReceiver = this.b;
        if (broadcastReceiver != null) {
            this.a.unregisterReceiver(broadcastReceiver);
            this.b = null;
            this.c = null;
        }
        this.g = a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f) {
            this.f = false;
            this.e.stopBluetoothSco();
        }
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    public final void a() {
        clearHFPStat();
        deinitHFPStatusJni();
    }

    protected void clearHFPStat() {
        b();
        c();
    }

    protected boolean getHFPStat() {
        return this.g == a.b;
    }

    protected void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != 1) {
                    return;
                }
                HFPStatus.this.g = a.b;
                HFPStatus.this.c();
                if (HFPStatus.this.d) {
                    HFPStatus.this.e.setMode(3);
                }
            }
        };
        this.b = broadcastReceiver;
        this.c = this.a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f = true;
            this.e.startBluetoothSco();
        } catch (NullPointerException unused) {
            f.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    protected void setHFPRecordingStat(boolean z) {
        this.d = z;
        if (z) {
            return;
        }
        this.e.setMode(0);
    }
}