package com.example.erp.network;

import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.events.LoadFailedEvent;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by myolwin00 on 7/11/17.
 */

public abstract class ApiCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T responseBody = response.body();
        if (responseBody == null) {
            LoadFailedEvent event = new LoadFailedEvent(response.message());
            EventBus.getDefault().post(event);
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        LoadFailedEvent event = new LoadFailedEvent(t.getMessage());
        EventBus.getDefault().post(event);
    }
}
