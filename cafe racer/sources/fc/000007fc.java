package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class EventEntity extends zzc implements Event {
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    private final String description;
    private final String name;
    private final long value;
    private final PlayerEntity zzfl;
    private final String zzgn;
    private final String zzgo;
    private final boolean zzgp;
    private final Uri zzn;
    private final String zzy;

    public EventEntity(Event event) {
        this.zzgn = event.getEventId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.zzn = event.getIconImageUri();
        this.zzy = event.getIconImageUrl();
        this.zzfl = (PlayerEntity) event.getPlayer().freeze();
        this.value = event.getValue();
        this.zzgo = event.getFormattedValue();
        this.zzgp = event.isVisible();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public final Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventEntity(String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.zzgn = str;
        this.name = str2;
        this.description = str3;
        this.zzn = uri;
        this.zzy = str4;
        this.zzfl = new PlayerEntity(player);
        this.value = j;
        this.zzgo = str5;
        this.zzgp = z;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getEventId() {
        return this.zzgn;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getName() {
        return this.name;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.name, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final Uri getIconImageUri() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getIconImageUrl() {
        return this.zzy;
    }

    @Override // com.google.android.gms.games.event.Event
    public final Player getPlayer() {
        return this.zzfl;
    }

    @Override // com.google.android.gms.games.event.Event
    public final long getValue() {
        return this.value;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getFormattedValue() {
        return this.zzgo;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzgo, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return this.zzgp;
    }

    public final int hashCode() {
        return zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Event event, Object obj) {
        if (obj instanceof Event) {
            if (event == obj) {
                return true;
            }
            Event event2 = (Event) obj;
            return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
        }
        return false;
    }

    public final String toString() {
        return zzb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}