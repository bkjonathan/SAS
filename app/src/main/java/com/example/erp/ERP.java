package com.example.erp;

import android.app.Application;

import com.example.erp.dagger.AppComponent;
import com.example.erp.dagger.AppModule;
import com.example.erp.dagger.DaggerAppComponent;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class ERP extends Application {

    public static final String TAG = "Emrys";

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = initDagger(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private AppComponent initDagger(ERP erp) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(erp))
                .build();
    }
}
