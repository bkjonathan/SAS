package com.example.erp.events;

import com.example.erp.data.vos.UserVO;
import com.example.erp.network.responses.LoginResponse;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class UserEvent {

  public static class SuccessLoginEvent {
    private UserVO mUser;

    public SuccessLoginEvent(UserVO mUser) {
      this.mUser = mUser;
    }

    public UserVO getUser() {
      return mUser;
    }
  }
}
