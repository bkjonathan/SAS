package com.example.erp.events;

/**
 * Created by myolwin00 on 7/12/17.
 */

public class LoadFailedEvent {

    String message;

    public LoadFailedEvent(String errorMsg) {
        this.message = errorMsg;
    }

    public String getErrorMsg() {
        return message;
    }
}
