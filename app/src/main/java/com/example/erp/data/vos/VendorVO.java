
package com.example.erp.data.vos;

import javax.annotation.Generated;
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
}
