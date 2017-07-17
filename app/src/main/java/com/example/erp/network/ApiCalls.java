package com.example.erp.network;

import com.example.erp.network.responses.LoginResponse;
import com.example.erp.network.responses.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by myolwin00 on 7/11/17.
 */

public interface ApiCalls {

    @Headers(ApiConstants.LOGIN_HEADER)
    @GET("login/{email}/{password}")
    Call<LoginResponse> login(
            @Path("email") String email,
            @Path("password") String password
    );

    @GET("Products")
    Call<ProductResponse> loadProducts(
        @Header("TOKEN") String token
    );
}
