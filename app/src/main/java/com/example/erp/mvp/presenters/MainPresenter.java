package com.example.erp.mvp.presenters;

import android.content.Context;

import com.example.erp.ERP;
import com.example.erp.data.models.LocationModel;
import com.example.erp.data.models.ProductModel;
import com.example.erp.data.models.UserModel;
import com.example.erp.data.models.VendorModel;
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

    private Context mContext;

    public MainPresenter(Context context) {

        mContext = context;
        ((ERP) context.getApplicationContext()).getAppComponent().inject(this);
    }

    public void onLoadProductFromNetwork() {
        String userToken = mUserModel.getUserToken();
        mProductModel.loadProducts(mContext, userToken);
    }

    @Subscribe
    public void onProductLoadFailed(LoadFailedEvent event) {
        mView.displayFailedToLoad(event.getErrorMsg());
    }

    public void onProductLoaded(List<ProductVO> productList) {
        mView.displayProductList(productList);
    }
}
