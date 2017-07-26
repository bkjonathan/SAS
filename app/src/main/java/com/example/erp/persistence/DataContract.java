package com.example.erp.persistence;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.erp.ERP;

/**
 * Created by myolwin00 on 7/25/17.
 */

public class DataContract {

    public static final String CONTENT_AUTHORITY = ERP.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PRODUCTS = "products";
    public static final String PATH_VENDORS = "vendors";
    public static final String PATH_LOCATIONS = "locations";

    public static final class ProductEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCTS).build();

        public static final String TABLE_NAME = PATH_PRODUCTS;

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        public static final String COLUMN_BRAND_NAME        = "brand_name";
        public static final String COLUMN_CAT_MYANMAR       = "cat_myanmar";
        public static final String COLUMN_DRC               = "drc";
        public static final String COLUMN_DRC_EXPIRE_DATE   = "drc_expiry_date";
        public static final String COLUMN_DRC_REG_NO        = "drc_reg_no";
        public static final String COLUMN_GENERIC_NAME      = "generic_name";
        public static final String COLUMN_ITEM_CODE         = "item_code";
        public static final String COLUMN_HSCODE            = "hscode";
        public static final String COLUMN_ID                = "id";
        public static final String COLUMN_PACK_SIZE         = "pack_size";
        public static final String COLUMN_VENDOR_TEAM       = "vendor_team";
        public static final String COLUMN_VP_CODE           = "vp_code";
    }

    public static final class VendorEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_VENDORS).build();

        public static final String TABLE_NAME = PATH_VENDORS;

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VENDORS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VENDORS;

        public static final String COLUMN_ADDRESS   = "address";
        public static final String COLUMN_EMAIL     = "email";
        public static final String COLUMN_FAX       = "fax";
        public static final String COLUMN_NAME      = "name";
        public static final String COLUMN_PHONE     = "phone";
        public static final String COLUMN_WEBSITE   = "website";
    }

    public static final class LocationEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATIONS).build();

        public static final String TABLE_NAME = PATH_LOCATIONS;

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS;

        public static final String COLUMN_NAME = "name";
    }

}
