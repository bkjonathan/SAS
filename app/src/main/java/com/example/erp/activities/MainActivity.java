package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.erp.persistence.DataContract;
import com.example.erp.views.holders.ProductViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.erp.utils.Constants.ID_MAIN_LOADER;

public class MainActivity extends BaseActivity
        implements MainView,
        LoaderManager.LoaderCallbacks<Cursor>,
        ProductViewHolder.ControllerProductItem {

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

        mProductAdapter = new ProductAdapter(this, this);
        mProductList.setLayoutManager(new GridLayoutManager(this, 2));
        mProductList.setAdapter(mProductAdapter);

        getSupportLoaderManager().initLoader(ID_MAIN_LOADER, null, this);
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
        mProductAdapter.setNewData(productList);
    }

    @Override
    public void displayFailedToLoad(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                this,
                DataContract.ProductEntry.CONTENT_URI,
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            List<ProductVO> productList = new ArrayList<>();
            do {
                ProductVO product =
                        ProductVO.parseFromCursor(data);
                productList.add(product);
            } while (data.moveToNext());

            mPresenter.onProductLoaded(productList);
        } else {
            mPresenter.onLoadProductFromNetwork();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onProductClick(ProductVO productVO) {
        startActivity(ProductDetailActivity.newIntent(this, productVO.getItemCode()));
    }
}
