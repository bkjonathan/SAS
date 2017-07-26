package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.R;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.mvp.presenters.ProductDetailPresenter;
import com.example.erp.mvp.views.ProductDetailView;
import com.example.erp.persistence.DataContract;
import com.example.erp.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.erp.utils.Constants.ID_PRODUCT_DETAIL_LOADER;

public class ProductDetailActivity extends BaseActivity
    implements LoaderManager.LoaderCallbacks<Cursor>,
        ProductDetailView {

    private String mItemCode;

    @BindView(R.id.tv_item_code) TextView tvItemCode;
    @BindView(R.id.tv_vp_code) TextView tvVpCode;
    @BindView(R.id.tv_brand_name) TextView tvBrandName;
    @BindView(R.id.tv_generic_name) TextView tvGenericName;
    @BindView(R.id.tv_pack_size) TextView tvPackSize;
    @BindView(R.id.tv_hscode) TextView tvHScode;
    @BindView(R.id.tv_cat_myanmar) TextView tvCatMyanmar;
    @BindView(R.id.tv_vendor_team) TextView tvVendorTeam;
    @BindView(R.id.tv_drc_reg_no) TextView tvDrcRegNo;
    @BindView(R.id.tv_drc_expiry_date) TextView tvDrcExpiryDate;

    @Inject public ProductDetailPresenter mPresenter;

    public static Intent newIntent(Context context, String itemCode) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("item_code", itemCode);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this, this);

        mItemCode = getIntent().getStringExtra("item_code");

        ((ERP) getApplicationContext()).getAppComponent().inject(this);
        mPresenter.setView(this);

        getSupportLoaderManager().initLoader(ID_PRODUCT_DETAIL_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                this,
                DataContract.ProductEntry.CONTENT_URI,
                null,
                DataContract.ProductEntry.COLUMN_ITEM_CODE + " =? ",
                new String[]{mItemCode},
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            ProductVO product = ProductVO.parseFromCursor(data);

            mPresenter.productDetailLoaded(product);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void displayProductData(ProductVO data) {
        tvItemCode.setText(data.getItemCode());
        tvVpCode.setText(data.getVpCode());
        tvBrandName.setText(data.getBrandName());
        tvGenericName.setText(data.getGenericName());
        tvPackSize.setText(data.getPackSize());
        tvHScode.setText(data.getHscode());
        tvCatMyanmar.setText(data.getCatMyanmar());
        tvVendorTeam.setText(data.getVendorTeam());
        tvDrcRegNo.setText(data.getDrcRegNo());
        tvDrcExpiryDate.setText(data.getDrcExpiryDate());
    }
}
