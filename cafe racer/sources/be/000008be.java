package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class ParticipantUtils {
    private ParticipantUtils() {
    }

    public static String getParticipantId(ArrayList<Participant> arrayList, String str) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Participant participant = arrayList.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }
}