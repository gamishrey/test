package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzw implements PendingResultUtil.ResultConverter<Invitations.LoadInvitationsResult, InvitationBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ InvitationBuffer convert(Invitations.LoadInvitationsResult loadInvitationsResult) {
        Invitations.LoadInvitationsResult loadInvitationsResult2 = loadInvitationsResult;
        if (loadInvitationsResult2 == null) {
            return null;
        }
        return loadInvitationsResult2.getInvitations();
    }
}