package com.example.erp.views.holders;

import android.view.View;
import android.widget.TextView;

import com.example.erp.R;
import com.example.erp.data.vos.VendorVO;

import butterknife.BindView;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class VendorViewHolder extends BaseViewHolder<VendorVO> {

    @BindView(R.id.tv_vendor_name)
    TextView tvName;
    @BindView(R.id.tv_vendor_address)
    TextView tvAddress;
    @BindView(R.id.tv_vendor_email)
    TextView tvEmail;
    @BindView(R.id.tv_vendor_fax)
    TextView tvFax;
    @BindView(R.id.tv_vendor_phone)
    TextView tvPhone;
    @BindView(R.id.tv_vendor_website)
    TextView tvWebsite;

    public VendorViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(VendorVO data) {
        tvName.setText(data.getName());
        tvAddress.setText(data.getAddress());
        tvEmail.setText(data.getEmail());
        tvFax.setText(data.getFax());
        tvPhone.setText(data.getPhone());
        tvWebsite.setText(data.getWebsite());
    }
}
