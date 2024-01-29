package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

/* loaded from: classes.dex */
public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    private final com.google.android.gms.nearby.messages.internal.zzg zzes;

    public EddystoneUid(String str) {
        this(com.google.android.gms.nearby.messages.internal.zzc.zzm(str));
    }

    public EddystoneUid(String str, String str2) {
        this.zzes = new com.google.android.gms.nearby.messages.internal.zzg(str, str2);
    }

    private EddystoneUid(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.zzes = new com.google.android.gms.nearby.messages.internal.zzg(bArr);
    }

    public static EddystoneUid from(Message message) {
        boolean zzl = message.zzl(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 58);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        Preconditions.checkArgument(zzl, sb.toString());
        return new EddystoneUid(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EddystoneUid) {
            return Objects.equal(this.zzes, ((EddystoneUid) obj).zzes);
        }
        return false;
    }

    public String getHex() {
        return this.zzes.getHex();
    }

    public String getInstance() {
        byte[] bytes = this.zzes.getBytes();
        if (bytes.length < 16) {
            return null;
        }
        return com.google.android.gms.nearby.messages.internal.zzc.zzf(Arrays.copyOfRange(bytes, 10, 16));
    }

    public String getNamespace() {
        return com.google.android.gms.nearby.messages.internal.zzc.zzf(Arrays.copyOfRange(this.zzes.getBytes(), 0, 10));
    }

    public int hashCode() {
        return Objects.hashCode(this.zzes);
    }

    public String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 17);
        sb.append("EddystoneUid{id=");
        sb.append(hex);
        sb.append('}');
        return sb.toString();
    }
}