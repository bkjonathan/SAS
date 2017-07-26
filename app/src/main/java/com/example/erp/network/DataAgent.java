package com.example.erp.network;

import android.content.Context;

/**
 * Created by myolwin00 on 7/11/17.
 */

public interface DataAgent {
    void login(String email, String password);
    void loadProducts(Context context, String token);
    void loadVendors(Context context, String token);
    void loadLocations(Context context, String token);
}
