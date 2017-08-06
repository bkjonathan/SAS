package com.example.erp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.erp.R;
import com.example.erp.adapters.VendorAdapter;
import com.example.erp.data.vos.VendorVO;
import com.example.erp.mvp.presenters.VendorPresenter;
import com.example.erp.mvp.views.VendorView;
import com.example.erp.persistence.DataContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by myolwin00 on 7/31/17.
 */

public class VendorFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>, VendorView {

    @BindView(R.id.rv_vendor_list)
    RecyclerView rvVendorList;

    private VendorAdapter mVendorAdapter;
    public VendorPresenter mPresenter;

    public static VendorFragment newInstance() {
        return new VendorFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new VendorPresenter(getContext());
        mPresenter.setView(this);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendor, container, false);
        ButterKnife.bind(this, view);

        mVendorAdapter = new VendorAdapter(getContext());
        rvVendorList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvVendorList.setAdapter(mVendorAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(5, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void displayVendorList(List<VendorVO> vendorList) {
        mVendorAdapter.setNewData(vendorList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                getContext(),
                DataContract.VendorEntry.CONTENT_URI,
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            List<VendorVO> vendorList = new ArrayList<>();
            do {
                VendorVO vendor = VendorVO.parseFromCursor(data);
                vendorList.add(vendor);
            } while (data.moveToNext());

            mPresenter.onVendorLoaded(vendorList);
        } else {
            mPresenter.onLoadVendorFromNetwork();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
