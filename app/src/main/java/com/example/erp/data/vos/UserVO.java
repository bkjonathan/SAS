package com.example.erp.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class UserVO {

    @SerializedName("username")
    private String userName;

    @SerializedName("email")
    private String email;

    @SerializedName("_token")
    private String token;

    public UserVO() {
    }

    public void saveLoginUser() {
        //TODO: save onLogin user to db
    }

    public static UserVO loadLoginUser() {
        //TODO: load onLogin user form db
        return null;
    }

    public void clearData() {
        //TODO: delete user from db
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
