package com.example.erp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.base.BaseRecyclerAdapter;
import com.example.erp.data.vos.VendorVO;
import com.example.erp.views.holders.VendorViewHolder;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class VendorAdapter extends BaseRecyclerAdapter<VendorViewHolder, VendorVO> {

    public VendorAdapter(Context context) {
        super(context);
    }

    @Override
    public VendorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_vendor, parent, false);
        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VendorViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
