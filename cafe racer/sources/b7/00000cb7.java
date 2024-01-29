package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzfl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<zzfh, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> zza(Payload payload) throws IOException {
        int type = payload.getType();
        if (type != 1) {
            if (type == 2) {
                return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzc(payload.asFile().asParcelFileDescriptor()).zze(payload.asFile().asJavaFile() == null ? null : payload.asFile().asJavaFile().getAbsolutePath()).zzc(payload.asFile().getSize()).zzr(), null);
            } else if (type != 3) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                throw illegalArgumentException;
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                    return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzc(createPipe[0]).zzd(createPipe2[0]).zzr(), Pair.create(createPipe[1], createPipe2[1]));
                } catch (IOException e) {
                    Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                    throw e;
                }
            }
        }
        return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzb(payload.asBytes()).zzr(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Payload zza(zzfh zzfhVar) {
        long id = zzfhVar.getId();
        int type = zzfhVar.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzfhVar.getId()), Integer.valueOf(zzfhVar.getType())));
                    return null;
                }
                return Payload.zza(Payload.Stream.zzb(zzfhVar.zzo()), id);
            }
            String zzp = zzfhVar.zzp();
            if (zzp != null) {
                try {
                    return Payload.zza(Payload.File.zza(new File(zzp), zzfhVar.zzq()), id);
                } catch (FileNotFoundException e) {
                    String valueOf = String.valueOf(zzp);
                    Log.w("NearbyConnections", valueOf.length() != 0 ? "Failed to create Payload from ParcelablePayload: Java file not found at ".concat(valueOf) : new String("Failed to create Payload from ParcelablePayload: Java file not found at "), e);
                }
            }
            return Payload.zza(Payload.File.zza(zzfhVar.zzo()), id);
        }
        return Payload.zza(zzfhVar.getBytes(), id);
    }
}