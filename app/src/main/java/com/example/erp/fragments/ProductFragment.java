package com.example.erp.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.ProductAdapter;
import com.example.erp.data.vos.ProductVO;
import com.example.erp.mvp.presenters.ProductPresenter;
import com.example.erp.mvp.views.MainView;
import com.example.erp.persistence.DataContract;
import com.example.erp.views.holders.ProductViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.erp.utils.Constants.ID_MAIN_LOADER;


public class ProductFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>, MainView{

    @BindView(R.id.rv_product_list)
    RecyclerView rvProductList;

    private ProductAdapter mProductAdapter;
    public ProductPresenter mPresenter;
    private ProductViewHolder.ControllerProductItem controllerProductItem;

    public static ProductFragment newInstance() {
        return new ProductFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ProductPresenter(getContext());
        mPresenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerProductItem = (ProductViewHolder.ControllerProductItem) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);

        mProductAdapter = new ProductAdapter(getContext(), controllerProductItem);
        rvProductList.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvProductList.setAdapter(mProductAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(ID_MAIN_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                getContext(),
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
    public void displayProductList(List<ProductVO> productList) {
        mProductAdapter.setNewData(productList);
    }

    @Override
    public void displayFailedToLoad(String message) {
    }
}
