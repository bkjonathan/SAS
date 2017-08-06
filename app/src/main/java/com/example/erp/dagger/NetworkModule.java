package com.example.erp.dagger;

import com.example.erp.network.DataAgent;
import com.example.erp.network.RetrofitAgent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by myolwin00 on 7/17/17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    DataAgent provideRetrofitAgent() {
        return new RetrofitAgent();
    }
}
