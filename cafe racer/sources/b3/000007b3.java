package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class GamesCallbackStatusCodes {
    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int MULTIPLAYER_DISABLED = 6003;
    public static final int OK = 0;
    public static final int REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int REAL_TIME_ROOM_NOT_JOINED = 7004;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnJoinedRoomStatusCodes {
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnLeftRoomStatusCodes {
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRealTimeMessageSentStatusCodes {
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRoomConnectedStatusCodes {
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRoomCreatedStatusCodes {
    }

    public static String getStatusCodeString(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 6003) {
                        if (i != 7004) {
                            if (i != 7000) {
                                if (i != 7001) {
                                    StringBuilder sb = new StringBuilder(47);
                                    sb.append("unknown games callback status code: ");
                                    sb.append(i);
                                    return sb.toString();
                                }
                                return "REAL_TIME_MESSAGE_SEND_FAILED";
                            }
                            return "REAL_TIME_CONNECTION_FAILED";
                        }
                        return "REAL_TIME_ROOM_NOT_JOINED";
                    }
                    return "MULTIPLAYER_DISABLED";
                }
                return "CLIENT_RECONNECT_REQUIRED";
            }
            return "INTERNAL_ERROR";
        }
        return "OK";
    }

    private GamesCallbackStatusCodes() {
    }
}