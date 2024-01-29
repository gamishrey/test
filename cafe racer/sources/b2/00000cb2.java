package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfg implements Runnable {
    private final /* synthetic */ long zzcx;
    private final /* synthetic */ InputStream zzdr;
    private final /* synthetic */ OutputStream zzds;
    private final /* synthetic */ OutputStream zzdt;
    private final /* synthetic */ zzff zzdu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfg(zzff zzffVar, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.zzdu = zzffVar;
        this.zzdr = inputStream;
        this.zzds = outputStream;
        this.zzcx = j;
        this.zzdt = outputStream2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        this.zzdu.zzdp = this.zzdr;
        boolean z2 = false;
        try {
            IOUtils.copyStream(this.zzdr, this.zzds, false, 65536);
            IOUtils.closeQuietly(this.zzdr);
            zzff zzffVar = this.zzdu;
            zzff.zza(this.zzdt, false, this.zzcx);
        } catch (IOException e) {
            try {
                z = this.zzdu.zzdq;
                if (z) {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.zzcx)));
                } else {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.zzcx)), e);
                }
                IOUtils.closeQuietly(this.zzdr);
                zzff zzffVar2 = this.zzdu;
                zzff.zza(this.zzdt, true, this.zzcx);
            } catch (Throwable th) {
                th = th;
                z2 = true;
                IOUtils.closeQuietly(this.zzdr);
                zzff zzffVar3 = this.zzdu;
                zzff.zza(this.zzdt, z2, this.zzcx);
                IOUtils.closeQuietly(this.zzds);
                this.zzdu.zzdp = null;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(this.zzdr);
            zzff zzffVar32 = this.zzdu;
            zzff.zza(this.zzdt, z2, this.zzcx);
            IOUtils.closeQuietly(this.zzds);
            this.zzdu.zzdp = null;
            throw th;
        }
        IOUtils.closeQuietly(this.zzds);
        this.zzdu.zzdp = null;
    }
}