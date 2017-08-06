package com.example.erp.data.models;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.data.vos.VendorVO;
import com.example.erp.events.DataEvent;
import com.example.erp.persistence.DataContract;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by myolwin00 on 7/26/17.
 */

public class VendorModel extends BaseModel {

    public VendorModel(Context context) {
        super(context);
    }

    public void loadVendors(Context context, String token) {
        mDataAgent.loadVendors(context, token);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onVendorsLoaded(DataEvent.VendorEvent event) {

        List<VendorVO> vendorList = event.getVendorList();
        ContentValues[] locationCVs = new ContentValues[vendorList.size()];

        int index = 0;
        for (VendorVO vendor : vendorList) {
            locationCVs[index++] = vendor.parseToContentValues();
        }

        Context context = event.getContext();

        int vendorInsertedCount = context.getContentResolver()
                .bulkInsert(DataContract.VendorEntry.CONTENT_URI, locationCVs);
        Log.d(ERP.TAG, "vendorInsertedCount : " + vendorInsertedCount);
    }
}
