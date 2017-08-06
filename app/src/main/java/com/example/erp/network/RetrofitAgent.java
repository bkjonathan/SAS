package com.example.erp.network;

import android.content.Context;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.data.vos.UserVO;
import com.example.erp.events.DataEvent;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.events.UserEvent;
import com.example.erp.network.responses.LocationResponse;
import com.example.erp.network.responses.LoginResponse;
import com.example.erp.network.responses.ProductResponse;
import com.example.erp.network.responses.VendorResponse;
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

    private void postErrorEvent(String errorMsg) {
        EventBus.getDefault().post(new LoadFailedEvent(errorMsg));
    }

    @Override
    public void login(String email, String password) {

        final Call<LoginResponse> loginCall = apiCalls.login(email, password);

        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    UserEvent.SuccessLoginEvent event =
                            new UserEvent.SuccessLoginEvent(response.body().getUser());
                    EventBus.getDefault().post(event);
                } else {
                    postErrorEvent("Invalid username or password.");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                postErrorEvent(t.getMessage());
            }
        });
    }

    @Override
    public void loadProducts(final Context context, String token) {
        Log.d(ERP.TAG, "loading products...");
        final Call<ProductResponse> productCall = apiCalls.loadProducts(token);

        productCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                ProductResponse productResponse = response.body();
                if (productResponse != null) {
                    EventBus.getDefault().post(
                            new DataEvent.ProductEvent(context, productResponse.getProductsList())
                    );
                }
                Log.d(ERP.TAG, "productsResponseCount: " + productResponse.getProductsList().size());
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                postErrorEvent(t.getMessage());
            }
        });
    }

    @Override
    public void loadVendors(final Context context, String token) {
        Log.d(ERP.TAG, "loading vendors...");
        Call<VendorResponse> vendorCall = apiCalls.loadVendors(token);

        vendorCall.enqueue(new Callback<VendorResponse>() {
            @Override
            public void onResponse(Call<VendorResponse> call, Response<VendorResponse> response) {
                VendorResponse vendorResponse = response.body();
                if (vendorResponse != null) {
                    EventBus.getDefault().post(
                            new DataEvent.VendorEvent(context, vendorResponse.getVendorList())
                    );
                }
                Log.d(ERP.TAG, "vendorResponseCount: " + vendorResponse.getVendorList().size());
            }

            @Override
            public void onFailure(Call<VendorResponse> call, Throwable t) {
                postErrorEvent(t.getMessage());
            }
        });
    }

    @Override
    public void loadLocations(final Context context, String token) {
        Log.d(ERP.TAG, "loading locations...");
        Call<LocationResponse> locationCall = apiCalls.loadLocations(token);

        locationCall.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                LocationResponse locationResponse = response.body();
                if (locationResponse != null) {
                    EventBus.getDefault().post(
                            new DataEvent.LocationEvent(context, locationResponse.getLocationList())
                    );
                }
                Log.d(ERP.TAG, "locationResponseCount: " + locationResponse.getLocationList().size());
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                postErrorEvent(t.getMessage());
            }
        });
    }
}
