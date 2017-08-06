package com.example.erp.adapters.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

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

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<D> newData) {
        mData = newData;
        notifyDataSetChanged();
    }

    public void appendNewData(List<D> newData) {
        mData.addAll(newData);
        notifyDataSetChanged();
    }

    public D getItemAt(int position) {
        if (position < mData.size() - 1)
            return mData.get(position);

        return null;
    }

    public List<D> getItems() {
        if (mData == null)
            return new ArrayList<>();

        return mData;
    }

    public void removeData(D data) {
        mData.remove(data);
        notifyDataSetChanged();
    }

    public void addNewData(D data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData = new ArrayList<>();
        notifyDataSetChanged();
    }
}
