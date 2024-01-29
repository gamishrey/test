package com.soomla.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class KeyValDatabase {
    private static final String DATABASE_NAME = "store.kv.db";
    private static final String KEYVAL_TABLE_NAME = "kv_store";
    private static final String TAG = "KeyValDatabase";
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mStoreDB;
    public static final String KEYVAL_COLUMN_KEY = "key";
    public static final String KEYVAL_COLUMN_VAL = "val";
    private static final String[] KEYVAL_COLUMNS = {KEYVAL_COLUMN_KEY, KEYVAL_COLUMN_VAL};

    public KeyValDatabase(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        this.mDatabaseHelper = databaseHelper;
        this.mStoreDB = databaseHelper.getWritableDatabase();
    }

    public synchronized void close() {
        this.mDatabaseHelper.close();
    }

    public void purgeDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }

    public void purgeDatabaseEntries(Context context) {
        this.mStoreDB.delete(KEYVAL_TABLE_NAME, null, null);
    }

    public synchronized void setKeyVal(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEYVAL_COLUMN_VAL, str2);
        SQLiteDatabase sQLiteDatabase = this.mStoreDB;
        if (sQLiteDatabase.update(KEYVAL_TABLE_NAME, contentValues, "key='" + str + "'", null) == 0) {
            contentValues.put(KEYVAL_COLUMN_KEY, str);
            this.mStoreDB.replace(KEYVAL_TABLE_NAME, null, contentValues);
        }
    }

    public synchronized String getKeyVal(String str) {
        SQLiteDatabase sQLiteDatabase = this.mStoreDB;
        String[] strArr = KEYVAL_COLUMNS;
        Cursor query = sQLiteDatabase.query(KEYVAL_TABLE_NAME, strArr, "key='" + str + "'", null, null, null, null);
        if (query == null || !query.moveToNext()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        String string = query.getString(query.getColumnIndexOrThrow(KEYVAL_COLUMN_VAL));
        query.close();
        return string;
    }

    public synchronized void deleteKeyVal(String str) {
        this.mStoreDB.delete(KEYVAL_TABLE_NAME, "key=?", new String[]{str});
    }

    public synchronized HashMap<String, String> getQueryVals(String str) {
        HashMap<String, String> hashMap;
        String replace = str.replace('*', '%');
        SQLiteDatabase sQLiteDatabase = this.mStoreDB;
        String[] strArr = KEYVAL_COLUMNS;
        Cursor query = sQLiteDatabase.query(KEYVAL_TABLE_NAME, strArr, "key LIKE '" + replace + "'", null, null, null, null);
        hashMap = new HashMap<>();
        while (query != null && query.moveToNext()) {
            try {
                hashMap.put(query.getString(query.getColumnIndexOrThrow(KEYVAL_COLUMN_KEY)), query.getString(query.getColumnIndexOrThrow(KEYVAL_COLUMN_VAL)));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (query != null) {
            query.close();
        }
        return hashMap;
    }

    public synchronized String getQueryOne(String str) {
        String replace = str.replace('*', '%');
        SQLiteDatabase sQLiteDatabase = this.mStoreDB;
        String[] strArr = KEYVAL_COLUMNS;
        Cursor query = sQLiteDatabase.query(KEYVAL_TABLE_NAME, strArr, "key LIKE '" + replace + "'", null, null, null, null, "1");
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndexOrThrow(KEYVAL_COLUMN_VAL));
        query.close();
        return string;
    }

    public synchronized int getQueryCount(String str) {
        String replace = str.replace('*', '%');
        SQLiteDatabase sQLiteDatabase = this.mStoreDB;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(val) from kv_store WHERE key LIKE '" + replace + "'", null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            return 0;
        }
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public synchronized List<String> getAllKeys() {
        ArrayList arrayList;
        Cursor query = this.mStoreDB.query(KEYVAL_TABLE_NAME, new String[]{KEYVAL_COLUMN_KEY}, null, null, null, null, null);
        arrayList = new ArrayList();
        while (query != null && query.moveToNext()) {
            try {
                arrayList.add(query.getString(query.getColumnIndexOrThrow(KEYVAL_COLUMN_KEY)));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    /* loaded from: classes.dex */
    private class DatabaseHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public DatabaseHelper(Context context) {
            super(context, KeyValDatabase.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (!sQLiteDatabase.isReadOnly()) {
                sQLiteDatabase.execSQL("PRAGMA foreign_key=ON");
            }
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS kv_store(key TEXT PRIMARY KEY, val TEXT)");
        }
    }
}