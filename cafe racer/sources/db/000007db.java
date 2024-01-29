package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class VideosClient extends com.google.android.gms.internal.games.zzad {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;
    private static final PendingResultUtil.ResultConverter<Videos.CaptureAvailableResult, Boolean> zzfb = new zzda();
    private static final PendingResultUtil.ResultConverter<Videos.CaptureStateResult, CaptureState> zzfc = new zzcz();
    private static final PendingResultUtil.ResultConverter<Videos.CaptureCapabilitiesResult, VideoCapabilities> zzfd = new zzdb();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public interface OnCaptureOverlayStateListener extends Videos.CaptureOverlayStateListener {
        @Override // com.google.android.gms.games.video.Videos.CaptureOverlayStateListener
        void onCaptureOverlayStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<VideoCapabilities> getCaptureCapabilities() {
        return com.google.android.gms.games.internal.zzbb.toTask(Games.Videos.getCaptureCapabilities(asGoogleApiClient()), zzfd);
    }

    public Task<Intent> getCaptureOverlayIntent() {
        return doRead(new zzcw(this));
    }

    public Task<CaptureState> getCaptureState() {
        return com.google.android.gms.games.internal.zzbb.toTask(Games.Videos.getCaptureState(asGoogleApiClient()), zzfc);
    }

    public Task<Boolean> isCaptureAvailable(int i) {
        return com.google.android.gms.games.internal.zzbb.toTask(Games.Videos.isCaptureAvailable(asGoogleApiClient(), i), zzfb);
    }

    public Task<Boolean> isCaptureSupported() {
        return doRead(new zzcv(this));
    }

    public Task<Void> registerOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        ListenerHolder<L> registerListener = registerListener(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName());
        return doRegisterEventListener(new zzcy(this, registerListener, registerListener), new zzcx(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName()));
    }
}