package com.example.erp.dagger;

import com.example.erp.activities.LoginActivity;
import com.example.erp.activities.MainActivity;
import com.example.erp.activities.PasswordLoginActivity;
import com.example.erp.data.models.BaseModel;
import com.example.erp.mvp.presenters.LoginPresenter;
import com.example.erp.mvp.presenters.MainPresenter;
import com.example.erp.mvp.presenters.PasswordLoginPresenter;

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
    void inject(MainActivity mainActivity);
    void inject(PasswordLoginActivity passwordLoginActivity);

    // models
    void inject(BaseModel baseModel);

    // presenters
    void inject(LoginPresenter loginPresenter);
    void inject(MainPresenter mainPresenter);
    void inject(PasswordLoginPresenter passwordLoginPresenter);
}
