package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzm();
    public static final DriveSpace zzah = new DriveSpace("DRIVE");
    public static final DriveSpace zzai = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzaj;
    private static final Set<DriveSpace> zzak;
    private static final String zzal;
    private static final Pattern zzam;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriveSpace(String str) {
        this.name = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.name.equals(((DriveSpace) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    static {
        DriveSpace driveSpace = new DriveSpace("PHOTOS");
        zzaj = driveSpace;
        Set<DriveSpace> of = CollectionUtils.setOf(zzah, zzai, driveSpace);
        zzak = of;
        zzal = TextUtils.join(",", of.toArray());
        zzam = Pattern.compile("[A-Z0-9_]*");
    }
}