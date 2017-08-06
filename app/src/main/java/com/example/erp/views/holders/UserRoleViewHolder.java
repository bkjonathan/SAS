package com.example.erp.views.holders;

import android.view.View;
import android.widget.TextView;

import com.example.erp.R;

import butterknife.BindView;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class UserRoleViewHolder extends BaseViewHolder<String> {

    @BindView(R.id.tvUserRole)
    TextView tvUserRole;

    private String mUserRole;
    private ControllerUserRoleItem mController;

    public UserRoleViewHolder(View itemView, ControllerUserRoleItem controllerUserRoleItem) {
        super(itemView);
        mController = controllerUserRoleItem;
    }

    @Override
    public void bind(String data) {
        mUserRole = data;
        tvUserRole.setText(data);
    }

    @Override
    public void onClick(View view) {
        mController.onUserRoleClicked(mUserRole);
    }

    public interface ControllerUserRoleItem {
        void onUserRoleClicked(String userRole);
    }
}
