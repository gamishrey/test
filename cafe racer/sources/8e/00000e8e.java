package com.unity.androidnotifications;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class UnityNotificationUtilities {
    private static final int INTENT_SERIALIZATION_VERSION = 0;
    private static final int NOTIFICATION_SERIALIZATION_VERSION = 2;
    static final String SAVED_NOTIFICATION_FALLBACK_KEY = "fallback.data";
    static final String SAVED_NOTIFICATION_PRIMARY_KEY = "data";
    static final byte[] UNITY_MAGIC_NUMBER = {85, 77, 78, 78};
    private static final byte[] UNITY_MAGIC_NUMBER_PARCELLED = {85, 77, 78, 80};

    UnityNotificationUtilities() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int findResourceIdInContextByName(Context context, String str) {
        if (str == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
                return identifier == 0 ? resources.getIdentifier(str, "drawable", context.getPackageName()) : identifier;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void serializeNotification(SharedPreferences sharedPreferences, Notification notification, boolean z) {
        String encodeToString;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("unityNotification", notification);
                if (!serializeNotificationParcel(intent, dataOutputStream)) {
                    return;
                }
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray, 0, byteArray.length, 0);
            } else if (!serializeNotificationCustom(notification, dataOutputStream)) {
                return;
            } else {
                dataOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray2, 0, byteArray2.length, 0);
            }
            SharedPreferences.Editor clear = sharedPreferences.edit().clear();
            clear.putString("data", encodeToString);
            clear.apply();
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
        }
    }

    static boolean serializeNotificationParcel(Intent intent, DataOutputStream dataOutputStream) {
        try {
            byte[] serializeParcelable = serializeParcelable(intent);
            if (serializeParcelable != null && serializeParcelable.length != 0) {
                dataOutputStream.write(UNITY_MAGIC_NUMBER_PARCELLED);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(serializeParcelable.length);
                dataOutputStream.write(serializeParcelable);
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e2);
            return false;
        }
    }

    private static boolean serializeNotificationCustom(Notification notification, DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.write(UNITY_MAGIC_NUMBER);
            dataOutputStream.writeInt(2);
            boolean z = notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
            dataOutputStream.writeInt(notification.extras.getInt("id"));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TITLE));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TEXT));
            serializeString(dataOutputStream, notification.extras.getString("smallIcon"));
            serializeString(dataOutputStream, notification.extras.getString("largeIcon"));
            dataOutputStream.writeLong(notification.extras.getLong("fireTime", -1L));
            dataOutputStream.writeLong(notification.extras.getLong("repeatInterval", -1L));
            String str = null;
            serializeString(dataOutputStream, Build.VERSION.SDK_INT < 21 ? null : notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
            dataOutputStream.writeBoolean(z);
            serializeString(dataOutputStream, notification.extras.getString("data"));
            dataOutputStream.writeBoolean(notification.extras.getBoolean("com.unity.showInForeground", true));
            if (Build.VERSION.SDK_INT >= 26) {
                str = notification.getChannelId();
            }
            serializeString(dataOutputStream, str);
            Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
            dataOutputStream.writeBoolean(notificationColor != null);
            if (notificationColor != null) {
                dataOutputStream.writeInt(notificationColor.intValue());
            }
            dataOutputStream.writeInt(notification.number);
            dataOutputStream.writeBoolean((notification.flags & 16) != 0);
            serializeString(dataOutputStream, notification.getGroup());
            dataOutputStream.writeBoolean((notification.flags & 512) != 0);
            dataOutputStream.writeInt(UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
            serializeString(dataOutputStream, notification.getSortKey());
            if (z) {
                dataOutputStream.writeLong(notification.when);
            }
            return true;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
            return false;
        }
    }

    static void serializeString(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            dataOutputStream.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    static byte[] serializeParcelable(Parcelable parcelable) {
        try {
            Parcel obtain = Parcel.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelable("obj", parcelable);
            obtain.writeParcelable(bundle, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object deserializeNotification(Context context, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("data", "");
        if (string != null && string.length() > 0) {
            Object deserializeNotification = deserializeNotification(context, Base64.decode(string, 0));
            if (deserializeNotification != null) {
                return deserializeNotification;
            }
            String string2 = sharedPreferences.getString(SAVED_NOTIFICATION_FALLBACK_KEY, "");
            if (string2 != null && string2.length() > 0) {
                return deserializeNotification(context, Base64.decode(string2, 0));
            }
        }
        return null;
    }

    private static Object deserializeNotification(Context context, byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        Notification deserializeNotificationParcelable = deserializeNotificationParcelable(dataInputStream);
        if (deserializeNotificationParcelable != null) {
            return deserializeNotificationParcelable;
        }
        byteArrayInputStream.reset();
        Notification.Builder deserializeNotificationCustom = deserializeNotificationCustom(context, dataInputStream);
        return deserializeNotificationCustom == null ? deserializedFromOldIntent(context, bArr) : deserializeNotificationCustom;
    }

    private static boolean readAndCheckMagicNumber(DataInputStream dataInputStream, byte[] bArr) {
        for (byte b : bArr) {
            try {
                if (dataInputStream.readByte() != b) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    private static Notification deserializeNotificationParcelable(DataInputStream dataInputStream) {
        int readInt;
        try {
            if (readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER_PARCELLED) && (readInt = dataInputStream.readInt()) >= 0 && readInt <= 0) {
                return (Notification) ((Intent) deserializeParcelable(dataInputStream)).getParcelableExtra("unityNotification");
            }
            return null;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e2);
            return null;
        }
    }

    private static Notification.Builder deserializeNotificationCustom(Context context, DataInputStream dataInputStream) {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        String string2;
        long j;
        String string3;
        boolean z;
        String str5;
        String str6;
        long j2;
        boolean z2;
        String string4;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        try {
            if (readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER)) {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    Bundle bundle = readInt < 2 ? (Bundle) deserializeParcelable(dataInputStream) : null;
                    if (bundle == null) {
                        i = dataInputStream.readInt();
                        string = deserializeString(dataInputStream);
                        string2 = deserializeString(dataInputStream);
                        String deserializeString = deserializeString(dataInputStream);
                        String deserializeString2 = deserializeString(dataInputStream);
                        j = dataInputStream.readLong();
                        long readLong = dataInputStream.readLong();
                        string3 = deserializeString(dataInputStream);
                        boolean readBoolean = dataInputStream.readBoolean();
                        z = dataInputStream.readBoolean();
                        String deserializeString3 = deserializeString(dataInputStream);
                        if (readInt > 0) {
                            z3 = dataInputStream.readBoolean();
                            str5 = deserializeString;
                            str6 = deserializeString2;
                            j2 = readLong;
                            z2 = readBoolean;
                            string4 = deserializeString3;
                        } else {
                            str5 = deserializeString;
                            str6 = deserializeString2;
                            j2 = readLong;
                            z2 = readBoolean;
                            string4 = deserializeString3;
                            z3 = true;
                        }
                    } else {
                        string = bundle.getString(NotificationCompat.EXTRA_TITLE);
                        string2 = bundle.getString(NotificationCompat.EXTRA_TEXT);
                        String string5 = bundle.getString("smallIcon");
                        String string6 = bundle.getString("largeIcon");
                        j = bundle.getLong("fireTime", -1L);
                        long j3 = bundle.getLong("repeatInterval", -1L);
                        string3 = Build.VERSION.SDK_INT < 21 ? null : bundle.getString(NotificationCompat.EXTRA_BIG_TEXT);
                        boolean z5 = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false);
                        z = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
                        str5 = string5;
                        str6 = string6;
                        j2 = j3;
                        z2 = z5;
                        string4 = bundle.getString("data");
                        z3 = true;
                        i = 0;
                    }
                    String str7 = string;
                    String str8 = string2;
                    long j4 = j;
                    try {
                        String deserializeString4 = deserializeString(dataInputStream);
                        boolean readBoolean2 = dataInputStream.readBoolean();
                        if (readBoolean2) {
                            i2 = dataInputStream.readInt();
                            z4 = z3;
                        } else {
                            z4 = z3;
                            i2 = 0;
                        }
                        int readInt2 = dataInputStream.readInt();
                        boolean readBoolean3 = dataInputStream.readBoolean();
                        String deserializeString5 = deserializeString(dataInputStream);
                        boolean readBoolean4 = dataInputStream.readBoolean();
                        int readInt3 = dataInputStream.readInt();
                        String deserializeString6 = deserializeString(dataInputStream);
                        long readLong2 = z ? dataInputStream.readLong() : 0L;
                        Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(deserializeString4);
                        if (bundle != null) {
                            createNotificationBuilder.setExtras(bundle);
                        } else {
                            createNotificationBuilder.getExtras().putInt("id", i);
                            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "smallIcon", str5);
                            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "largeIcon", str6);
                            if (j4 != -1) {
                                createNotificationBuilder.getExtras().putLong("fireTime", j4);
                            }
                            if (j2 != -1) {
                                createNotificationBuilder.getExtras().putLong("repeatInterval", j2);
                            }
                            if (string4 != null) {
                                createNotificationBuilder.getExtras().putString("data", string4);
                            }
                            createNotificationBuilder.getExtras().putBoolean("com.unity.showInForeground", z4);
                        }
                        if (str7 != null) {
                            createNotificationBuilder.setContentTitle(str7);
                        }
                        if (str8 != null) {
                            createNotificationBuilder.setContentText(str8);
                        }
                        if (string3 != null) {
                            createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string3));
                        }
                        if (readBoolean2) {
                            UnityNotificationManager.setNotificationColor(createNotificationBuilder, i2);
                        }
                        if (readInt2 >= 0) {
                            createNotificationBuilder.setNumber(readInt2);
                        }
                        createNotificationBuilder.setAutoCancel(readBoolean3);
                        UnityNotificationManager.setNotificationUsesChronometer(createNotificationBuilder, z2);
                        if (deserializeString5 != null && deserializeString5.length() > 0) {
                            createNotificationBuilder.setGroup(deserializeString5);
                        }
                        createNotificationBuilder.setGroupSummary(readBoolean4);
                        UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, readInt3);
                        if (deserializeString6 != null && deserializeString6.length() > 0) {
                            createNotificationBuilder.setSortKey(deserializeString6);
                        }
                        if (z) {
                            createNotificationBuilder.setShowWhen(true);
                            createNotificationBuilder.setWhen(readLong2);
                        }
                        return createNotificationBuilder;
                    } catch (Exception e) {
                        e = e;
                        str4 = "UnityNotifications";
                        str3 = "Failed to deserialize notification";
                        Log.e(str4, str3, e);
                        return null;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        str2 = "UnityNotifications";
                        str = "Failed to deserialize notification";
                        Log.e(str2, str, e);
                        return null;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            str3 = "Failed to deserialize notification";
            str4 = "UnityNotifications";
        } catch (OutOfMemoryError e4) {
            e = e4;
            str = "Failed to deserialize notification";
            str2 = "UnityNotifications";
        }
    }

    private static Notification.Builder deserializedFromOldIntent(Context context, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Bundle bundle = new Bundle();
            bundle.readFromParcel(obtain);
            int i = bundle.getInt("id", -1);
            String string = bundle.getString("channelID");
            String string2 = bundle.getString("textTitle");
            String string3 = bundle.getString("textContent");
            String string4 = bundle.getString("smallIconStr");
            boolean z = bundle.getBoolean("autoCancel", false);
            boolean z2 = bundle.getBoolean("usesChronometer", false);
            long j = bundle.getLong("fireTime", -1L);
            long j2 = bundle.getLong("repeatInterval", -1L);
            try {
                String string5 = bundle.getString("largeIconStr");
                try {
                    int i2 = bundle.getInt("style", -1);
                    int i3 = bundle.getInt("color", 0);
                    int i4 = bundle.getInt("number", 0);
                    String string6 = bundle.getString("data");
                    String string7 = bundle.getString("group");
                    boolean z3 = bundle.getBoolean("groupSummary", false);
                    String string8 = bundle.getString("sortKey");
                    int i5 = bundle.getInt("groupAlertBehaviour", -1);
                    boolean z4 = bundle.getBoolean("showTimestamp", false);
                    Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(string);
                    createNotificationBuilder.getExtras().putInt("id", i);
                    createNotificationBuilder.setContentTitle(string2);
                    createNotificationBuilder.setContentText(string3);
                    UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "smallIcon", string4);
                    createNotificationBuilder.setAutoCancel(z);
                    createNotificationBuilder.setUsesChronometer(z2);
                    createNotificationBuilder.getExtras().putLong("fireTime", j);
                    createNotificationBuilder.getExtras().putLong("repeatInterval", j2);
                    UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "largeIcon", string5);
                    if (i2 == 2) {
                        createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string3));
                    }
                    if (i3 != 0) {
                        UnityNotificationManager.setNotificationColor(createNotificationBuilder, i3);
                    }
                    if (i4 >= 0) {
                        createNotificationBuilder.setNumber(i4);
                    }
                    if (string6 != null) {
                        createNotificationBuilder.getExtras().putString("data", string6);
                    }
                    if (string7 != null && string7.length() > 0) {
                        createNotificationBuilder.setGroup(string7);
                    }
                    createNotificationBuilder.setGroupSummary(z3);
                    if (string8 != null && string8.length() > 0) {
                        createNotificationBuilder.setSortKey(string8);
                    }
                    UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, i5);
                    createNotificationBuilder.setShowWhen(z4);
                    return createNotificationBuilder;
                } catch (Exception e) {
                    e = e;
                    str3 = "Failed to deserialize old style notification";
                    str4 = "UnityNotifications";
                    Log.e(str4, str3, e);
                    return null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    str = "Failed to deserialize old style notification";
                    str2 = "UnityNotifications";
                    Log.e(str2, str, e);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                str4 = "UnityNotifications";
                str3 = "Failed to deserialize old style notification";
            } catch (OutOfMemoryError e4) {
                e = e4;
                str2 = "UnityNotifications";
                str = "Failed to deserialize old style notification";
            }
        } catch (Exception e5) {
            e = e5;
            str3 = "Failed to deserialize old style notification";
            str4 = "UnityNotifications";
        } catch (OutOfMemoryError e6) {
            e = e6;
            str = "Failed to deserialize old style notification";
            str2 = "UnityNotifications";
        }
    }

    private static String deserializeString(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    private static <T extends Parcelable> T deserializeParcelable(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, readInt);
            obtain.setDataPosition(0);
            Bundle bundle = (Bundle) obtain.readParcelable(UnityNotificationUtilities.class.getClassLoader());
            obtain.recycle();
            if (bundle != null) {
                return (T) bundle.getParcelable("obj");
            }
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Class<?> getOpenAppActivity(Context context, boolean z) {
        ApplicationInfo applicationInfo;
        Class<?> cls = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle.containsKey("custom_notification_android_activity")) {
            try {
                cls = Class.forName(bundle.getString("custom_notification_android_activity"));
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null && z) {
            Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
            try {
                return Class.forName("com.unity3d.player.UnityPlayerActivity");
            } catch (ClassNotFoundException unused2) {
                Log.w("UnityNotifications", String.format("Attempting to find : %s, failed!", "com.unity3d.player.UnityPlayerActivity"));
                String format = String.format("%s.UnityPlayerActivity", context.getPackageName());
                try {
                    return Class.forName(format);
                } catch (ClassNotFoundException unused3) {
                    Log.w("UnityNotifications", String.format("Attempting to find class based on package name: %s, failed!", format));
                }
            }
        }
        return cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Notification.Builder recoverBuilder(Context context, Notification notification) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
                recoverBuilder.setExtras(notification.extras);
                return recoverBuilder;
            }
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e2);
        }
        return recoverBuilderCustom(context, notification);
    }

    private static Notification.Builder recoverBuilderCustom(Context context, Notification notification) {
        String string;
        Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(notification.extras.getString("channelID"));
        UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "smallIcon", notification.extras.getString("smallIcon"));
        String string2 = notification.extras.getString("largeIcon");
        if (string2 != null && !string2.isEmpty()) {
            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, "largeIcon", string2);
        }
        createNotificationBuilder.setContentTitle(notification.extras.getString(NotificationCompat.EXTRA_TITLE));
        createNotificationBuilder.setContentText(notification.extras.getString(NotificationCompat.EXTRA_TEXT));
        createNotificationBuilder.setAutoCancel((notification.flags & 16) != 0);
        if (notification.number >= 0) {
            createNotificationBuilder.setNumber(notification.number);
        }
        if (Build.VERSION.SDK_INT >= 21 && (string = notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT)) != null) {
            createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string));
        }
        createNotificationBuilder.setWhen(notification.when);
        String group = notification.getGroup();
        if (group != null && !group.isEmpty()) {
            createNotificationBuilder.setGroup(group);
        }
        createNotificationBuilder.setGroupSummary((notification.flags & 512) != 0);
        String sortKey = notification.getSortKey();
        if (sortKey != null && !sortKey.isEmpty()) {
            createNotificationBuilder.setSortKey(sortKey);
        }
        createNotificationBuilder.setShowWhen(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false));
        Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
        if (notificationColor != null) {
            UnityNotificationManager.setNotificationColor(createNotificationBuilder, notificationColor.intValue());
        }
        UnityNotificationManager.setNotificationUsesChronometer(createNotificationBuilder, notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
        UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
        createNotificationBuilder.getExtras().putInt("id", notification.extras.getInt("id", 0));
        createNotificationBuilder.getExtras().putLong("repeatInterval", notification.extras.getLong("repeatInterval", 0L));
        createNotificationBuilder.getExtras().putLong("fireTime", notification.extras.getLong("fireTime", 0L));
        String string3 = notification.extras.getString("data");
        if (string3 != null && !string3.isEmpty()) {
            createNotificationBuilder.getExtras().putString("data", string3);
        }
        return createNotificationBuilder;
    }
}