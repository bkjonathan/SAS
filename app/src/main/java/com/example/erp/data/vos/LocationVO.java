package com.example.erp.data.vos;

import android.content.ContentValues;

import com.example.erp.persistence.DataContract.LocationEntry;
import com.google.gson.annotations.SerializedName;

/**
 * Created by myolwin00 on 7/25/17.
 */

public class LocationVO {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(LocationEntry.COLUMN_NAME, mName);
        return cv;
    }
}
