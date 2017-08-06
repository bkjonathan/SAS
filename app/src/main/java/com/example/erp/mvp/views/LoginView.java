package com.example.erp.mvp.views;

import com.example.erp.data.vos.UserVO;
import com.example.erp.mvp.views.base.BaseView;

/**
 * Created by myolwin00 on 7/14/17.
 */

public interface LoginView extends BaseView {
    void onSigningIn();
    void onLoginSuccess();
    void onLoginFailed(String errorMessage);
    void onInsufficientInfo(String message);
}
