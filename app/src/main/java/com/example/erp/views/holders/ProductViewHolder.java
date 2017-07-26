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


    @BindView(R.id.tv_item_code) TextView tvItemCode;

   private ControllerProductItem mController;
    private ProductVO mProduct;

    public ProductViewHolder(View itemView, ControllerProductItem controller) {
        super(itemView);
        mController = controller;
    }

    @Override
    public void bind(ProductVO data) {

        mProduct = data;

        tvItemCode.setText(data.getItemCode());
    }

    @Override
    public void onClick(View view) {
        mController.onProductClick(mProduct);
    }

    public interface ControllerProductItem {
        void onProductClick(ProductVO productVO);
    }
}
