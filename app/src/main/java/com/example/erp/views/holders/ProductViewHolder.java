package com.example.erp.views.holders;

import android.view.View;
import android.widget.TextView;

import com.example.erp.R;
import com.example.erp.data.vos.ProductVO;

import butterknife.BindView;

/**
 * Created by myolwin00 on 7/17/17.
 */

public class ProductViewHolder extends BaseViewHolder<ProductVO> {

    @BindView(R.id.tv_product_id) TextView tvId;
    @BindView(R.id.tv_item_code) TextView tvItemCode;
    @BindView(R.id.tv_vp_code) TextView tvVpCode;
    @BindView(R.id.tv_brand_name) TextView tvBrandName;
    @BindView(R.id.tv_generic_name) TextView tvGenericName;
    @BindView(R.id.tv_drc_reg_no) TextView tvDrcRegNo;
    @BindView(R.id.tv_drc_expiry_date) TextView tvDrcExpiryDate;
    @BindView(R.id.tv_drc) TextView tvDrc;

    public ProductViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ProductVO data) {
        tvId.setText(Long.toString(data.getId()));
        tvItemCode.setText(data.getItemCode());
        tvVpCode.setText(data.getVpCode());
        tvBrandName.setText(data.getBrandName());
        tvGenericName.setText(data.getGenericName());
        tvDrcRegNo.setText(data.getDrcRegNo());
        tvDrcExpiryDate.setText(data.getDrcExpiryDate());
        tvDrc.setText(data.getDrc());
    }

}
