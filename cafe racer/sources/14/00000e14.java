package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public final class NativeBridgeActivity extends Activity {
    private static final int BG_COLOR = 1090519039;
    private static final String BRIDGED_INTENT = "BRIDGED_INTENT";
    private static final int GPG_RESPONSE_CODE = 4673607;
    private static final String TAG = "NativeBridgeActivity";
    private boolean pendingResult;

    private native void forwardActivityResult(int i, int i2, Intent intent);

    static {
        System.loadLibrary("gpg");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        View view = new View(this);
        view.setBackgroundColor(BG_COLOR);
        setContentView(view);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        Intent intent = (Intent) getIntent().getParcelableExtra(BRIDGED_INTENT);
        if (intent != null) {
            startActivityForResult(intent, GPG_RESPONSE_CODE);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        boolean z = i == GPG_RESPONSE_CODE;
        this.pendingResult = z;
        if (z) {
            Log.d(TAG, "starting GPG activity: " + intent);
        } else {
            Log.i(TAG, "starting non-GPG activity: " + i + " " + intent);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == GPG_RESPONSE_CODE) {
            Log.d(TAG, "Forwarding activity result to native SDK.");
            forwardActivityResult(i, i2, intent);
            this.pendingResult = false;
        } else {
            Log.d(TAG, "onActivityResult for unknown request code: " + i + " calling finish()");
        }
        finish();
        super.onActivityResult(i, i2, intent);
    }

    public static void launchBridgeIntent(Activity activity, Intent intent) {
        Log.d(TAG, "Launching bridge activity: parent:" + activity + " intent " + intent);
        Intent intent2 = new Intent(activity, NativeBridgeActivity.class);
        intent2.putExtra(BRIDGED_INTENT, intent);
        activity.startActivity(intent2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.pendingResult) {
            Log.w(TAG, "onDestroy called with pendingResult == true.  forwarding canceled result");
            forwardActivityResult(GPG_RESPONSE_CODE, 0, null);
            this.pendingResult = false;
        }
        super.onDestroy();
    }
}