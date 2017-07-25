
package com.example.erp.network.responses;

import java.util.List;

import com.example.erp.data.vos.ProductVO;
import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("data")
    private List<ProductVO> mProducts;

    public List<ProductVO> getProductsList() {
        return mProducts;
    }

    public void setProductList(List<ProductVO> mProducts) {
        this.mProducts = mProducts;
    }
}
