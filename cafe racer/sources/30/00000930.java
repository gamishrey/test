package com.google.android.gms.games;

import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
final class zzb implements PendingResultUtil.ResultConverter<Events.LoadEventsResult, EventBuffer> {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ EventBuffer convert(Events.LoadEventsResult loadEventsResult) {
        Events.LoadEventsResult loadEventsResult2 = loadEventsResult;
        if (loadEventsResult2 == null) {
            return null;
        }
        return loadEventsResult2.getEvents();
    }
}