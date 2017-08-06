package com.example.erp.mvp.views;

import com.example.erp.data.vos.ProductVO;
import com.example.erp.mvp.views.base.BaseView;

/**
 * Created by myolwin00 on 7/26/17.
 */

public interface ProductDetailView extends BaseView {
    void displayProductData(ProductVO product);
}
