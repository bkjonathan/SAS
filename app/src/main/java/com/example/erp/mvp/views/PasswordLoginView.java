package com.example.erp.mvp.views;

import com.example.erp.mvp.views.base.BaseView;

/**
 * Created by myolwin00 on 7/20/17.
 */

public interface PasswordLoginView extends BaseView {

    void onNavigateToUserLogin();

    void onRegister();
    void onLogin();
    void onInvalidPassword();
    void onLoginSuccess();
}
