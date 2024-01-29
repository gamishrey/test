package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.games.bridge.HelperFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SignInRequest implements HelperFragment.Request {
    private static final String TAG = "SignInRequest";
    private final String accountName;
    private final boolean doAuthCode;
    private final boolean doEmail;
    private final boolean doIdToken;
    private final boolean forceRefresh;
    private HelperFragment helperFragment;
    private final boolean hidePopups;
    private final Scope[] scopes;
    private final boolean silent;
    private final String webClientId;
    private final TaskCompletionSource<GoogleSignInAccount> resultTaskSource = new TaskCompletionSource<>();
    private final TokenPendingResult pendingResponse = new TokenPendingResult();

    public SignInRequest(boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, String[] strArr, boolean z6, String str2) {
        this.silent = z;
        this.doAuthCode = z2;
        this.doEmail = z3;
        this.doIdToken = z4;
        this.webClientId = str;
        this.forceRefresh = z5;
        this.hidePopups = z6;
        this.accountName = str2;
        if (strArr != null && strArr.length > 0) {
            this.scopes = new Scope[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.scopes[i] = new Scope(strArr[i]);
            }
            return;
        }
        this.scopes = null;
    }

    public Task<GoogleSignInAccount> getTask() {
        return this.resultTaskSource.getTask();
    }

    public PendingResult<TokenResult> getPendingResponse() {
        return this.pendingResponse;
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(HelperFragment helperFragment) {
        this.helperFragment = helperFragment;
        signIn();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9002) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent != null && signInResultFromIntent.isSuccess()) {
                setSuccess(signInResultFromIntent.getSignInAccount());
            } else if (i2 == 0) {
                setFailure(16);
            } else if (signInResultFromIntent != null) {
                Log.e(TAG, "GoogleSignInResult error status code: " + signInResultFromIntent.getStatus());
                setFailure(signInResultFromIntent.getStatus().getStatusCode());
            } else {
                Log.e(TAG, "Google SignIn Result is null, resultCode is " + i2 + "(" + GoogleSignInStatusCodes.getStatusCodeString(i2) + ")");
                setFailure(13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signIn() {
        Log.d(TAG, "signIn");
        final GoogleSignInClient buildClient = buildClient();
        if (buildClient != null) {
            Activity activity = this.helperFragment.getActivity();
            if (canReuseAccount()) {
                final GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(activity);
                if (GoogleSignIn.hasPermissions(lastSignedInAccount, this.scopes)) {
                    Log.d(TAG, "Checking the last signed-in account if it can be used.");
                    Games.getGamesClient(activity, lastSignedInAccount).getAppId().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.google.games.bridge.SignInRequest.1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<String> task) {
                            if (task.isSuccessful()) {
                                Log.d(SignInRequest.TAG, "Signed-in with the last signed-in account.");
                                SignInRequest.this.setSuccess(lastSignedInAccount);
                                return;
                            }
                            buildClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.google.games.bridge.SignInRequest.1.1
                                @Override // com.google.android.gms.tasks.OnCompleteListener
                                public void onComplete(Task<Void> task2) {
                                    if (task2.isSuccessful()) {
                                        Log.d(SignInRequest.TAG, "Can't reuse the last signed-in account. Second attempt after sign out.");
                                        SignInRequest.this.signIn();
                                        return;
                                    }
                                    Log.e(SignInRequest.TAG, "Can't reuse the last signed-in account and sign out failed.");
                                    SignInRequest.this.setFailure(4);
                                }
                            });
                        }
                    });
                    return;
                }
            }
            Log.d(TAG, "signInClient.silentSignIn");
            buildClient.silentSignIn().addOnSuccessListener(activity, new OnSuccessListener<GoogleSignInAccount>() { // from class: com.google.games.bridge.SignInRequest.3
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(GoogleSignInAccount googleSignInAccount) {
                    Log.d(SignInRequest.TAG, "silentSignIn.onSuccess");
                    SignInRequest.this.setSuccess(googleSignInAccount);
                }
            }).addOnFailureListener(activity, new OnFailureListener() { // from class: com.google.games.bridge.SignInRequest.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    Log.d(SignInRequest.TAG, "silentSignIn.onFailure");
                    int statusCode = exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 8;
                    if (statusCode == 4 || statusCode == 8 || statusCode == 6) {
                        if (!SignInRequest.this.silent) {
                            SignInRequest.this.helperFragment.startActivityForResult(buildClient.getSignInIntent(), GamesStatusCodes.STATUS_VIDEO_PERMISSION_ERROR);
                            return;
                        }
                        Log.i(SignInRequest.TAG, "Sign-in failed. Run in silent mode and UI sign-in required.");
                        SignInRequest.this.setFailure(4);
                        return;
                    }
                    Log.e(SignInRequest.TAG, "Sign-in failed with status code: " + statusCode);
                    SignInRequest.this.setFailure(statusCode);
                }
            });
        }
    }

    private GoogleSignInClient buildClient() {
        Log.d(TAG, "Building client for: " + this);
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder();
        if (this.doAuthCode) {
            if (!getWebClientId().isEmpty() && !getWebClientId().equals("__WEB_CLIENTID__")) {
                builder.requestServerAuthCode(getWebClientId(), this.forceRefresh);
            } else {
                Log.e(TAG, "Web client ID is needed for Auth Code");
                setFailure(10);
                return null;
            }
        }
        if (this.doEmail) {
            builder.requestEmail();
        }
        if (this.doIdToken) {
            if (!getWebClientId().isEmpty() && !getWebClientId().equals("__WEB_CLIENTID__")) {
                builder.requestIdToken(getWebClientId());
            } else {
                Log.e(TAG, "Web client ID is needed for ID Token");
                setFailure(10);
                return null;
            }
        }
        Scope[] scopeArr = this.scopes;
        if (scopeArr != null) {
            for (Scope scope : scopeArr) {
                builder.requestScopes(scope, new Scope[0]);
            }
        }
        if (this.hidePopups) {
            Log.d(TAG, "hiding popup views for games API");
            builder.addExtension(Games.GamesOptions.builder().setShowConnectingPopup(false).build());
        }
        String str = this.accountName;
        if (str != null && !str.isEmpty()) {
            builder.setAccountName(this.accountName);
        }
        return GoogleSignIn.getClient(this.helperFragment.getActivity(), builder.build());
    }

    private boolean canReuseAccount() {
        return (this.doAuthCode || this.doIdToken) ? false : true;
    }

    private String getWebClientId() {
        String str = this.webClientId;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailure(int i) {
        Log.e(TAG, "Setting result error status code to: " + i);
        this.pendingResponse.setStatus(i);
        this.resultTaskSource.setException(new ApiException(new Status(i)));
        HelperFragment.finishRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess(GoogleSignInAccount googleSignInAccount) {
        this.resultTaskSource.setResult(googleSignInAccount);
        this.pendingResponse.setAccount(googleSignInAccount);
        this.pendingResponse.setStatus(0);
        HelperFragment.finishRequest(this);
    }

    public String toString() {
        return Integer.toHexString(hashCode()) + " (a:" + this.doAuthCode + " e:" + this.doEmail + " i:" + this.doIdToken + " wc: " + this.webClientId + " f: " + this.forceRefresh + ")";
    }
}