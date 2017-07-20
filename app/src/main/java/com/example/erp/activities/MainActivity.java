package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.R;
import com.example.erp.adapters.ProductAdapter;
import com.example.erp.data.models.ProductModel;
import com.example.erp.data.models.UserModel;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.data.vos.UserVO;
import com.example.erp.events.DataEvent;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.mvp.presenters.MainPresenter;
import com.example.erp.mvp.views.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_product_list)
    RecyclerView mProductList;

    private ProductAdapter mProductAdapter;

    @Inject
    public MainPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        ((ERP) getApplicationContext()).getAppComponent().inject(this);
        mPresenter.setView(this);
        mPresenter.onCreate();

        mProductAdapter = new ProductAdapter(this);
        mProductList.setLayoutManager(new LinearLayoutManager(this));
        mProductList.setAdapter(mProductAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void displayProductList(List<ProductVO> productList) {
        mProductAdapter.setData(productList);
    }

    @Override
    public void displayFailedToLoad(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
