package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class LeaderboardEntity implements Leaderboard {
    private final String zzj;
    private final Uri zzn;
    private final String zznt;
    private final int zznu;
    private final ArrayList<LeaderboardVariantEntity> zznv;
    private final Game zznw;
    private final String zzy;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zznt = leaderboard.getLeaderboardId();
        this.zzj = leaderboard.getDisplayName();
        this.zzn = leaderboard.getIconImageUri();
        this.zzy = leaderboard.getIconImageUrl();
        this.zznu = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zznw = game == null ? null : new GameEntity(game);
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.zznv = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zznv.add((LeaderboardVariantEntity) variants.get(i).freeze());
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Leaderboard freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return this.zznt;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getIconImageUrl() {
        return this.zzy;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.zznu;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zznv);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game getGame() {
        return this.zznw;
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Leaderboard leaderboard) {
        return Objects.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Leaderboard leaderboard, Object obj) {
        if (obj instanceof Leaderboard) {
            if (leaderboard == obj) {
                return true;
            }
            Leaderboard leaderboard2 = (Leaderboard) obj;
            return Objects.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && Objects.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && Objects.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && Objects.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && Objects.equal(leaderboard2.getVariants(), leaderboard.getVariants());
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(Leaderboard leaderboard) {
        return Objects.toStringHelper(leaderboard).add("LeaderboardId", leaderboard.getLeaderboardId()).add("DisplayName", leaderboard.getDisplayName()).add("IconImageUri", leaderboard.getIconImageUri()).add("IconImageUrl", leaderboard.getIconImageUrl()).add("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).add("Variants", leaderboard.getVariants()).toString();
    }
}