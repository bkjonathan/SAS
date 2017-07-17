package com.example.erp.network;

/**
 * Created by myolwin00 on 7/11/17.
 */

public interface DataAgent {
    void login(String email, String password);
    void loadProducts(String token);
}
