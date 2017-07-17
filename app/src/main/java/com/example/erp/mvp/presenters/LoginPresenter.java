package com.example.erp.mvp.presenters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.data.models.UserModel;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.events.UserEvent;
import com.example.erp.mvp.presenters.base.BasePresenter;
import com.example.erp.mvp.views.LoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * Created by myolwin00 on 7/14/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    UserModel mUserModel;

    public LoginPresenter(Context context) {
        ((ERP) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(LoginView view) {
        super.setView(view);
    }

    public void onLogin(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            mView.onInsufficientInfo("Shit!\n U have to fill.");
        } else {
            Log.d(ERP.TAG, "Login.");
            mView.onSigningIn();
            mUserModel.login(email, password);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccessEvent(UserEvent.SuccessLoginEvent event) {
        mView.onLoginSuccess();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginFailedEvent(LoadFailedEvent event) {
        mView.onLoginFailed(event.getErrorMsg());
    }
}
