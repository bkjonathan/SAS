package com.example.erp.events;

import com.example.erp.data.vos.UserVO;
import com.example.erp.network.responses.LoginResponse;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class UserEvent {

    public static class SuccessLoginEvent {
        private LoginResponse loginResponse;

        public SuccessLoginEvent(LoginResponse loginResponse) {
            this.loginResponse = loginResponse;
        }

        public LoginResponse getLoginResponse() {
            return loginResponse;
        }
    }
}
