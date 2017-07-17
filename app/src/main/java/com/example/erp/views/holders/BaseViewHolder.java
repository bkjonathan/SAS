package com.example.erp.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by myolwin00 on 7/11/17.
 */

public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void bind(D data);


    @Override
    public void onClick(View view) {
    }
}
