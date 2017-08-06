package com.example.erp.events;

import android.content.Context;

import com.example.erp.data.vos.LocationVO;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.data.vos.VendorVO;
import com.example.erp.network.responses.ProductResponse;

import java.util.List;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class DataEvent {

    public static class ProductEvent {
        private Context mContext;
        private List<ProductVO> mProductList;

        public ProductEvent(Context context, List<ProductVO> productList) {
            this.mContext = context;
            this.mProductList = productList;
        }

        public ProductEvent(Context context) {
            this.mContext = context;
        }

        public Context getContext() {
            return mContext;
        }

        public List<ProductVO> getProductList() {
            return mProductList;
        }
    }

    public static class VendorEvent {
        private Context mContext;
        private List<VendorVO> mVendorList;

        public VendorEvent(Context mContext, List<VendorVO> mVendorList) {
            this.mContext = mContext;
            this.mVendorList = mVendorList;
        }

        public Context getContext() {
            return mContext;
        }

        public List<VendorVO> getVendorList() {
            return mVendorList;
        }
    }

    public static class LocationEvent {
        private Context mContext;
        private List<LocationVO> mLocationList;

        public LocationEvent(Context mContext, List<LocationVO> mLocationList) {
            this.mContext = mContext;
            this.mLocationList = mLocationList;
        }

        public Context getContext() {
            return mContext;
        }

        public List<LocationVO> getLocationList() {
            return mLocationList;
        }
    }
}
