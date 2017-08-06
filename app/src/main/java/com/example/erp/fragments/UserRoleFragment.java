package com.example.erp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.UserRoleAdapter;
import com.example.erp.views.holders.UserRoleViewHolder;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class UserRoleFragment extends Fragment {

    @BindView(R.id.rv_user_roles)
    RecyclerView rvUserRoles;

    private Unbinder unbinder;
    private UserRoleViewHolder.ControllerUserRoleItem mController;

    public UserRoleFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mController = (UserRoleViewHolder.ControllerUserRoleItem) context;
    }

    public static UserRoleFragment newInstance() {
        UserRoleFragment fragment = new UserRoleFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_role, container, false);
        unbinder = ButterKnife.bind(this, view);

        UserRoleAdapter userRoleAdapter = new UserRoleAdapter(getContext(), mController);
        String[] userRoles = getResources().getStringArray(R.array.user_roles);
        userRoleAdapter.setNewData(Arrays.asList(userRoles));
        rvUserRoles.setLayoutManager(new LinearLayoutManager(getContext()));
        rvUserRoles.setAdapter(userRoleAdapter);

        return view;
    }
}
