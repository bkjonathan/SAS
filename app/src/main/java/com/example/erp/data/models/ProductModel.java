package com.example.erp.data.models;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.events.DataEvent;
import com.example.erp.persistence.DataContract;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myolwin00 on 7/16/17.
 */

public class ProductModel extends BaseModel {

    public ProductModel(Context context) {
        super(context);
    }

    public void loadProducts(Context context, String token) {
        mDataAgent.loadProducts(context, token);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onProductsLoaded(DataEvent.ProductEvent event) {

        List<ProductVO> productList = event.getProductList();
        ContentValues[] productCVs = new ContentValues[productList.size()];

        int index = 0;
        for (ProductVO product : productList) {
            productCVs[index++] = product.parseToContentValues();
        }

        Context context = event.getContext();

        int productInsertedCount = context.getContentResolver()
                .bulkInsert(DataContract.ProductEntry.CONTENT_URI, productCVs);
        Log.d(ERP.TAG, "productInsertedCount : " + productInsertedCount);
    }
}
