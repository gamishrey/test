package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class GamesClient extends com.google.android.gms.internal.games.zzad {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GamesClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Void> setGravityForPopups(int i) {
        return doWrite(new zzj(this, i));
    }

    public Task<Void> setViewForPopups(View view) {
        return doWrite(new zzi(this, view));
    }

    public Task<String> getCurrentAccountName() {
        return doRead(new zzl(this));
    }

    public Task<String> getAppId() {
        return doRead(new zzk(this));
    }

    public Task<Intent> getSettingsIntent() {
        return doRead(new zzn(this));
    }

    public Task<Bundle> getActivationHint() {
        return doRead(new zzm(this));
    }

    public Task<Integer> getSdkVariant() {
        return doRead(new zzo(this));
    }
}