
package com.example.erp.network.responses;

import java.util.List;

import com.example.erp.data.vos.DatumVO;
import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("data")
    private List<DatumVO> mData;

    public List<DatumVO> getData() {
        return mData;
    }

    public void setData(List<DatumVO> data) {
        mData = data;
    }

}
