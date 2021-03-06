package com.example.erp.dagger;

import android.content.Context;

import com.example.erp.data.models.LocationModel;
import com.example.erp.data.models.ProductModel;
import com.example.erp.data.models.UserModel;
import com.example.erp.data.models.VendorModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by myolwin00 on 7/17/17.
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    UserModel provideUserModel(Context context) {
        return new UserModel(context);
    }

    @Provides
    @Singleton
    ProductModel provideProductModel(Context context) {
        return new ProductModel(context);
    }

    @Provides
    @Singleton
    VendorModel provideVendorModel(Context context) {
        return new VendorModel(context);
    }

    @Provides
    @Singleton
    LocationModel provideLocationModel(Context context) {
        return new LocationModel(context);
    }
}
