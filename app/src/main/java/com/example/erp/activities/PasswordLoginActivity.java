package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.erp.ERP;
import com.example.erp.R;
import com.example.erp.activities.base.BaseActivity;
import com.example.erp.mvp.presenters.PasswordLoginPresenter;
import com.example.erp.mvp.views.PasswordLoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.arjsna.passcodeview.PassCodeView;

public class PasswordLoginActivity extends BaseActivity
        implements PassCodeView.TextChangeListener,
        PasswordLoginView {

    @BindView(R.id.pcv_password) PassCodeView passCodeView;
    @BindView(R.id.tv_password_title) TextView tvPasswordTitle;
    @Inject PasswordLoginPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, PasswordLoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_login);
        ButterKnife.bind(this, this);

        ((ERP) getApplicationContext()).getAppComponent().inject(this);
        mPresenter.setView(this);
        // consider login or register
        mPresenter.onCreate();

        passCodeView.setOnTextChangeListener(this);
    }

    @Override
    public void onTextChanged(String text) {
        if(text.length() == 4) {
            mPresenter.onPasswordTyped(text);
        }
    }

    @Override
    public void onNavigateToUserLogin() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    @Override
    public void onRegister() {
        tvPasswordTitle.setText("Create your password.");
    }

    @Override
    public void onLogin() {
        tvPasswordTitle.setText("Enter your password.");
    }

    @Override
    public void onInvalidPassword() {
        passCodeView.setError(true);
        tvPasswordTitle.setText("Invalid password.\nTry again.");
    }

    @Override
    public void onLoginSuccess() {
        startActivity(MainActivity.newIntent(this));
        finish();
    }
}
