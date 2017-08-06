package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.erp.R;
import com.example.erp.activities.base.BaseActivity;
import com.example.erp.adapters.MainAdapter;
import com.example.erp.data.models.MainModel;
import com.example.erp.views.holders.MainViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zwe on 8/6/17.
 */

public class MainActivity extends BaseActivity{

    @BindView(R.id.rv_main)
    RecyclerView rvMainList;

    String[] title = {"Permission",
            "Roles",
            "UserRole",
            "Category",
            "Category Therapeutic",
            "Carrier",
            "Hscode",
            "Pack",
            "Location",
            "Vendor",
            "Vendor Team",
            "Vendor Terms",
            "Vendor Bank Detail",
            "Company Profile",
            "Product",
            "Purchase Order",
            "Inventory",
            "Custom",
            "Token",
            "Exchange Amount"};
    private MainAdapter mMainAdapter;
    private List<MainModel> mainModelList;
    private MainViewHolder.ControllerMainItem controllerMainItem;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);

        mMainAdapter = new MainAdapter(this, controllerMainItem);
        mainModelList = new ArrayList<>();
        rvMainList.setLayoutManager(new GridLayoutManager(this,3));
        rvMainList.setAdapter(mMainAdapter);
        setData();


    }

    private void setData() {
        MainModel model;

        for (int i=0;i<title.length;i++){
            model = new MainModel(R.drawable.permission,title[i]);
            mainModelList.add(model);
        }

        //mainModelList.notifyAll();
        mMainAdapter.setNewData(mainModelList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_notification){
            startActivity(new Intent(MainActivity.this,CompanyProfile.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
