package com.secondfury.galleryscreenshot;

import android.content.ContentValues;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import java.io.File;

/* loaded from: classes.dex */
public class MainActivity extends UnityPlayerActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static int addImageToGallery(String str) {
        File file = new File(str);
        if (file.exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", "image/png");
            contentValues.put("_data", file.getAbsolutePath());
            UnityPlayer.currentActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            Log.w("Gallery Screenshot", "Content values written for file " + file.getAbsolutePath());
            return 1;
        }
        return 0;
    }
}