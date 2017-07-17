
package com.example.erp.network.responses;

import java.util.List;

import com.example.erp.data.vos.ProductVO;
import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("data")
    private List<ProductVO> mData;

    public List<ProductVO> getData() {
        return mData;
    }

    public void setData(List<ProductVO> data) {
        mData = data;
    }

}
