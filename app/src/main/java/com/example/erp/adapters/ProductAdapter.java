package com.example.erp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.views.holders.ProductViewHolder;

/**
 * Created by myolwin00 on 7/17/17.
 */

public class ProductAdapter extends BaseRecyclerAdapter<ProductViewHolder, ProductVO> {

    public ProductAdapter(Context context) {
        super(context);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
