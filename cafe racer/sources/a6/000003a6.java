package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    /* compiled from: com.android.billingclient:billing@@4.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String zza;

        private Builder() {
        }

        /* synthetic */ Builder(zza zzaVar) {
        }

        public AcknowledgePurchaseParams build() {
            if (this.zza != null) {
                AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
                acknowledgePurchaseParams.zza = this.zza;
                return acknowledgePurchaseParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    private AcknowledgePurchaseParams() {
    }

    /* synthetic */ AcknowledgePurchaseParams(zza zzaVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}