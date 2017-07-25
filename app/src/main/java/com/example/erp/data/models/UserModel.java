package com.example.erp.data.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.erp.ERP;
import com.example.erp.events.UserEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class UserModel extends BaseModel {

    private static final String USER_TOKEN = "user_token";
    private static final String USER_PASSWORD = "user_password";
    private static final String IS_LOGIN = "is_login";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public UserModel(Context context) {
        super(context);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    public void login(String email, String password) {
        mDataAgent.login(email, password);
    }

    public String getUserToken() {
        return preferences.getString(USER_TOKEN, "");
    }

    public String getUserPassword() {
        return preferences.getString(USER_PASSWORD, "");
    }

    public boolean isLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void saveUserPassword(String password) {
        editor.putString(USER_PASSWORD, password);
        editor.putBoolean(IS_LOGIN, true);
        Log.d(ERP.TAG, password);
        editor.commit();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccesLoginEvent(UserEvent.SuccessLoginEvent event) {
        String token = event.getUser().getToken();
        editor.putString(USER_TOKEN, token);
        Log.d(ERP.TAG, token);
        editor.commit();
    }
}
