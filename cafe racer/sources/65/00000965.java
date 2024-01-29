package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzcz implements PendingResultUtil.ResultConverter<Videos.CaptureStateResult, CaptureState> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ CaptureState convert(Videos.CaptureStateResult captureStateResult) {
        Videos.CaptureStateResult captureStateResult2 = captureStateResult;
        if (captureStateResult2 == null) {
            return null;
        }
        return captureStateResult2.getCaptureState();
    }
}