package com.example.erp.mvp.presenters.base;

import com.example.erp.mvp.views.base.BaseView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by myolwin00 on 7/17/17.
 */

public class BasePresenter<V extends BaseView> {

    protected V mView;

    public BasePresenter() {
    }

    public void onCreate() {
    }

    public void onStart() {
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
    }

    public void onDestroy() {

    }

    @Subscribe
    public void onEvent(Object obj) {

    }

    public void setView(V view) {
        mView = view;
    }
}
