package com.example.erp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.base.BaseRecyclerAdapter;
import com.example.erp.views.holders.UserRoleViewHolder;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class UserRoleAdapter extends BaseRecyclerAdapter<UserRoleViewHolder, String> {

    private UserRoleViewHolder.ControllerUserRoleItem mController;

    public UserRoleAdapter(Context context, UserRoleViewHolder.ControllerUserRoleItem controllerUserRoleItem) {
        super(context);
        mController = controllerUserRoleItem;
    }

    @Override
    public UserRoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_user_role, parent, false);
        return new UserRoleViewHolder(view, mController);
    }

    @Override
    public void onBindViewHolder(UserRoleViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
