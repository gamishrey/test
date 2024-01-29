package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.reader.pii.DataSelectorResult;
import com.unity3d.services.core.device.reader.pii.PiiDataProvider;
import com.unity3d.services.core.device.reader.pii.PiiDataSelector;
import com.unity3d.services.core.device.reader.pii.PiiDecisionData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithPII implements IDeviceInfoReader {
    private IDeviceInfoReader _deviceInfoReader;
    private PiiDataProvider _piiDataProvider;
    private PiiDataSelector _piiDataSelector;

    public DeviceInfoReaderWithPII(IDeviceInfoReader iDeviceInfoReader, PiiDataSelector piiDataSelector, PiiDataProvider piiDataProvider) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._piiDataSelector = piiDataSelector;
        this._piiDataProvider = piiDataProvider;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        PiiDecisionData whatToDoWithPII = this._piiDataSelector.whatToDoWithPII();
        int i = AnonymousClass1.$SwitchMap$com$unity3d$services$core$device$reader$pii$DataSelectorResult[whatToDoWithPII.getResultType().ordinal()];
        if (i == 1) {
            deviceInfoData.putAll(getPiiAttributesFromStorage(whatToDoWithPII));
        } else if (i == 2) {
            deviceInfoData.putAll(getPiiAttributesFromDevice(whatToDoWithPII));
        }
        return deviceInfoData;
    }

    /* renamed from: com.unity3d.services.core.device.reader.DeviceInfoReaderWithPII$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$device$reader$pii$DataSelectorResult;

        static {
            int[] iArr = new int[DataSelectorResult.values().length];
            $SwitchMap$com$unity3d$services$core$device$reader$pii$DataSelectorResult = iArr;
            try {
                iArr[DataSelectorResult.INCLUDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$device$reader$pii$DataSelectorResult[DataSelectorResult.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$device$reader$pii$DataSelectorResult[DataSelectorResult.EXCLUDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Map<String, Object> getPiiAttributesFromStorage(PiiDecisionData piiDecisionData) {
        return piiDecisionData.getAttributes();
    }

    private Map<String, Object> getPiiAttributesFromDevice(PiiDecisionData piiDecisionData) {
        HashMap hashMap = new HashMap();
        String advertisingTrackingId = this._piiDataProvider.getAdvertisingTrackingId();
        if (advertisingTrackingId != null) {
            hashMap.put(JsonStorageKeyNames.ADVERTISING_TRACKING_ID_NORMALIZED_KEY, advertisingTrackingId);
        }
        if (piiDecisionData.getUserNonBehavioralFlag() != null) {
            hashMap.put(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, piiDecisionData.getUserNonBehavioralFlag());
        }
        return hashMap;
    }
}