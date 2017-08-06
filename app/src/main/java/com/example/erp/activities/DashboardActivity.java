package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.erp.R;
import com.example.erp.adapters.DashboardPagerAdapter;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.fragments.ProductFragment;
import com.example.erp.fragments.UserRoleFragment;
import com.example.erp.fragments.VendorFragment;
import com.example.erp.views.holders.ProductViewHolder;
import com.example.erp.views.holders.UserRoleViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity
        implements UserRoleViewHolder.ControllerUserRoleItem, ProductViewHolder.ControllerProductItem{

    @BindView(R.id.tl_dashboard) TabLayout tlDashboard;
    @BindView(R.id.pager_dashboard) ViewPager pagerDashboard;
    @BindView(R.id.toolbar) Toolbar toolbar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        DashboardPagerAdapter mPagerAdapter = new DashboardPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addTab(UserRoleFragment.newInstance(), "Permissions");
        mPagerAdapter.addTab(ProductFragment.newInstance(), "Products");
        mPagerAdapter.addTab(VendorFragment.newInstance(), "Vendors");

        pagerDashboard.setAdapter(mPagerAdapter);
        pagerDashboard.setOffscreenPageLimit(mPagerAdapter.getCount());
        tlDashboard.setupWithViewPager(pagerDashboard);
    }

    @Override
    public void onUserRoleClicked(String userRole) {
        Toast.makeText(this, "clicked: " + userRole, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProductClicked(ProductVO productVO) {
        Toast.makeText(this, "clicked: " + productVO.getItemCode(), Toast.LENGTH_SHORT).show();
    }
}
