package com.example.erp.mvp.views;

import com.example.erp.data.vos.ProductVO;
import com.example.erp.mvp.views.base.BaseView;

import java.util.List;

/**
 * Created by myolwin00 on 7/17/17.
 */

public interface MainView extends BaseView {
    void displayProductList(List<ProductVO> productList);
    void displayFailedToLoad(String message);
}
