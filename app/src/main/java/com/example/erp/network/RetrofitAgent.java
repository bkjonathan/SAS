package com.example.erp.network;

import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.network.responses.LoginResponse;
import com.example.erp.network.responses.ProductResponse;
import com.example.erp.events.DataEvent;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.events.UserEvent;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class RetrofitAgent implements DataAgent {

    private ApiCalls apiCalls;

    public RetrofitAgent() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        apiCalls = retrofit.create(ApiCalls.class);
    }

    @Override
    public void login(String email, String password) {

        final Call<LoginResponse> loginCall = apiCalls.login(email, password);

        loginCall.enqueue(new ApiCallback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                super.onResponse(call, response);
                LoginResponse loginResponse = response.body();
                if (loginResponse != null) {
                    EventBus.getDefault().post(new UserEvent.SuccessLoginEvent(loginResponse));
                }
            }
        });
    }

    @Override
    public void loadProducts(String token) {
        final Call<ProductResponse> dataCall = apiCalls.loadProducts(token);

        dataCall.enqueue(new ApiCallback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                super.onResponse(call, response);
                ProductResponse productResponse = response.body();
                if (productResponse != null) {
                    EventBus.getDefault().post(new DataEvent.ProductEvent(productResponse));
                }
            }
        });
    }
}
