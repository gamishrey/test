package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes.dex */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzcd();
    private final int versionCode;
    @Deprecated
    private final String zzff;
    @Deprecated
    private final boolean zzfg;
    @Deprecated
    private final String zzfj;
    private final boolean zzgb;
    private final int zzgc;
    private final int zzhf;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;
    private final Strategy zzit;
    @Deprecated
    private final boolean zziu;
    private final zzm zziy;
    private final MessageFilter zziz;
    private final PendingIntent zzja;
    @Deprecated
    private final int zzjb;
    private final byte[] zzjc;
    private final zzaa zzjd;

    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext, boolean z3, int i3, int i4) {
        zzm zzoVar;
        zzp zzrVar;
        this.versionCode = i;
        zzaa zzaaVar = null;
        if (iBinder == null) {
            zzoVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzoVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.zziy = zzoVar;
        this.zzit = strategy;
        if (iBinder2 == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.zzhh = zzrVar;
        this.zziz = messageFilter;
        this.zzja = pendingIntent;
        this.zzjb = i2;
        this.zzff = str;
        this.zzfj = str2;
        this.zzjc = bArr;
        this.zziu = z;
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzaaVar = queryLocalInterface3 instanceof zzaa ? (zzaa) queryLocalInterface3 : new zzac(iBinder3);
        }
        this.zzjd = zzaaVar;
        this.zzfg = z2;
        this.zzhi = ClientAppContext.zza(clientAppContext, str2, str, z2);
        this.zzgb = z3;
        this.zzgc = i3;
        this.zzhf = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, bArr, iBinder3, z, 0, i);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public final String toString() {
        String sb;
        String valueOf = String.valueOf(this.zziy);
        String valueOf2 = String.valueOf(this.zzit);
        String valueOf3 = String.valueOf(this.zzhh);
        String valueOf4 = String.valueOf(this.zziz);
        String valueOf5 = String.valueOf(this.zzja);
        byte[] bArr = this.zzjc;
        if (bArr == null) {
            sb = null;
        } else {
            int length = bArr.length;
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("<");
            sb2.append(length);
            sb2.append(" bytes>");
            sb = sb2.toString();
        }
        String valueOf6 = String.valueOf(this.zzjd);
        boolean z = this.zzfg;
        String valueOf7 = String.valueOf(this.zzhi);
        boolean z2 = this.zzgb;
        String str = this.zzff;
        String str2 = this.zzfj;
        boolean z3 = this.zziu;
        int i = this.zzhf;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 291 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(sb).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(str2).length());
        sb3.append("SubscribeRequest{messageListener=");
        sb3.append(valueOf);
        sb3.append(", strategy=");
        sb3.append(valueOf2);
        sb3.append(", callback=");
        sb3.append(valueOf3);
        sb3.append(", filter=");
        sb3.append(valueOf4);
        sb3.append(", pendingIntent=");
        sb3.append(valueOf5);
        sb3.append(", hint=");
        sb3.append(sb);
        sb3.append(", subscribeCallback=");
        sb3.append(valueOf6);
        sb3.append(", useRealClientApiKey=");
        sb3.append(z);
        sb3.append(", clientAppContext=");
        sb3.append(valueOf7);
        sb3.append(", isDiscardPendingIntent=");
        sb3.append(z2);
        sb3.append(", zeroPartyPackageName=");
        sb3.append(str);
        sb3.append(", realClientPackageName=");
        sb3.append(str2);
        sb3.append(", isIgnoreNearbyPermission=");
        sb3.append(z3);
        sb3.append(", callingContext=");
        sb3.append(i);
        sb3.append("}");
        return sb3.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        zzm zzmVar = this.zziy;
        SafeParcelWriter.writeIBinder(parcel, 2, zzmVar == null ? null : zzmVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzit, i, false);
        zzp zzpVar = this.zzhh;
        SafeParcelWriter.writeIBinder(parcel, 4, zzpVar == null ? null : zzpVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zziz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzja, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzjb);
        SafeParcelWriter.writeString(parcel, 8, this.zzff, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzfj, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzjc, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zziu);
        zzaa zzaaVar = this.zzjd;
        SafeParcelWriter.writeIBinder(parcel, 12, zzaaVar != null ? zzaaVar.asBinder() : null, false);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzhi, i, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzgb);
        SafeParcelWriter.writeInt(parcel, 16, this.zzgc);
        SafeParcelWriter.writeInt(parcel, 17, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}