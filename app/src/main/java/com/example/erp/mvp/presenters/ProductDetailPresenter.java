package com.example.erp.mvp.presenters;

import com.example.erp.data.vos.ProductVO;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.ProductDetailView;

/**
 * Created by myolwin00 on 7/26/17.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailView> {

    public void productDetailLoaded(ProductVO product) {
        mView.displayProductData(product);
    }
}
