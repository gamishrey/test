package com.google.android.gms.games.internal;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public interface zze {
    public static final String zzgq;
    public static final String zzgr;
    public static final String zzgs;
    public static final String[] zzgt;

    static {
        char[] cArr = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 165, 177, 168, 164, 173, 163, 158, 178, 179, 160, 179, 180, 178};
        for (int i = 0; i < 27; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        zzgq = new String(cArr);
        char[] cArr2 = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 173, 168, 162, 170, 173, 160, 172, 164};
        for (int i2 = 0; i2 < 22; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - '?');
        }
        zzgr = new String(cArr2);
        char[] cArr3 = {175, 171, 160, 184, 158, 179, 174, 166, 164, 179, 167, 164, 177, 158, 168, 173, 181, 168, 179, 160, 179, 168, 174, 173, 158, 173, 168, 162, 170, 173, 160, 172, 164};
        for (int i3 = 0; i3 < 33; i3++) {
            cArr3[i3] = (char) (cArr3[i3] - '?');
        }
        String str = new String(cArr3);
        zzgs = str;
        zzgt = new String[]{"external_player_id", "profile_icon_image_id", "profile_hi_res_image_id", "profile_icon_image_uri", "profile_icon_image_url", "profile_hi_res_image_uri", "profile_hi_res_image_url", "profile_name", "last_updated", "is_in_circles", "has_all_public_acls", "has_debug_access", "is_profile_visible", "current_xp_total", "current_level", "current_level_min_xp", "current_level_max_xp", "next_level", "next_level_max_xp", "last_level_up_timestamp", "player_title", "most_recent_external_game_id", "most_recent_game_name", "most_recent_activity_timestamp", "most_recent_game_icon_id", "most_recent_game_icon_uri", "most_recent_game_hi_res_id", "most_recent_game_hi_res_uri", "most_recent_game_featured_id", "most_recent_game_featured_uri", "gamer_tag", "real_name", "banner_image_landscape_id", "banner_image_landscape_uri", "banner_image_landscape_url", "banner_image_portrait_id", "banner_image_portrait_uri", "banner_image_portrait_url", "gamer_friend_status", "gamer_friend_update_timestamp", "is_muted", "total_unlocked_achievements", zzgq, zzgr, str};
    }
}