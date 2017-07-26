package com.example.erp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.erp.persistence.DataContract.*;

/**
 * Created by myolwin00 on 7/25/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    public static final String DB_NAME = "erp_data.db";

    private static final String CREATE_PRODUCT_TABLE =
            "CREATE TABLE " + DataContract.ProductEntry.TABLE_NAME + " (" +
                    ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ProductEntry.COLUMN_BRAND_NAME + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_CAT_MYANMAR + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_DRC + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_DRC_EXPIRE_DATE + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_DRC_REG_NO + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_GENERIC_NAME + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_ITEM_CODE + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_HSCODE + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_ID + " REAL NOT NULL, " +
                    ProductEntry.COLUMN_PACK_SIZE + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_VENDOR_TEAM + " TEXT NOT NULL, " +
                    ProductEntry.COLUMN_VP_CODE + " TEXT NOT NULL" +
                    " );";

    private static final String CREATE_VENDOR_TABLE =
            "CREATE TABLE " + DataContract.VendorEntry.TABLE_NAME + " (" +
                    VendorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    VendorEntry.COLUMN_ADDRESS + " TEXT NOT NULL, " +
                    VendorEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                    VendorEntry.COLUMN_FAX + " TEXT NOT NULL, " +
                    VendorEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                    VendorEntry.COLUMN_PHONE + " TEXT NOT NULL, " +
                    VendorEntry.COLUMN_WEBSITE + " TEXT NOT NULL" +
                    " );";

    private static final String CREATE_LOCATION_TABLE =
            "CREATE TABLE " + DataContract.LocationEntry.TABLE_NAME + " (" +
                    LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LocationEntry.COLUMN_NAME + " TEXT NOT NULL" +
                    " );";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PRODUCT_TABLE);
        sqLiteDatabase.execSQL(CREATE_VENDOR_TABLE);
        sqLiteDatabase.execSQL(CREATE_LOCATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DataContract.ProductEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DataContract.VendorEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DataContract.LocationEntry.TABLE_NAME);
    }
}
