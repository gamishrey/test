package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.games.bridge.HelperFragment;
import java.util.ArrayList;

/* loaded from: classes.dex */
class RequestPermissionsRequest implements HelperFragment.Request {
    private static final String TAG = "RequestPermissions";
    private HelperFragment helperFragment;
    private final TaskCompletionSource<GoogleSignInAccount> resultTaskSource = new TaskCompletionSource<>();
    private Scope[] scopes;

    public RequestPermissionsRequest(Scope[] scopeArr) {
        this.scopes = scopeArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<GoogleSignInAccount> getTask() {
        return this.resultTaskSource.getTask();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void process(HelperFragment helperFragment) {
        this.helperFragment = helperFragment;
        Activity activity = helperFragment.getActivity();
        GoogleSignInAccount account = HelperFragment.getAccount(activity);
        Scope[] unauthorizedScopes = getUnauthorizedScopes(account, this.scopes);
        if (unauthorizedScopes.length == 0) {
            Scope[] scopeArr = this.scopes;
            setSuccess(GoogleSignIn.getAccountForScopes(activity, scopeArr[0], scopeArr));
            return;
        }
        helperFragment.startActivityForResult(getSignInIntentForAccountAndScopes(activity, account, unauthorizedScopes), 9010);
    }

    private Scope[] getUnauthorizedScopes(GoogleSignInAccount googleSignInAccount, Scope[] scopeArr) {
        ArrayList arrayList = new ArrayList();
        for (Scope scope : scopeArr) {
            if (!GoogleSignIn.hasPermissions(googleSignInAccount, scope)) {
                arrayList.add(scope);
            }
        }
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    private static Intent getSignInIntentForAccountAndScopes(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder();
        if (scopeArr.length > 0) {
            builder.requestScopes(scopeArr[0], scopeArr);
        }
        if (googleSignInAccount != null && googleSignInAccount.getEmail() != null) {
            builder.setAccountName(googleSignInAccount.getEmail());
        }
        return GoogleSignIn.getClient(activity, builder.build()).getSignInIntent();
    }

    @Override // com.google.games.bridge.HelperFragment.Request
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9010) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent != null && signInResultFromIntent.isSuccess()) {
                Activity activity = this.helperFragment.getActivity();
                Scope[] scopeArr = this.scopes;
                setSuccess(GoogleSignIn.getAccountForScopes(activity, scopeArr[0], scopeArr));
            } else if (i2 == 0) {
                if (signInResultFromIntent != null) {
                    setFailure(signInResultFromIntent.getStatus().getStatusCode());
                } else {
                    setFailure(16);
                }
            } else if (signInResultFromIntent != null) {
                setFailure(signInResultFromIntent.getStatus().getStatusCode());
            } else {
                setFailure(13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailure(int i) {
        this.resultTaskSource.setException(new ApiException(new Status(i)));
        HelperFragment.finishRequest(this);
    }

    private void setSuccess(GoogleSignInAccount googleSignInAccount) {
        this.resultTaskSource.setResult(googleSignInAccount);
        HelperFragment.finishRequest(this);
    }
}