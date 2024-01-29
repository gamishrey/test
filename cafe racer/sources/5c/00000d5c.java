package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zzak extends MessagesClient {
    private static final Api.AbstractClientBuilder<zzah, MessagesOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<zzah> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api<MessagesOptions> MESSAGES_API;
    private final int zzhf;

    static {
        zzau zzauVar = new zzau();
        CLIENT_BUILDER = zzauVar;
        MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzauVar, CLIENT_KEY);
    }

    public zzak(Activity activity, MessagesOptions messagesOptions) {
        super(activity, MESSAGES_API, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzhf = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzbc(activity, this, null));
    }

    public zzak(Context context, MessagesOptions messagesOptions) {
        super(context, MESSAGES_API, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzhf = zzah.zzb(context);
    }

    public final <T> ListenerHolder<BaseImplementation.ResultHolder<Status>> zza(TaskCompletionSource<T> taskCompletionSource) {
        return registerListener(new zzax(this, taskCompletionSource), Status.class.getName());
    }

    private final <T> Task<Void> zza(ListenerHolder<T> listenerHolder, zzbd zzbdVar, zzbd zzbdVar2) {
        return doRegisterEventListener(new zzaz(this, listenerHolder, zzbdVar), new zzba(this, listenerHolder.getListenerKey(), zzbdVar2));
    }

    private final Task<Void> zza(zzbd zzbdVar) {
        return doWrite(new zzbb(this, zzbdVar));
    }

    private final <T> Task<Void> zza(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        doUnregisterEventListener(ListenerHolders.createListenerKey(t, t.getClass().getName())).addOnCompleteListener(new zzay(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private final <T> ListenerHolder<T> zzb(T t) {
        if (t == null) {
            return null;
        }
        return (ListenerHolder<T>) registerListener(t, t.getClass().getName());
    }

    public final void zzf(int i) {
        zza(new zzbd(1) { // from class: com.google.android.gms.nearby.messages.internal.zzat
            private final int zzhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhy = r1;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zzf(this.zzhy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.GoogleApi
    public final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            getApiOptions();
        }
        return createClientSettingsBuilder;
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzgw.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder zzb = zzb(message);
        return zza(zzb, new zzbd(this, message, new zzav(this, zzb(publishOptions.getCallback()), zzb), publishOptions) { // from class: com.google.android.gms.nearby.messages.internal.zzal
            private final zzak zzho;
            private final Message zzhp;
            private final zzbe zzhq;
            private final PublishOptions zzhr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzho = this;
                this.zzhp = message;
                this.zzhq = r3;
                this.zzhr = publishOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                this.zzho.zza(this.zzhp, this.zzhq, this.zzhr, zzahVar, listenerHolder);
            }
        }, new zzbd(message) { // from class: com.google.android.gms.nearby.messages.internal.zzam
            private final Message zzhs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhs = message;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zza(listenerHolder, zzaf.zza(this.zzhs));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        ListenerHolder zzb = zzb(statusCallback);
        return zza(zzb, new zzbd(zzb) { // from class: com.google.android.gms.nearby.messages.internal.zzar
            private final ListenerHolder zzhv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhv = zzb;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zzb(listenerHolder, this.zzhv);
            }
        }, new zzbd(zzb) { // from class: com.google.android.gms.nearby.messages.internal.zzas
            private final ListenerHolder zzhv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhv = zzb;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zzc(listenerHolder, this.zzhv);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder zzb = zzb(subscribeOptions.getCallback());
        return zza(new zzbd(this, pendingIntent, zzb == null ? null : new zzbg(zzb), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.zzap
            private final zzak zzho;
            private final zzbg zzht;
            private final SubscribeOptions zzhu;
            private final PendingIntent zzhw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzho = this;
                this.zzhw = pendingIntent;
                this.zzht = r3;
                this.zzhu = subscribeOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                this.zzho.zza(this.zzhw, this.zzht, this.zzhu, zzahVar, listenerHolder);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder zzb = zzb(messageListener);
        return zza(zzb, new zzbd(this, zzb, new zzaw(this, zzb(subscribeOptions.getCallback()), zzb), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.zzan
            private final ListenerHolder zzch;
            private final zzak zzho;
            private final zzbg zzht;
            private final SubscribeOptions zzhu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzho = this;
                this.zzch = zzb;
                this.zzht = r3;
                this.zzhu = subscribeOptions;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                this.zzho.zza(this.zzch, this.zzht, this.zzhu, zzahVar, listenerHolder);
            }
        }, new zzbd(zzb) { // from class: com.google.android.gms.nearby.messages.internal.zzao
            private final ListenerHolder zzhv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhv = zzb;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zza(listenerHolder, this.zzhv);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        Preconditions.checkNotNull(message);
        return zza((zzak) message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return zza((zzak) statusCallback);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return zza(new zzbd(pendingIntent) { // from class: com.google.android.gms.nearby.messages.internal.zzaq
            private final PendingIntent zzhx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhx = pendingIntent;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzbd
            public final void zza(zzah zzahVar, ListenerHolder listenerHolder) {
                zzahVar.zza(listenerHolder, this.zzhx);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return zza((zzak) messageListener);
    }

    public final /* synthetic */ void zza(PendingIntent pendingIntent, zzbg zzbgVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
        zzahVar.zza(listenerHolder, pendingIntent, zzbgVar, subscribeOptions, this.zzhf);
    }

    public final /* synthetic */ void zza(ListenerHolder listenerHolder, zzbg zzbgVar, SubscribeOptions subscribeOptions, zzah zzahVar, ListenerHolder listenerHolder2) throws RemoteException {
        zzahVar.zza(listenerHolder2, listenerHolder, zzbgVar, subscribeOptions, null, this.zzhf);
    }

    public final /* synthetic */ void zza(Message message, zzbe zzbeVar, PublishOptions publishOptions, zzah zzahVar, ListenerHolder listenerHolder) throws RemoteException {
        zzahVar.zza(listenerHolder, zzaf.zza(message), zzbeVar, publishOptions, this.zzhf);
    }
}