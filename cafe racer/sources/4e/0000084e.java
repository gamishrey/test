package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzed;
import com.google.android.gms.internal.games.zzef;
import com.google.android.gms.internal.games.zzei;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public class zzg extends GmsClient<zzbr> {
    private final zzef zzgv;
    private final String zzgw;
    private PlayerEntity zzgx;
    private GameEntity zzgy;
    private final zzbv zzgz;
    private boolean zzha;
    private final Binder zzhb;
    private final long zzhc;
    private boolean zzhd;
    private final Games.GamesOptions zzhe;
    private Bundle zzhf;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaa extends zzaz implements TurnBasedMultiplayer.LoadMatchResult {
        /* JADX INFO: Access modifiers changed from: package-private */
        public zzaa(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public interface zzao<T> {
        void accept(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public interface zzaq<T> {
        void zza(T t, Room room);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public interface zzar<T> {
        void zza(T t, Room room, ArrayList<String> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public interface zzav<T> {
        void zza(T t, int i, Room room);
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzbc extends zzaz implements TurnBasedMultiplayer.UpdateMatchResult {
        zzbc(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static abstract class zzn extends DataHolderResult {
        zzn(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zza(dataHolder.getStatusCode()));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzp extends zzaz implements TurnBasedMultiplayer.InitiateMatchResult {
        zzp(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzv extends zzaz implements TurnBasedMultiplayer.LeaveMatchResult {
        zzv(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    public zzg(Context context, Looper looper, ClientSettings clientSettings, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzgv = new com.google.android.gms.games.internal.zzf(this);
        this.zzha = false;
        this.zzhd = false;
        this.zzgw = clientSettings.getRealClientPackageName();
        this.zzhb = new Binder();
        this.zzgz = zzbv.zza(this, clientSettings.getGravityForPopups());
        this.zzhc = hashCode();
        this.zzhe = gamesOptions;
        if (gamesOptions.zzau) {
            return;
        }
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zza(clientSettings.getViewForPopups());
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresAccount() {
        return true;
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzag extends zzn implements Snapshots.LoadSnapshotsResult {
        zzag(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.mDataHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzai extends zzu<OnTurnBasedMatchUpdateReceivedListener> {
        zzai(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzr(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch freeze = turnBasedMatchBuffer.getCount() > 0 ? turnBasedMatchBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    zzc(new zzao(freeze) { // from class: com.google.android.gms.games.internal.zzaf
                        private final TurnBasedMatch zzim;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzim = freeze;
                        }

                        @Override // com.google.android.gms.games.internal.zzg.zzao
                        public final void accept(Object obj) {
                            ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchReceived(this.zzim);
                        }
                    });
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onTurnBasedMatchRemoved(String str) {
            zzc(new zzao(str) { // from class: com.google.android.gms.games.internal.zzag
                private final String zzhy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhy = str;
                }

                @Override // com.google.android.gms.games.internal.zzg.zzao
                public final void accept(Object obj) {
                    ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchRemoved(this.zzhy);
                }
            });
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzaj extends zzn implements Snapshots.OpenSnapshotResult {
        private final String zzem;
        private final Snapshot zzin;
        private final Snapshot zzio;
        private final SnapshotContents zzip;

        zzaj(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        zzaj(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzin = null;
                    this.zzio = null;
                } else {
                    boolean z = true;
                    if (snapshotMetadataBuffer.getCount() == 1) {
                        if (dataHolder.getStatusCode() == 4004) {
                            z = false;
                        }
                        Asserts.checkState(z);
                        this.zzin = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzio = null;
                    } else {
                        this.zzin = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzio = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    }
                }
                snapshotMetadataBuffer.release();
                this.zzem = str;
                this.zzip = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getSnapshot() {
            return this.zzin;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final String getConflictId() {
            return this.zzem;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getConflictingSnapshot() {
            return this.zzio;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final SnapshotContents getResolutionSnapshotContents() {
            return this.zzip;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzak extends zzan<Players.LoadPlayersResult> {
        zzak(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zze(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzf(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzap extends com.google.android.gms.games.internal.zzb {
        private final ListenerHolder<? extends RoomUpdateListener> zziv;
        private final ListenerHolder<? extends RoomStatusUpdateListener> zziw;
        private final ListenerHolder<? extends RealTimeMessageReceivedListener> zzix;

        zzap(ListenerHolder<? extends RoomUpdateListener> listenerHolder) {
            this(listenerHolder, null, null);
        }

        zzap(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3) {
            this.zziv = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callbacks must not be null");
            this.zziw = listenerHolder2;
            this.zzix = listenerHolder3;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzs(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzai.zziu));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzt(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzak.zziu));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onLeftRoom(int i, String str) {
            this.zziv.notifyListener(zzg.zza(new zzao(i, str) { // from class: com.google.android.gms.games.internal.zzas
                private final int zzhh;
                private final String zzja;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhh = i;
                    this.zzja = str;
                }

                @Override // com.google.android.gms.games.internal.zzg.zzao
                public final void accept(Object obj) {
                    ((RoomUpdateListener) obj).onLeftRoom(this.zzhh, this.zzja);
                }
            }));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzw(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzar.zziu));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzu(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzau.zzjb));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzv(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzat.zzjb));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzx(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzaw.zzjb));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzy(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, com.google.android.gms.games.internal.zzav.zzjb));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zze(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzay.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzf(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzax.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzaj.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzb(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzam.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzc(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzal.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzd(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, com.google.android.gms.games.internal.zzao.zziy));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onP2PConnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzao(str) { // from class: com.google.android.gms.games.internal.zzan
                    private final String zzhy;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhy = str;
                    }

                    @Override // com.google.android.gms.games.internal.zzg.zzao
                    public final void accept(Object obj) {
                        ((RoomStatusUpdateListener) obj).onP2PConnected(this.zzhy);
                    }
                }));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onP2PDisconnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzao(str) { // from class: com.google.android.gms.games.internal.zzaq
                    private final String zzhy;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhy = str;
                    }

                    @Override // com.google.android.gms.games.internal.zzg.zzao
                    public final void accept(Object obj) {
                        ((RoomStatusUpdateListener) obj).onP2PDisconnected(this.zzhy);
                    }
                }));
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder = this.zzix;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzao(realTimeMessage) { // from class: com.google.android.gms.games.internal.zzap
                    private final RealTimeMessage zziz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zziz = realTimeMessage;
                    }

                    @Override // com.google.android.gms.games.internal.zzg.zzao
                    public final void accept(Object obj) {
                        ((RealTimeMessageReceivedListener) obj).onRealTimeMessageReceived(this.zziz);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzas extends zzan<Snapshots.LoadSnapshotsResult> {
        zzas(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzag(DataHolder dataHolder) {
            setResult(new zzag(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzat extends zzan<Snapshots.OpenSnapshotResult> {
        zzat(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(DataHolder dataHolder, Contents contents) {
            setResult(new zzaj(dataHolder, contents));
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            setResult(new zzaj(dataHolder, str, contents, contents2, contents3));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzaw extends zzan<TurnBasedMultiplayer.LeaveMatchResult> {
        zzaw(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzq(DataHolder dataHolder) {
            setResult(new zzv(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzax extends zzan<TurnBasedMultiplayer.InitiateMatchResult> {
        zzax(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzo(DataHolder dataHolder) {
            setResult(new zzp(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzay extends zzan<TurnBasedMultiplayer.UpdateMatchResult> {
        zzay(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzp(DataHolder dataHolder) {
            setResult(new zzbc(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzb extends zzan<Achievements.UpdateAchievementResult> {
        zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzb(int i, String str) {
            setResult(new zzba(i, str));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzbb extends zzan<TurnBasedMultiplayer.LoadMatchesResult> {
        zzbb(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            setResult(new zzad(GamesStatusCodes.zza(i), bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzl extends zzan<Events.LoadEventsResult> {
        zzl(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzb(DataHolder dataHolder) {
            setResult(new zzz(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzo extends zzu<OnInvitationReceivedListener> {
        zzo(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzl(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation freeze = invitationBuffer.getCount() > 0 ? invitationBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    zzc(new zzao(freeze) { // from class: com.google.android.gms.games.internal.zzae
                        private final Invitation zzhz;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzhz = freeze;
                        }

                        @Override // com.google.android.gms.games.internal.zzg.zzao
                        public final void accept(Object obj) {
                            ((OnInvitationReceivedListener) obj).onInvitationReceived(this.zzhz);
                        }
                    });
                }
            } finally {
                invitationBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void onInvitationRemoved(String str) {
            zzc(new zzao(str) { // from class: com.google.android.gms.games.internal.zzad
                private final String zzhy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhy = str;
                }

                @Override // com.google.android.gms.games.internal.zzg.zzao
                public final void accept(Object obj) {
                    ((OnInvitationReceivedListener) obj).onInvitationRemoved(this.zzhy);
                }
            });
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzr extends zzan<Invitations.LoadInvitationsResult> {
        zzr(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzk(DataHolder dataHolder) {
            setResult(new zzab(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzs extends zzan<Leaderboards.LeaderboardMetadataResult> {
        zzs(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzc(DataHolder dataHolder) {
            setResult(new zzq(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzt extends zzan<Leaderboards.LoadScoresResult> {
        zzt(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            setResult(new zzah(dataHolder, dataHolder2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzx<T> implements ListenerHolder.Notifier<T> {
        private zzx() {
        }

        @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
        public void onNotifyListenerFailed() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zzx(com.google.android.gms.games.internal.zzf zzfVar) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzab extends zzn implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzif;

        zzab(DataHolder dataHolder) {
            super(dataHolder);
            this.zzif = new InvitationBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
        public final InvitationBuffer getInvitations() {
            return this.zzif;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzae extends zzn implements Players.LoadPlayersResult {
        private final PlayerBuffer zzii;

        zzae(DataHolder dataHolder) {
            super(dataHolder);
            this.zzii = new PlayerBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.Players.LoadPlayersResult
        public final PlayerBuffer getPlayers() {
            return this.zzii;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzal extends com.google.android.gms.games.internal.zzb {
        private final TaskCompletionSource<AnnotatedData<PlayerStats>> zzhp;

        zzal(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzao(DataHolder dataHolder) {
            int statusCode = dataHolder.getStatusCode();
            if (statusCode == 0 || statusCode == 3) {
                PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
                try {
                    PlayerStats freeze = playerStatsBuffer.getCount() > 0 ? ((PlayerStats) playerStatsBuffer.get(0)).freeze() : null;
                    playerStatsBuffer.close();
                    this.zzhp.setResult(new AnnotatedData<>(freeze, statusCode == 3));
                    return;
                } catch (Throwable th) {
                    try {
                        playerStatsBuffer.close();
                    } catch (Throwable th2) {
                        zzei.zza(th, th2);
                    }
                    throw th;
                }
            }
            zzg.zza(this.zzhp, statusCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzam extends com.google.android.gms.games.internal.zzb {
        private final ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> zzis;

        zzam(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder) {
            this.zzis = listenerHolder;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(int i, int i2, String str) {
            ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder = this.zzis;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzao(i, i2, str) { // from class: com.google.android.gms.games.internal.zzah
                    private final int zzhh;
                    private final int zziq;
                    private final String zzir;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhh = i;
                        this.zziq = i2;
                        this.zzir = str;
                    }

                    @Override // com.google.android.gms.games.internal.zzg.zzao
                    public final void accept(Object obj) {
                        ((RealTimeMultiplayer.ReliableMessageSentCallback) obj).onRealTimeMessageSent(this.zzhh, this.zziq, this.zzir);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzan<T> extends com.google.android.gms.games.internal.zzb {
        private final BaseImplementation.ResultHolder<T> zzit;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzan(BaseImplementation.ResultHolder<T> resultHolder) {
            this.zzit = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setResult(T t) {
            this.zzit.setResult(t);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzc extends com.google.android.gms.games.internal.zzb {
        private final TaskCompletionSource<AnnotatedData<AchievementBuffer>> zzhp;

        zzc(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zza(DataHolder dataHolder) {
            int statusCode = dataHolder.getStatusCode();
            if (statusCode == 0 || statusCode == 3) {
                this.zzhp.setResult(new AnnotatedData<>(new AchievementBuffer(dataHolder), statusCode == 3));
            } else {
                zzg.zza(this.zzhp, statusCode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public class zzk extends zzed {
        /* JADX INFO: Access modifiers changed from: package-private */
        public zzk() {
            super(zzg.this.getContext().getMainLooper(), 1000);
        }

        @Override // com.google.android.gms.internal.games.zzed
        protected final void zzf(String str, int i) {
            try {
                if (zzg.this.isConnected()) {
                    ((zzbr) zzg.this.getService()).zza(str, i);
                    return;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
                sb.append("Unable to increment event ");
                sb.append(str);
                sb.append(" by ");
                sb.append(i);
                sb.append(" because the games client is no longer connected");
                com.google.android.gms.games.internal.zzaz.e("GamesGmsClientImpl", sb.toString());
            } catch (RemoteException e) {
                zzg.zza(e);
            } catch (SecurityException e2) {
                zzg.zza(e2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzq extends zzn implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzia;

        zzq(DataHolder dataHolder) {
            super(dataHolder);
            this.zzia = new LeaderboardBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        public final LeaderboardBuffer getLeaderboards() {
            return this.zzia;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzu<T> extends com.google.android.gms.games.internal.zzb {
        private final ListenerHolder<T> zzib;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzu(ListenerHolder<T> listenerHolder) {
            this.zzib = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void zzc(zzao<T> zzaoVar) {
            this.zzib.notifyListener(zzg.zza(zzaoVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzw extends zzn implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzic;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzw(DataHolder dataHolder) {
            super(dataHolder);
            this.zzic = new AchievementBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
        public final AchievementBuffer getAchievements() {
            return this.zzic;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzy extends zzn implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzid;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzy(DataHolder dataHolder) {
            super(dataHolder);
            this.zzid = new GameBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
        public final GameBuffer getGames() {
            return this.zzid;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzz extends zzn implements Events.LoadEventsResult {
        private final EventBuffer zzie;

        zzz(DataHolder dataHolder) {
            super(dataHolder);
            this.zzie = new EventBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.event.Events.LoadEventsResult
        public final EventBuffer getEvents() {
            return this.zzie;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zza extends com.google.android.gms.games.internal.zzb {
        private final TaskCompletionSource<Boolean> zzhp;

        zza(TaskCompletionSource<Boolean> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzb(int i, String str) {
            if (i == 0 || i == 3003) {
                this.zzhp.setResult(Boolean.valueOf(i == 3003));
            } else {
                zzg.zza(this.zzhp, i);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzad implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzhq;
        private final LoadMatchesResponse zzih;

        zzad(Status status, Bundle bundle) {
            this.zzhq = status;
            this.zzih = new LoadMatchesResponse(bundle);
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
        public final LoadMatchesResponse getMatches() {
            return this.zzih;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() {
            this.zzih.release();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzba implements Achievements.UpdateAchievementResult {
        private final String zzfe;
        private final Status zzhq;

        zzba(int i, String str) {
            this.zzhq = GamesStatusCodes.zza(i);
            this.zzfe = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
        public final String getAchievementId() {
            return this.zzfe;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzd extends com.google.android.gms.games.internal.zzb {
        private final TaskCompletionSource<Void> zzhp;

        zzd(TaskCompletionSource<Void> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        @Override // com.google.android.gms.games.internal.zzb, com.google.android.gms.games.internal.zzbn
        public final void zzb(int i, String str) {
            if (i == 0 || i == 3003) {
                this.zzhp.setResult(null);
            } else {
                zzg.zza(this.zzhp, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zze implements Videos.CaptureAvailableResult {
        private final Status zzhq;
        private final boolean zzhr;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zze(Status status, boolean z) {
            this.zzhq = status;
            this.zzhr = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureAvailableResult
        public final boolean isAvailable() {
            return this.zzhr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzf implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzhq;
        private final String zzhs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzf(Status status, String str) {
            this.zzhq = status;
            this.zzhs = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        public final String getMatchId() {
            return this.zzhs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* renamed from: com.google.android.gms.games.internal.zzg$zzg  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0003zzg implements Videos.CaptureStateResult {
        private final Status zzhq;
        private final CaptureState zzht;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0003zzg(Status status, CaptureState captureState) {
            this.zzhq = status;
            this.zzht = captureState;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureStateResult
        public final CaptureState getCaptureState() {
            return this.zzht;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzh implements Videos.CaptureCapabilitiesResult {
        private final Status zzhq;
        private final VideoCapabilities zzhu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzh(Status status, VideoCapabilities videoCapabilities) {
            this.zzhq = status;
            this.zzhu = videoCapabilities;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult
        public final VideoCapabilities getCapabilities() {
            return this.zzhu;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzi implements Snapshots.DeleteSnapshotResult {
        private final Status zzhq;
        private final String zzhv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzi(int i, String str) {
            this.zzhq = GamesStatusCodes.zza(i);
            this.zzhv = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
        public final String getSnapshotId() {
            return this.zzhv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzm implements Games.GetServerAuthCodeResult {
        private final Status zzhq;
        private final String zzhx;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzm(Status status, String str) {
            this.zzhq = status;
            this.zzhx = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzhq;
        }

        @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
        public final String getCode() {
            return this.zzhx;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzau extends zzn implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzjc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzau(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzjc = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        public final ScoreSubmissionData getScoreData() {
            return this.zzjc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzac extends zzn implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzig;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzac(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzig = (LeaderboardScoreEntity) ((LeaderboardScore) leaderboardScoreBuffer.get(0)).freeze();
                } else {
                    this.zzig = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
        public final LeaderboardScore getScore() {
            return this.zzig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaf extends zzn implements Stats.LoadPlayerStatsResult {
        private final PlayerStats zzij;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzaf(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzij = new PlayerStatsEntity((PlayerStats) playerStatsBuffer.get(0));
                } else {
                    this.zzij = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
        public final PlayerStats getPlayerStats() {
            return this.zzij;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static abstract class zzaz extends zzn {
        private final TurnBasedMatch match;

        zzaz(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.match = turnBasedMatchBuffer.get(0).freeze();
                } else {
                    this.match = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.match;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    public static final class zzj extends zzn implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzhw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzj(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzhw = new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0));
                } else {
                    this.zzhw = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
        public final SnapshotMetadata getSnapshotMetadata() {
            return this.zzhw;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    /* loaded from: classes.dex */
    private static final class zzah extends zzn implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzik;
        private final LeaderboardScoreBuffer zzil;

        zzah(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzik = (LeaderboardEntity) leaderboardBuffer.get(0).freeze();
                } else {
                    this.zzik = null;
                }
                leaderboardBuffer.release();
                this.zzil = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final Leaderboard getLeaderboard() {
            return this.zzik;
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final LeaderboardScoreBuffer getScores() {
            return this.zzil;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return this.zzhe.zzax == null;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzha = false;
    }

    public final void zzm(int i) {
        this.zzgz.setGravity(i);
    }

    public final void zza(View view) {
        this.zzgz.zzb(view);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    protected Set<Scope> validateScopes(Set<Scope> set) {
        HashSet hashSet = new HashSet(set);
        boolean contains = set.contains(Games.SCOPE_GAMES);
        boolean contains2 = set.contains(Games.SCOPE_GAMES_LITE);
        if (set.contains(Games.zzai)) {
            Preconditions.checkState(!contains, "Cannot have both %s and %s!", Scopes.GAMES, FirstPartyScopes.GAMES_1P);
        } else {
            Preconditions.checkState(contains || contains2, "Games APIs requires %s function.", Scopes.GAMES_LITE);
            if (contains2 && contains) {
                hashSet.remove(Games.SCOPE_GAMES_LITE);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzgx = null;
        this.zzgy = null;
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void disconnect() {
        this.zzha = false;
        if (isConnected()) {
            try {
                zzbr zzbrVar = (zzbr) getService();
                zzbrVar.zzcl();
                this.zzgv.flush();
                zzbrVar.zza(this.zzhc);
            } catch (RemoteException unused) {
                com.google.android.gms.games.internal.zzaz.w("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public Bundle getConnectionHint() {
        try {
            Bundle connectionHint = ((zzbr) getService()).getConnectionHint();
            if (connectionHint != null) {
                connectionHint.setClassLoader(zzg.class.getClassLoader());
                this.zzhf = connectionHint;
            }
            return connectionHint;
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Bundle zzbb() {
        Bundle connectionHint = getConnectionHint();
        if (connectionHint == null) {
            connectionHint = this.zzhf;
        }
        this.zzhf = null;
        return connectionHint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzg = this.zzhe.zzg();
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzgw);
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        zzg.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzgz.zzcr()));
        zzg.putInt("com.google.android.gms.games.key.API_VERSION", 6);
        zzg.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zzg;
    }

    public final String zzbc() throws RemoteException {
        return ((zzbr) getService()).zzbc();
    }

    public final String zzbd() {
        try {
            return zzbc();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(String str, BaseImplementation.ResultHolder<Games.GetServerAuthCodeResult> resultHolder) throws RemoteException {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        try {
            ((zzbr) getService()).zza(str, new com.google.android.gms.games.internal.zzy(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final String zza(boolean z) throws RemoteException {
        PlayerEntity playerEntity = this.zzgx;
        if (playerEntity != null) {
            return playerEntity.getPlayerId();
        }
        return ((zzbr) getService()).zzcm();
    }

    public final String zzb(boolean z) {
        try {
            return zza(true);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Player zzbe() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgx == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzbr) getService()).zzcn());
                if (playerBuffer.getCount() > 0) {
                    this.zzgx = (PlayerEntity) ((Player) playerBuffer.get(0)).freeze();
                }
                playerBuffer.release();
            }
        }
        return this.zzgx;
    }

    public final Player zzbf() {
        try {
            return zzbe();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Game zzbg() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgy == null) {
                GameBuffer gameBuffer = new GameBuffer(((zzbr) getService()).zzco());
                if (gameBuffer.getCount() > 0) {
                    this.zzgy = (GameEntity) ((Game) gameBuffer.get(0)).freeze();
                }
                gameBuffer.release();
            }
        }
        return this.zzgy;
    }

    public final Game zzbh() {
        try {
            return zzbg();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new zzak(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, int i, boolean z, boolean z2) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzak(resultHolder), i, z, z2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (!str.equals("played_with") && !str.equals(PlayersClient.zzdc)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid player collection: ".concat(valueOf) : new String("Invalid player collection: "));
        }
        try {
            ((zzbr) getService()).zza(new zzak(resultHolder), str, i, z, z2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzc(new zzak(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzbi() throws RemoteException {
        return ((zzbr) getService()).zzbi();
    }

    public final Intent zzbj() {
        try {
            return zzbi();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zza(String str, int i, int i2) {
        try {
            return ((zzbr) getService()).zzb(str, i, i2);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new zzs(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzs(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadPlayerScoreResult> resultHolder, String str, String str2, int i, int i2) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new com.google.android.gms.games.internal.zzx(resultHolder), (String) null, str2, i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzt(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new zzt(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzt(resultHolder), leaderboardScoreBuffer.zzdk().zzdj(), i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult> resultHolder, String str, long j, String str2) throws RemoteException {
        try {
            ((zzbr) getService()).zza(resultHolder == null ? null : new com.google.android.gms.games.internal.zzaa(resultHolder), str, j, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzbk() {
        try {
            return ((zzbr) getService()).zzbk();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzc(taskCompletionSource), z);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<Achievements.LoadAchievementsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new com.google.android.gms.games.internal.zzz(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zza(taskCompletionSource == null ? null : new zzd(taskCompletionSource), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zza(resultHolder == null ? null : new zzb(resultHolder), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(taskCompletionSource == null ? null : new zzd(taskCompletionSource), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza(taskCompletionSource == null ? null : new zza(taskCompletionSource), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza(resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(taskCompletionSource == null ? null : new zza(taskCompletionSource), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder, boolean z) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zze(new zzl(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder, boolean z, String... strArr) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zza(new zzl(resultHolder), z, strArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(String str, int i) {
        this.zzgv.zza(str, i);
    }

    public final Intent zzbl() {
        try {
            return ((zzbr) getService()).zzbl();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbm() {
        try {
            return ((zzbr) getService()).zzbm();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ListenerHolder<OnInvitationReceivedListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zza(new zzo(listenerHolder), this.zzhc);
    }

    public final void zzb(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
        try {
            zza(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbn() throws RemoteException {
        ((zzbr) getService()).zzb(this.zzhc);
    }

    public final void zzbo() {
        try {
            zzbn();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzc(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zzb(new zzai(listenerHolder), this.zzhc);
    }

    public final void zzd(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
        try {
            zzc(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbp() throws RemoteException {
        ((zzbr) getService()).zzc(this.zzhc);
    }

    public final void zzbq() {
        try {
            zzbp();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        return ((zzbr) getService()).zza(playerEntity);
    }

    public final Intent zzb(PlayerEntity playerEntity) {
        try {
            return zza(playerEntity);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbr() throws RemoteException {
        return ((zzbr) getService()).zzbr();
    }

    public final Intent zzbs() {
        try {
            return zzbr();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zza(Room room, int i) throws RemoteException {
        return ((zzbr) getService()).zza((RoomEntity) room.freeze(), i);
    }

    public final Intent zzb(Room room, int i) {
        try {
            return zza(room, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbt() throws RemoteException {
        return ((zzbr) getService()).zzbt();
    }

    public final Intent zzbu() {
        try {
            return zzbt();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<GamesMetadata.LoadGamesResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new com.google.android.gms.games.internal.zzac(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzb(new com.google.android.gms.games.internal.zzab(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zza(new com.google.android.gms.games.internal.zzi(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzbv() throws RemoteException {
        return ((zzbr) getService()).zzbv();
    }

    public final int zzbw() {
        try {
            return zzbv();
        } catch (RemoteException e) {
            zza(e);
            return 4368;
        }
    }

    public final String zzbx() throws RemoteException {
        return ((zzbr) getService()).zzbx();
    }

    public final String zzby() {
        try {
            return zzbx();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzr(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(String str, int i) throws RemoteException {
        ((zzbr) getService()).zzb(str, i);
    }

    public final void zzc(String str, int i) {
        try {
            zzb(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzd(String str, int i) throws RemoteException {
        ((zzbr) getService()).zzd(str, i);
    }

    public final void zze(String str, int i) {
        try {
            zzd(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        return ((zzbr) getService()).zza(i, i2, z);
    }

    public final Intent zzb(int i, int i2, boolean z) {
        try {
            return zza(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzax(resultHolder), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzdq(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new zzax(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzc(new zzax(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzbz() throws RemoteException {
        return ((zzbr) getService()).zzbz();
    }

    public final int zzca() {
        try {
            return zzbz();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzay(resultHolder), str, bArr, str2, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzay(resultHolder), str, bArr, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zze(new zzaw(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str, String str2) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzaw(resultHolder), str, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzf(BaseImplementation.ResultHolder<TurnBasedMultiplayer.CancelMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzd(new com.google.android.gms.games.internal.zzh(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(String str) throws RemoteException {
        ((zzbr) getService()).zze(str);
    }

    public final void zzd(String str) {
        try {
            zzc(str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder, int i, int[] iArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzbb(resultHolder), i, iArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzg(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzf(new com.google.android.gms.games.internal.zzk(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        return ((zzbr) getService()).zzc(i, i2, z);
    }

    public final Intent zzd(int i, int i2, boolean z) {
        try {
            return zzc(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbr) getService()).zza(new zzap(listenerHolder, listenerHolder2, listenerHolder3), this.zzhb, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzhc);
    }

    public final void zzb(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zza(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzc(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbr) getService()).zza((zzbn) new zzap(listenerHolder, listenerHolder2, listenerHolder3), (IBinder) this.zzhb, roomConfig.getInvitationId(), false, this.zzhc);
    }

    public final void zzd(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zzc(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, String str) {
        try {
            ((zzbr) getService()).zza(new zzap(listenerHolder), str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final int zza(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) throws RemoteException {
        return ((zzbr) getService()).zza(new zzam(listenerHolder), bArr, str, str2);
    }

    public final int zzb(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) {
        try {
            return zza(listenerHolder, bArr, str, str2);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str, String[] strArr) {
        Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
        try {
            Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
            return ((zzbr) getService()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str) throws RemoteException {
        return ((zzbr) getService()).zzb(bArr, str, (String[]) null);
    }

    public final int zzb(byte[] bArr, String str) {
        try {
            return zza(bArr, str);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zzn(int i) throws RemoteException {
        ((zzbr) getService()).zzn(i);
    }

    public final void zzo(int i) {
        try {
            zzn(i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzb(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzf(new zzal(taskCompletionSource), z);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zze(BaseImplementation.ResultHolder<Stats.LoadPlayerStatsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzf(new com.google.android.gms.games.internal.zzj(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzcb() throws RemoteException {
        return ((zzbr) getService()).zzcb();
    }

    public final int zzcc() {
        try {
            return zzcb();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzcd() throws RemoteException {
        return ((zzbr) getService()).zzcd();
    }

    public final int zzce() {
        try {
            return zzcd();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        return ((zzbr) getService()).zza(str, z, z2, i);
    }

    public final Intent zzb(String str, boolean z, boolean z2, int i) {
        try {
            return zza(str, z, z2, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzf(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzd(new zzas(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzat(resultHolder), str, z, i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.CommitSnapshotResult> resultHolder, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zzds = snapshotMetadataChange.zzds();
        if (zzds != null) {
            zzds.setTempDir(getContext().getCacheDir());
        }
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        try {
            ((zzbr) getService()).zza(new com.google.android.gms.games.internal.zzm(resultHolder), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzdr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(Snapshot snapshot) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        ((zzbr) getService()).zza(zzdr);
    }

    public final void zzb(Snapshot snapshot) {
        try {
            zza(snapshot);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzh(BaseImplementation.ResultHolder<Snapshots.DeleteSnapshotResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzg(new com.google.android.gms.games.internal.zzl(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zzds = snapshotMetadataChange.zzds();
        if (zzds != null) {
            zzds.setTempDir(getContext().getCacheDir());
        }
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        try {
            ((zzbr) getService()).zza(new zzat(resultHolder), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzdr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<Videos.CaptureCapabilitiesResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzc(new com.google.android.gms.games.internal.zzo(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzcf() throws RemoteException {
        return ((zzbr) getService()).zzcp();
    }

    public final Intent zzcg() {
        try {
            return zzcf();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<Videos.CaptureStateResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzd(new com.google.android.gms.games.internal.zzn(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Videos.CaptureAvailableResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new com.google.android.gms.games.internal.zzq(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final boolean zzch() throws RemoteException {
        return ((zzbr) getService()).zzch();
    }

    public final boolean zzci() {
        try {
            return zzch();
        } catch (RemoteException e) {
            zza(e);
            return false;
        }
    }

    public final void zze(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zzc(new com.google.android.gms.games.internal.zzs(listenerHolder), this.zzhc);
    }

    public final void zzf(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) {
        try {
            zze(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzcj() throws RemoteException {
        ((zzbr) getService()).zzd(this.zzhc);
    }

    public final void zzck() {
        try {
            zzcj();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((zzbr) getService()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcl() {
        if (isConnected()) {
            try {
                ((zzbr) getService()).zzcl();
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(RemoteException remoteException) {
        com.google.android.gms.games.internal.zzaz.w("GamesGmsClientImpl", "service died", remoteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(SecurityException securityException) {
        com.google.android.gms.games.internal.zzaz.e("GamesGmsClientImpl", "Is player signed out?", securityException);
    }

    private static <R> void zza(BaseImplementation.ResultHolder<R> resultHolder, SecurityException securityException) {
        if (resultHolder != null) {
            resultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    private static <R> void zza(TaskCompletionSource<R> taskCompletionSource, SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.setException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <R> void zza(TaskCompletionSource<R> taskCompletionSource, int i) {
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesStatusCodes.zza(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Room zzay(DataHolder dataHolder) {
        com.google.android.gms.games.multiplayer.realtime.zzb zzbVar = new com.google.android.gms.games.multiplayer.realtime.zzb(dataHolder);
        try {
            return zzbVar.getCount() > 0 ? zzbVar.get(0).freeze() : null;
        } finally {
            zzbVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(zzg.class.getClassLoader());
            boolean z = bundle.getBoolean("show_welcome_popup");
            this.zzha = z;
            this.zzhd = z;
            this.zzgx = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzgy = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(zzao<T> zzaoVar) {
        return new com.google.android.gms.games.internal.zzu(zzaoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, zzaq<T> zzaqVar) {
        return new com.google.android.gms.games.internal.zzt(zzaqVar, dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, String[] strArr, zzar<T> zzarVar) {
        return new com.google.android.gms.games.internal.zzw(zzarVar, dataHolder, new ArrayList(Arrays.asList(strArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, zzav<T> zzavVar) {
        return new com.google.android.gms.games.internal.zzv(zzavVar, dataHolder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzbr zzbrVar = (zzbr) iInterface;
        super.onConnectedLocked(zzbrVar);
        if (this.zzha) {
            this.zzgz.zzct();
            this.zzha = false;
        }
        if (this.zzhe.zzan || this.zzhe.zzau) {
            return;
        }
        try {
            zzbrVar.zza(new com.google.android.gms.games.internal.zzp(new zzbt(this.zzgz.zzcs())), this.zzhc);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzbr) {
            return (zzbr) queryLocalInterface;
        }
        return new zzbq(iBinder);
    }
}