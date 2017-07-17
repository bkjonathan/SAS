package com.example.erp.data.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.erp.ERP;
import com.example.erp.data.vos.UserVO;
import com.example.erp.events.LoadFailedEvent;
import com.example.erp.events.UserEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class UserModel extends BaseModel {

    private static final String PREF_TOKEN = "pref_token";
    private static final String USER_TOKEN = "user_token";

    private SharedPreferences tokenPref;

    public UserModel(Context context) {
        super(context);
        tokenPref = context.getSharedPreferences(PREF_TOKEN, Context.MODE_PRIVATE);
    }

    public void login(String email, String password) {
        mDataAgent.login(email, password);
    }

    public String getUserToken() {
        return tokenPref.getString(USER_TOKEN, "");
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccesLoginEvent(UserEvent.SuccessLoginEvent event) {
        String token = event.getLoginResponse().getUser().get(0).getToken();
        SharedPreferences.Editor editor = tokenPref.edit();
        editor.putString(USER_TOKEN, token);
        Log.d(ERP.TAG, token);
        editor.commit();
    }
}
