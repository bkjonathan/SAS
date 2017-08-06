package com.example.erp.mvp.views;

import com.example.erp.data.vos.VendorVO;
import com.example.erp.mvp.views.base.BaseView;

import java.util.List;

/**
 * Created by myolwin00 on 7/31/17.
 */

public interface VendorView extends BaseView {
    void displayVendorList(List<VendorVO> vendorList);
}
