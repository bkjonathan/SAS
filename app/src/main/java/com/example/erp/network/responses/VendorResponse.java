
package com.example.erp.network.responses;

import java.util.List;

import com.example.erp.data.vos.VendorVO;
import com.google.gson.annotations.SerializedName;

public class VendorResponse {

    @SerializedName("data")
    private List<VendorVO> mVendors;

    public List<VendorVO> getVendorList() {
        return mVendors;
    }

    public void setVendorList(List<VendorVO> mVendors) {
        this.mVendors = mVendors;
    }
}
