package com.example.erp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.base.BaseRecyclerAdapter;
import com.example.erp.data.models.MainModel;
import com.example.erp.views.holders.MainViewHolder;

/**
 * Created by zwe on 8/6/17.
 */

public class MainAdapter extends BaseRecyclerAdapter<MainViewHolder, MainModel> {

    private MainViewHolder.ControllerMainItem mController;

    public MainAdapter(Context context, MainViewHolder.ControllerMainItem controllerMainItem) {
        super(context);
        mController = controllerMainItem;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_main,parent,false);
        return new MainViewHolder(view,mController);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
