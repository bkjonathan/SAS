package com.example.erp.dagger;

import com.example.erp.activities.LoginActivity;
import com.example.erp.activities.PasswordLoginActivity;
import com.example.erp.activities.ProductDetailActivity;
import com.example.erp.data.models.BaseModel;
import com.example.erp.mvp.presenters.LoginPresenter;
import com.example.erp.mvp.presenters.PasswordLoginPresenter;
import com.example.erp.mvp.presenters.ProductPresenter;
import com.example.erp.mvp.presenters.VendorPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by myolwin00 on 7/17/17.
 */
@Singleton
@Component(modules = {AppModule.class, ModelModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {

    // activities
    void inject(LoginActivity loginActivity);
    void inject(PasswordLoginActivity passwordLoginActivity);
    void inject(ProductDetailActivity productDetailActivity);

    // models
    void inject(BaseModel baseModel);

    // presenters
    void inject(LoginPresenter loginPresenter);
    void inject(ProductPresenter productPresenter);
    void inject(PasswordLoginPresenter passwordLoginPresenter);
    void inject(VendorPresenter vendorPresenter);
}
