package com.example.erp.network;

import com.example.erp.network.responses.LocationResponse;
import com.example.erp.network.responses.LoginResponse;
import com.example.erp.network.responses.ProductResponse;
import com.example.erp.network.responses.VendorResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by myolwin00 on 7/11/17.
 */

public interface ApiCalls {

    @FormUrlEncoded
    @Headers(ApiConstants.LOGIN_HEADER)
    @POST(ApiConstants.API_LOGIN)
    Call<LoginResponse> login(
            @Field(ApiConstants.PARAM_EMAIL) String email,
            @Field(ApiConstants.PARAM_PASSWORD) String password
    );

    @GET(ApiConstants.API_PRODUCT)
    Call<ProductResponse> loadProducts(
            @Header(ApiConstants.PARAM_TOKEN) String token
    );

    @GET(ApiConstants.API_VENDOR)
    Call<VendorResponse> loadVendors(
            @Header(ApiConstants.PARAM_TOKEN) String token
    );

    @GET(ApiConstants.API_LOCATION)
    Call<LocationResponse> loadLocations(
            @Header(ApiConstants.PARAM_TOKEN) String token
    );
}
