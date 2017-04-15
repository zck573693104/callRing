package com.callRing.exception;

/**
 * Created by kcz on 2016/1/28.
 */
public class CustomException extends Exception {

    public String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public CustomException(String message){
        super(message);
        this.message=message;
    }

}
