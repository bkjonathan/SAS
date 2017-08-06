package com.example.erp.activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.R;
import com.example.erp.activities.base.BaseActivity;
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

    @BindView(R.id.fab)
    FloatingActionButton fab;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.bt_login, R.id.fab}) void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_login :
                String emailString = edtEmail.getText().toString();
                String passwordString = edtPassword.getText().toString();
                mPresenter.onLogin(emailString, passwordString);
                break;

            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                }
                break;

        }

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
