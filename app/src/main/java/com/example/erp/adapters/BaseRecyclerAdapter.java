package com.example.erp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.erp.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myolwin00 on 7/11/17.
 */

public abstract class BaseRecyclerAdapter<V extends BaseViewHolder, D>
        extends RecyclerView.Adapter<V>{

    protected LayoutInflater mLayoutInflater;
    protected List<D> mData;

    public BaseRecyclerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    public void setData(List<D> newData) {
        mData = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
