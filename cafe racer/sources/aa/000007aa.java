package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzdu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class Games {
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    static final Api.ClientKey<com.google.android.gms.games.internal.zzg> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<com.google.android.gms.games.internal.zzg, GamesOptions> zzag = new zze();
    private static final Api.AbstractClientBuilder<com.google.android.gms.games.internal.zzg, GamesOptions> zzah = new com.google.android.gms.games.zzd();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    public static final Scope SCOPE_GAMES_SNAPSHOTS = new Scope(Scopes.DRIVE_APPFOLDER);
    @Deprecated
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzag, CLIENT_KEY);
    public static final Scope zzai = new Scope(FirstPartyScopes.GAMES_1P);
    private static final Api<GamesOptions> zzaj = new Api<>("Games.API_1P", zzah, CLIENT_KEY);
    @Deprecated
    public static final GamesMetadata GamesMetadata = new com.google.android.gms.internal.games.zzan();
    @Deprecated
    public static final Achievements Achievements = new com.google.android.gms.internal.games.zzq();
    private static final com.google.android.gms.games.appcontent.zzm zzak = new com.google.android.gms.internal.games.zzae();
    @Deprecated
    public static final Events Events = new com.google.android.gms.internal.games.zzaf();
    @Deprecated
    public static final Leaderboards Leaderboards = new com.google.android.gms.internal.games.zzba();
    @Deprecated
    public static final Invitations Invitations = new com.google.android.gms.internal.games.zzaw();
    @Deprecated
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new com.google.android.gms.internal.games.zzcv();
    @Deprecated
    public static final RealTimeMultiplayer RealTimeMultiplayer = new com.google.android.gms.internal.games.zzce();
    private static final Multiplayer zzal = new com.google.android.gms.internal.games.zzbq();
    @Deprecated
    public static final Players Players = new com.google.android.gms.internal.games.zzbu();
    @Deprecated
    public static final Notifications Notifications = new com.google.android.gms.internal.games.zzbp();
    @Deprecated
    public static final Snapshots Snapshots = new com.google.android.gms.internal.games.zzcd();
    @Deprecated
    public static final Stats Stats = new com.google.android.gms.internal.games.zzcr();
    @Deprecated
    public static final Videos Videos = new zzdu();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzb<T extends Result> extends BaseImplementation.ApiMethodImpl<T, com.google.android.gms.games.internal.zzg> {
        public zzb(GoogleApiClient googleApiClient) {
            super(Games.CLIENT_KEY, googleApiClient);
        }
    }

    private Games() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zza extends Api.AbstractClientBuilder<com.google.android.gms.games.internal.zzg, GamesOptions> {
        private zza() {
        }

        @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
        public int getPriority() {
            return 1;
        }

        @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
        public /* synthetic */ com.google.android.gms.games.internal.zzg buildClient(Context context, Looper looper, ClientSettings clientSettings, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions2 = gamesOptions;
            if (gamesOptions2 == null) {
                gamesOptions2 = new GamesOptions.Builder((zze) null).build();
            }
            return new com.google.android.gms.games.internal.zzg(context, looper, clientSettings, gamesOptions2, connectionCallbacks, onConnectionFailedListener);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zza(zze zzeVar) {
            this();
        }
    }

    public static com.google.android.gms.games.internal.zzg zza(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzc extends zzb<GetServerAuthCodeResult> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(this, status);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zzc(GoogleApiClient googleApiClient, zze zzeVar) {
            this(googleApiClient);
        }
    }

    public static com.google.android.gms.games.internal.zzg zza(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzb(googleApiClient, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd extends zzb<Status> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zzd(GoogleApiClient googleApiClient, zze zzeVar) {
            this(googleApiClient);
        }
    }

    public static com.google.android.gms.games.internal.zzg zzb(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkState(googleApiClient.hasApi(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            if (hasConnectedApi) {
                return (com.google.android.gms.games.internal.zzg) googleApiClient.getClient(CLIENT_KEY);
            }
            return null;
        }
        throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class GamesOptions implements GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions, Api.ApiOptions.Optional {
        public final boolean zzan;
        public final boolean zzao;
        public final int zzap;
        public final boolean zzaq;
        public final int zzar;
        public final String zzas;
        public final ArrayList<String> zzat;
        public final boolean zzau;
        public final boolean zzav;
        public final GoogleSignInAccount zzaw;
        public final String zzax;
        private final int zzay;

        private GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList<String> arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3) {
            this.zzan = z;
            this.zzao = z2;
            this.zzap = i;
            this.zzaq = z3;
            this.zzar = i2;
            this.zzas = str;
            this.zzat = arrayList;
            this.zzau = z4;
            this.zzav = z5;
            this.zzaw = googleSignInAccount;
            this.zzax = str2;
            this.zzay = i3;
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final int getExtensionType() {
            return 1;
        }

        /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
        /* loaded from: classes.dex */
        public static final class Builder {
            private static final AtomicInteger zzaz = new AtomicInteger(0);
            private boolean zzan;
            private boolean zzao;
            private int zzap;
            private boolean zzaq;
            private int zzar;
            private String zzas;
            private ArrayList<String> zzat;
            private boolean zzau;
            private boolean zzav;
            GoogleSignInAccount zzaw;
            private String zzax;
            private int zzay;

            private Builder() {
                this.zzan = false;
                this.zzao = true;
                this.zzap = 17;
                this.zzaq = false;
                this.zzar = 4368;
                this.zzas = null;
                this.zzat = new ArrayList<>();
                this.zzau = false;
                this.zzav = false;
                this.zzaw = null;
                this.zzax = null;
                this.zzay = 0;
            }

            private Builder(GamesOptions gamesOptions) {
                this.zzan = false;
                this.zzao = true;
                this.zzap = 17;
                this.zzaq = false;
                this.zzar = 4368;
                this.zzas = null;
                this.zzat = new ArrayList<>();
                this.zzau = false;
                this.zzav = false;
                this.zzaw = null;
                this.zzax = null;
                this.zzay = 0;
                if (gamesOptions != null) {
                    this.zzan = gamesOptions.zzan;
                    this.zzao = gamesOptions.zzao;
                    this.zzap = gamesOptions.zzap;
                    this.zzaq = gamesOptions.zzaq;
                    this.zzar = gamesOptions.zzar;
                    this.zzas = gamesOptions.zzas;
                    this.zzat = gamesOptions.zzat;
                    this.zzau = gamesOptions.zzau;
                    this.zzav = gamesOptions.zzav;
                    this.zzaw = gamesOptions.zzaw;
                    this.zzax = gamesOptions.zzax;
                    this.zzay = gamesOptions.zzay;
                }
            }

            public final Builder setShowConnectingPopup(boolean z) {
                this.zzao = z;
                this.zzap = 17;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z, int i) {
                this.zzao = z;
                this.zzap = i;
                return this;
            }

            public final Builder setSdkVariant(int i) {
                this.zzar = i;
                return this;
            }

            public final GamesOptions build() {
                return new GamesOptions(this.zzan, this.zzao, this.zzap, this.zzaq, this.zzar, this.zzas, this.zzat, this.zzau, this.zzav, this.zzaw, this.zzax, this.zzay, null);
            }

            /* synthetic */ Builder(zze zzeVar) {
                this();
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, zze zzeVar) {
                this(gamesOptions);
            }
        }

        public final boolean equals(Object obj) {
            String str;
            GoogleSignInAccount googleSignInAccount;
            if (obj == this) {
                return true;
            }
            if (obj instanceof GamesOptions) {
                GamesOptions gamesOptions = (GamesOptions) obj;
                return this.zzan == gamesOptions.zzan && this.zzao == gamesOptions.zzao && this.zzap == gamesOptions.zzap && this.zzaq == gamesOptions.zzaq && this.zzar == gamesOptions.zzar && ((str = this.zzas) != null ? str.equals(gamesOptions.zzas) : gamesOptions.zzas == null) && this.zzat.equals(gamesOptions.zzat) && this.zzau == gamesOptions.zzau && this.zzav == gamesOptions.zzav && ((googleSignInAccount = this.zzaw) != null ? googleSignInAccount.equals(gamesOptions.zzaw) : gamesOptions.zzaw == null) && TextUtils.equals(this.zzax, gamesOptions.zzax) && this.zzay == gamesOptions.zzay;
            }
            return false;
        }

        public final int hashCode() {
            int i = ((((((((((this.zzan ? 1 : 0) + 527) * 31) + (this.zzao ? 1 : 0)) * 31) + this.zzap) * 31) + (this.zzaq ? 1 : 0)) * 31) + this.zzar) * 31;
            String str = this.zzas;
            int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzat.hashCode()) * 31) + (this.zzau ? 1 : 0)) * 31) + (this.zzav ? 1 : 0)) * 31;
            GoogleSignInAccount googleSignInAccount = this.zzaw;
            int hashCode2 = (hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
            String str2 = this.zzax;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.zzay;
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final List<Scope> getImpliedScopes() {
            return Collections.singletonList(Games.SCOPE_GAMES_LITE);
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final Bundle toBundle() {
            return zzg();
        }

        public final Bundle zzg() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzan);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzao);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzap);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaq);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzar);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzas);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzat);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", this.zzau);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", this.zzav);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzaw);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", this.zzax);
            return bundle;
        }

        public static Builder builder() {
            return new Builder((zze) null);
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaw;
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3, zze zzeVar) {
            this(z, z2, i, z3, i2, str, arrayList, z4, z5, googleSignInAccount, str2, i3);
        }
    }

    @Deprecated
    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        com.google.android.gms.games.internal.zzg zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zzm(i);
        }
    }

    @Deprecated
    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        Preconditions.checkNotNull(view);
        com.google.android.gms.games.internal.zzg zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zza(view);
        }
    }

    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbd();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        return googleApiClient.execute(new zzg(googleApiClient, str));
    }

    @Deprecated
    public static String getAppId(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzby();
    }

    @Deprecated
    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbu();
    }

    @Deprecated
    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzf(googleApiClient));
    }

    private static GamesOptions zza(GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder builder = new GamesOptions.Builder(null, null);
        builder.zzaw = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }

    private static GamesOptions zza(GamesOptions gamesOptions, GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder builder = new GamesOptions.Builder(gamesOptions, null);
        builder.zzaw = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zze(activity, zza(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zze(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zze(context, zza(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zze(context, zza(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(activity, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(context, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(activity, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(context, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzbs(activity, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzbs(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzbs(context, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzbs(context, zza(gamesOptions, googleSignInAccount));
    }

    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, zza(gamesOptions, googleSignInAccount));
    }

    @Deprecated
    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbw();
    }
}