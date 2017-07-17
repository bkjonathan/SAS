package com.example.erp.network.responses;

import com.example.erp.data.vos.UserVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class LoginResponse {

    @SerializedName("userdata")
    private List<UserVO> mUser;

    public List<UserVO> getUser() {
        return mUser;
    }
}
