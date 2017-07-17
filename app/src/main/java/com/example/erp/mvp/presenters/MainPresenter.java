package com.example.erp.mvp.presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.data.models.BaseModel;
import com.example.erp.data.models.ProductModel;
import com.example.erp.data.models.UserModel;
import com.example.erp.events.DataEvent;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.MainView;

import org.greenrobot.eventbus.Subscribe;

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
        super.onCreate();
        String userToken = mUserModel.getUserToken();
        if (userToken.length() != 0) {
            mProductModel.loadProducts(userToken);
        } else {
            mView.navigateToLogin();
        }
    }

    @Subscribe
    public void onProductLoadedEvent(DataEvent.ProductEvent event) {
        String products = event.getmProductResponse().getData().get(0).getBrandName();
    }

    @Subscribe
    public void onProductLoadFailed(LoadFailedEvent event) {
    }
}
