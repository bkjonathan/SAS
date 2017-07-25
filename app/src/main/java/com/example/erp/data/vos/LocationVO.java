package com.example.erp.data.vos;

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
}
