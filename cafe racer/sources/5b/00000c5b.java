package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.List;

/* loaded from: classes.dex */
public final class zzca implements Connections {
    public static final Api.ClientKey<zzx> CLIENT_KEY = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<zzx, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new zzcb();

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> acceptConnection(GoogleApiClient googleApiClient, String str, PayloadCallback payloadCallback) {
        return googleApiClient.execute(new zzct(this, googleApiClient, str, googleApiClient.registerListener(payloadCallback)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, Connections.MessageListener messageListener) {
        return googleApiClient.execute(new zzck(this, googleApiClient, str, bArr, googleApiClient.registerListener(messageListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> cancelPayload(GoogleApiClient googleApiClient, long j) {
        return googleApiClient.execute(new zzce(this, googleApiClient, j));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        googleApiClient.execute(new zzcf(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> rejectConnection(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzcu(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzcl(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> requestConnection(GoogleApiClient googleApiClient, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        return googleApiClient.execute(new zzcs(this, googleApiClient, str, str2, googleApiClient.registerListener(connectionLifecycleCallback)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        return googleApiClient.execute(new zzcj(this, googleApiClient, str, str2, bArr, googleApiClient.registerListener(connectionResponseCallback), googleApiClient.registerListener(messageListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> sendPayload(GoogleApiClient googleApiClient, String str, Payload payload) {
        return googleApiClient.execute(new zzcc(this, googleApiClient, str, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> sendPayload(GoogleApiClient googleApiClient, List<String> list, Payload payload) {
        return googleApiClient.execute(new zzcd(this, googleApiClient, list, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        googleApiClient.execute(new zzcm(this, googleApiClient, str, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        googleApiClient.execute(new zzcn(this, googleApiClient, list, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        sendPayload(googleApiClient, str, Payload.fromBytes(bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        sendPayload(googleApiClient, list, Payload.fromBytes(bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, Connections.ConnectionRequestListener connectionRequestListener) {
        return googleApiClient.execute(new zzch(this, googleApiClient, str, j, googleApiClient.registerListener(connectionRequestListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        return googleApiClient.execute(new zzco(this, googleApiClient, str, str2, googleApiClient.registerListener(connectionLifecycleCallback), advertisingOptions));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        return googleApiClient.execute(new zzci(this, googleApiClient, str, j, googleApiClient.registerListener(endpointDiscoveryListener)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        return googleApiClient.execute(new zzcq(this, googleApiClient, str, googleApiClient.registerListener(endpointDiscoveryCallback), discoveryOptions));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAdvertising(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzcp(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAllEndpoints(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzcg(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopDiscovery(GoogleApiClient googleApiClient) {
        googleApiClient.execute(new zzcr(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        stopDiscovery(googleApiClient);
    }
}