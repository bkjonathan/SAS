package com.example.erp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.erp.R;
import com.example.erp.activities.base.BaseActivity;

/**
 * Created by zwe on 8/6/17.
 */

public class CompanyProfile extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);
    }
}
