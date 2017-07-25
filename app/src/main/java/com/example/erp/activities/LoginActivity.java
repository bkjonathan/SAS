package com.example.erp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.R;
import com.example.erp.mvp.presenters.LoginPresenter;
import com.example.erp.mvp.views.LoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity
    implements LoginView {

    @BindView(R.id.login_email)
    EditText edtEmail;

    @BindView(R.id.login_password)
    EditText edtPassword;

    @Inject
    public LoginPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this, this);

        ((ERP) getApplicationContext()).getAppComponent().inject(this);
        mPresenter.setView(this);
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

    @OnClick(R.id.bt_login) void onClick() {
        String emailString = edtEmail.getText().toString();
        String passwordString = edtPassword.getText().toString();
        mPresenter.onLogin(emailString, passwordString);
    }

    @Override
    public void onSigningIn() {
        Toast.makeText(this, "Logging in.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        startActivity(PasswordLoginActivity.newIntent(this));
        finish();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        Toast.makeText(this, ""+errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInsufficientInfo(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
