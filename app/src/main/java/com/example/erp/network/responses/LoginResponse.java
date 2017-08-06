package com.example.erp.network.responses;

import com.example.erp.data.vos.UserVO;
import com.google.gson.annotations.SerializedName;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class LoginResponse {

    @SerializedName("message")
    private String mMessage;

    @SerializedName("userdata")
    private UserVO mUser;

    public UserVO getUser() {
        return mUser;
    }
}
