package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbq extends com.google.android.gms.internal.games.zzb implements zzbr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5001, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zzb(5002, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final String zzbx() throws RemoteException {
        Parcel zza = zza(5003, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Bundle getConnectionHint() throws RemoteException {
        Parcel zza = zza(5004, zza());
        Bundle bundle = (Bundle) com.google.android.gms.internal.games.zzd.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(5005, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzcl() throws RemoteException {
        zzb(5006, zza());
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final String zzbc() throws RemoteException {
        Parcel zza = zza(5007, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final String zzcm() throws RemoteException {
        Parcel zza = zza(5012, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final DataHolder zzcn() throws RemoteException {
        Parcel zza = zza(5013, zza());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzd.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeInt(i);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z2);
        zzb(5015, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(5019, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(5020, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(5021, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(5023, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(5024, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(5025, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zzb(5026, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzd(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5028, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(5029, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeLong(j);
        zzb(5058, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5059, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeStrongBinder(iBinder);
        zza.writeInt(i);
        zza.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5030, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeStrongBinder(iBinder);
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, false);
        zza.writeLong(j);
        zzb(5031, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(5032, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zza(zzbn zzbnVar, byte[] bArr, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zza2 = zza(5033, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zza.writeString(str);
        zza.writeStringArray(strArr);
        Parcel zza2 = zza(5034, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzn(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzb(5036, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final DataHolder zzco() throws RemoteException {
        Parcel zza = zza(5502, zza());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzd.zza(zza, DataHolder.CREATOR);
        zza.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzb(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzb(8001, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8002, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzd.zza(zza, bundle);
        zzb(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzc(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(8006, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeString(str2);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeByteArray(bArr);
        zza.writeTypedArray(participantResultArr, 0);
        zzb(ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzd(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zze(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(8010, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzb(ConnectionsStatusCodes.STATUS_ENDPOINT_UNKNOWN, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeLong(j);
        zzb(ConnectionsStatusCodes.STATUS_ENDPOINT_IO_ERROR, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzc(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzf(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(8014, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zzbz() throws RemoteException {
        Parcel zza = zza(8024, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzc(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(8027, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbi() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbk() throws RemoteException {
        Parcel zza = zza(9005, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbl() throws RemoteException {
        Parcel zza = zza(GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbm() throws RemoteException {
        Parcel zza = zza(9007, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(9008, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        Parcel zza2 = zza(GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbr() throws RemoteException {
        Parcel zza = zza(9010, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zza(RoomEntity roomEntity, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, roomEntity);
        zza.writeInt(i);
        Parcel zza2 = zza(9011, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzbt() throws RemoteException {
        Parcel zza = zza(9012, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zzbv() throws RemoteException {
        Parcel zza = zza(9019, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeInt(i);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z2);
        zzb(9020, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeInt(i);
        zzb(10016, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, int i, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeInt(i);
        zza.writeIntArray(iArr);
        zzb(10018, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z2);
        zza.writeInt(i);
        Parcel zza2 = zza(12001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzd(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(12002, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.zza(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzd.zza(zza, contents);
        zzb(12007, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, contents);
        zzb(12019, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzg(zzbn zzbnVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zzb(12020, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.games.zzd.zza(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzd.zza(zza, contents);
        zzb(12033, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zzcb() throws RemoteException {
        Parcel zza = zza(12035, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final int zzcd() throws RemoteException {
        Parcel zza = zza(12036, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zze(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(12016, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zza.writeStringArray(strArr);
        zzb(12031, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzb(12017, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(13006, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbn zzbnVar, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zza.writeInt(i);
        zzb(15001, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(zzbp zzbpVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbpVar);
        zza.writeLong(j);
        zzb(15501, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, playerEntity);
        Parcel zza2 = zza(15503, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzf(zzbn zzbnVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        com.google.android.gms.internal.games.zzd.writeBoolean(zza, z);
        zzb(17001, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzb(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zza2 = zza(18001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza2, Intent.CREATOR);
        zza2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final Intent zzcp() throws RemoteException {
        Parcel zza = zza(19002, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zza(String str, zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zzb(20001, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzc(zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zzb(21007, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzb(zzbn zzbnVar, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeInt(i);
        zzb(22016, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzc(zzbn zzbnVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zza.writeLong(j);
        zzb(22026, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzd(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(22027, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final void zzd(zzbn zzbnVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games.zzd.zza(zza, zzbnVar);
        zzb(22028, zza);
    }

    @Override // com.google.android.gms.games.internal.zzbr
    public final boolean zzch() throws RemoteException {
        Parcel zza = zza(22030, zza());
        boolean zza2 = com.google.android.gms.internal.games.zzd.zza(zza);
        zza.recycle();
        return zza2;
    }
}