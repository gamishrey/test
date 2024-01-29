package com.unity3d.scar.adapter.v2000.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.ISignalsReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SignalsReader implements ISignalsReader {
    private static Map<String, String> _placementSignalMap;
    private static SignalsStorage _signalsStorage;

    public SignalsReader(SignalsStorage signalsStorage) {
        _signalsStorage = signalsStorage;
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalsReader
    public void getSCARSignals(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        for (String str : strArr) {
            dispatchGroup.enter();
            getSCARSignal(context, str, AdFormat.INTERSTITIAL, dispatchGroup);
        }
        for (String str2 : strArr2) {
            dispatchGroup.enter();
            getSCARSignal(context, str2, AdFormat.REWARDED, dispatchGroup);
        }
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener));
    }

    private void getSCARSignal(Context context, String str, AdFormat adFormat, DispatchGroup dispatchGroup) {
        AdRequest build = new AdRequest.Builder().build();
        QueryInfoMetadata queryInfoMetadata = new QueryInfoMetadata(str);
        QueryInfoCallback queryInfoCallback = new QueryInfoCallback(queryInfoMetadata, dispatchGroup);
        _signalsStorage.put(str, queryInfoMetadata);
        QueryInfo.generate(context, adFormat, build, queryInfoCallback);
    }

    /* loaded from: classes.dex */
    private class GMAScarDispatchCompleted implements Runnable {
        private ISignalCollectionListener _signalListener;

        public GMAScarDispatchCompleted(ISignalCollectionListener iSignalCollectionListener) {
            this._signalListener = iSignalCollectionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map unused = SignalsReader._placementSignalMap = new HashMap();
            String str = null;
            for (Map.Entry<String, QueryInfoMetadata> entry : SignalsReader._signalsStorage.getPlacementQueryInfoMap().entrySet()) {
                QueryInfoMetadata value = entry.getValue();
                SignalsReader._placementSignalMap.put(value.getPlacementId(), value.getQueryStr());
                if (value.getError() != null) {
                    str = value.getError();
                }
            }
            if (SignalsReader._placementSignalMap.size() > 0) {
                this._signalListener.onSignalsCollected(new JSONObject(SignalsReader._placementSignalMap).toString());
            } else if (str == null) {
                this._signalListener.onSignalsCollected("");
            } else {
                this._signalListener.onSignalsCollectionFailed(str);
            }
        }
    }
}