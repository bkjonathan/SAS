package com.example.erp.data.models;

import android.content.Context;

import com.example.erp.ERP;
import com.example.erp.network.DataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by myolwin00 on 7/11/17.
 */

public abstract class BaseModel {

    @Inject
    public DataAgent mDataAgent;

    public BaseModel(Context context) {
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }

        ((ERP) context).getAppComponent().inject(this);
    }

    @Subscribe()
    public void onEvent(Object obj) {
    }
}