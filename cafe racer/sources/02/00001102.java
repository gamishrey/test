package com.unity3d.services.core.device.reader;

import java.util.Map;

/* loaded from: classes.dex */
public interface IDeviceInfoDataCompressor extends IDeviceInfoDataContainer {
    byte[] compressDeviceInfo(Map<String, Object> map);
}