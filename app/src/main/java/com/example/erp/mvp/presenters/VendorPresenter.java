package com.example.erp.mvp.presenters;

import android.content.Context;

import com.example.erp.ERP;
import com.example.erp.data.models.UserModel;
import com.example.erp.data.models.VendorModel;
import com.example.erp.data.vos.VendorVO;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.VendorView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class VendorPresenter extends BasePresenter<VendorView> {

    @Inject
    public VendorModel mVendorModel;
    @Inject
    public UserModel mUserModel;

    private Context mContext;

    public VendorPresenter(Context context) {
        ((ERP) context.getApplicationContext()).getAppComponent().inject(this);
        mContext = context;
    }

    public void onLoadVendorFromNetwork() {
        String userToken = mUserModel.getUserToken();
        mVendorModel.loadVendors(mContext, userToken);
    }

    public void onVendorLoaded(List<VendorVO> vendorList) {
        mView.displayVendorList(vendorList);
    }
}
