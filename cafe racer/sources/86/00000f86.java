package com.unity3d.scar.adapter.v1950.signals;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.DispatchGroup;

/* loaded from: classes.dex */
public class QueryInfoCallback extends QueryInfoGenerationCallback {
    private DispatchGroup _dispatchGroup;
    private QueryInfoMetadata _gmaQueryInfoMetadata;

    public QueryInfoCallback(QueryInfoMetadata queryInfoMetadata, DispatchGroup dispatchGroup) {
        this._dispatchGroup = dispatchGroup;
        this._gmaQueryInfoMetadata = queryInfoMetadata;
    }

    public void onSuccess(QueryInfo queryInfo) {
        this._gmaQueryInfoMetadata.setQueryInfo(queryInfo);
        this._dispatchGroup.leave();
    }

    public void onFailure(String str) {
        this._gmaQueryInfoMetadata.setError(str);
        this._dispatchGroup.leave();
    }
}