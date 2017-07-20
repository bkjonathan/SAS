package com.example.erp.mvp.presenters;

import android.content.Context;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.data.models.UserModel;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.PasswordLoginView;

import javax.inject.Inject;

/**
 * Created by myolwin00 on 7/20/17.
 */

public class PasswordLoginPresenter extends BasePresenter<PasswordLoginView> {

    @Inject
    UserModel mUserModel;

    private boolean isLogin;
    private String userPassword;

    public PasswordLoginPresenter(Context context) {
        ((ERP) context.getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public void onCreate() {

        String userToken = mUserModel.getUserToken();
        if (userToken.length() == 0) {
            mView.onNavigateToUserLogin();
        } else {
            isLogin = mUserModel.isLogin();
            if (isLogin) {
                mView.onLogin();
                userPassword = mUserModel.getUserPassword();
            } else {
                mView.onRegister();
            }
        }
    }

    public void onPasswordTyped(String text) {
        if (isLogin) {
            if (userPassword.contains(text)) {
                mView.onLoginSuccess();
            } else {
                mView.onInvalidPassword();
            }
        } else {
            mUserModel.saveUserPassword(text);
            mView.onLoginSuccess();
        }
    }
}
