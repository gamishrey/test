package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.games.bridge.HelperFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CaptureOverlayUiRequest implements HelperFragment.Request {
    private static final String TAG = "CaptureOverlayUiRequest";

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(final HelperFragment helperFragment) {
        Activity activity = helperFragment.getActivity();
        Games.getVideosClient(activity, HelperFragment.getAccount(activity)).getCaptureOverlayIntent().addOnSuccessListener(activity, new OnSuccessListener<Intent>() { // from class: com.google.games.bridge.CaptureOverlayUiRequest.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Intent intent) {
                Utils.startActivityForResult(helperFragment, intent, 9005);
                HelperFragment.finishRequest(CaptureOverlayUiRequest.this);
            }
        }).addOnFailureListener(activity, new OnFailureListener() { // from class: com.google.games.bridge.CaptureOverlayUiRequest.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                Log.d(CaptureOverlayUiRequest.TAG, "Show CaptureOverlay UI failed");
            }
        });
    }
}