
package com.example.erp.data.vos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.erp.persistence.DataContract.VendorEntry;
import com.google.gson.annotations.SerializedName;

public class VendorVO {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("fax")
    private String mFax;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("website")
    private String mWebsite;

    public String getAddress() {
        return mAddress;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getFax() {
        return mFax;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(VendorEntry.COLUMN_ADDRESS, mAddress);
        cv.put(VendorEntry.COLUMN_EMAIL, mEmail);
        cv.put(VendorEntry.COLUMN_FAX, mFax);
        cv.put(VendorEntry.COLUMN_NAME, mName);
        cv.put(VendorEntry.COLUMN_PHONE, mPhone);
        cv.put(VendorEntry.COLUMN_WEBSITE, mWebsite);
        return cv;
    }

    public static VendorVO parseFromCursor(Cursor data) {
        VendorVO vendor = new VendorVO();
        vendor.mAddress = data.getString(data.getColumnIndex(VendorEntry.COLUMN_ADDRESS));
        vendor.mEmail = data.getString(data.getColumnIndex(VendorEntry.COLUMN_EMAIL));
        vendor.mFax = data.getString(data.getColumnIndex(VendorEntry.COLUMN_FAX));
        vendor.mName = data.getString(data.getColumnIndex(VendorEntry.COLUMN_NAME));
        vendor.mPhone = data.getString(data.getColumnIndex(VendorEntry.COLUMN_PHONE));
        vendor.mWebsite = data.getString(data.getColumnIndex(VendorEntry.COLUMN_WEBSITE));
        return vendor;
    }
}
