package com.example.erp.data.models;

import android.content.Context;

/**
 * Created by myolwin00 on 7/16/17.
 */

public class ProductModel extends BaseModel {

    public ProductModel(Context context) {
        super(context);
    }

    public void loadProducts(String token) {
        mDataAgent.loadProducts(token);
    }
}
