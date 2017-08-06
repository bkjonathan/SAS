package com.example.erp.dagger;

import android.content.Context;

import com.example.erp.mvp.presenters.LoginPresenter;
import com.example.erp.mvp.presenters.ProductPresenter;
import com.example.erp.mvp.presenters.PasswordLoginPresenter;
import com.example.erp.mvp.presenters.ProductDetailPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by myolwin00 on 7/17/17.
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    public ProductPresenter provideMainPresenter(Context context) {
        return new ProductPresenter(context);
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(Context context) {
        return new LoginPresenter(context);
    }

    @Provides
    @Singleton
    public PasswordLoginPresenter providePasswordLoginPresenter(Context context) {
        return new PasswordLoginPresenter(context);
    }

    @Provides
    @Singleton
    public ProductDetailPresenter provideProductDetailPresenter() {
        return new ProductDetailPresenter();
    }
}
