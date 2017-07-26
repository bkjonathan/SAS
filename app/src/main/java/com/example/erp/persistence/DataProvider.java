package com.example.erp.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.erp.ERP;

/**
 * Created by myolwin00 on 7/25/17.
 */

public class DataProvider extends ContentProvider {

    public static final int PRODUCTS = 100;
    public static final int VENDORS = 200;
    public static final int LOCATIONS = 300;

    private DBHelper mDBHelper;
    private UriMatcher sUriMatcher = buildUriMatcher();

    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        String authority = DataContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority, DataContract.PATH_PRODUCTS, PRODUCTS);
        uriMatcher.addURI(authority, DataContract.PATH_VENDORS, VENDORS);
        uriMatcher.addURI(authority, DataContract.PATH_LOCATIONS, LOCATIONS);

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
            case PRODUCTS:
                return DataContract.ProductEntry.TABLE_NAME;
            case VENDORS:
                return DataContract.VendorEntry.TABLE_NAME;
            case LOCATIONS:
                return DataContract.LocationEntry.TABLE_NAME;
            default:
                throw new UnsupportedOperationException("Unknown uri: " +uri);
        }
    }

    @Override
    public boolean onCreate() {
        mDBHelper = new DBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String tableName = getTableName(uri);
        Cursor cursor = mDBHelper.getReadableDatabase().query(
                tableName,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        if (getContext() != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
            case PRODUCTS:
                return DataContract.ProductEntry.DIR_TYPE;
            case VENDORS:
                return DataContract.VendorEntry.DIR_TYPE;
            case LOCATIONS:
                return DataContract.LocationEntry.DIR_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: "+ uri);
        }
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        Context context = getContext();
        if (context != null && insertedCount > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return insertedCount;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
