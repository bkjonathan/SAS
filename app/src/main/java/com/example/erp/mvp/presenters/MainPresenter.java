package com.example.erp.mvp.presenters;

import android.content.Context;

import com.example.erp.ERP;
import com.example.erp.data.models.ProductModel;
import com.example.erp.data.models.UserModel;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.events.DataEvent;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.MainView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by myolwin00 on 7/17/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    @Inject public ProductModel mProductModel;
    @Inject public UserModel mUserModel;

    public MainPresenter(Context context) {

        ((ERP) context.getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public void onCreate() {
        String userToken = mUserModel.getUserToken();
        mProductModel.loadProducts(userToken);
    }

    @Subscribe
    public void onProductLoadedEvent(DataEvent.ProductEvent event) {
        List<ProductVO> productList = event.getProductResponse().getProductsList();
        mView.displayProductList(productList);
    }

    @Subscribe
    public void onProductLoadFailed(LoadFailedEvent event) {
        mView.displayFailedToLoad(event.getErrorMsg());
    }
}
