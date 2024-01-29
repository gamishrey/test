package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final class DiscoveredEndpointInfo {
    private final String zzq;
    private final String zzu;
    private final BluetoothDevice zzv;

    public DiscoveredEndpointInfo(String str, BluetoothDevice bluetoothDevice) {
        this.zzu = str;
        this.zzq = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.zzv = bluetoothDevice;
    }

    @Deprecated
    public DiscoveredEndpointInfo(String str, String str2) {
        this.zzu = str;
        this.zzq = str2;
        this.zzv = null;
    }

    public final String getEndpointName() {
        return this.zzq;
    }

    public final String getServiceId() {
        return this.zzu;
    }
}