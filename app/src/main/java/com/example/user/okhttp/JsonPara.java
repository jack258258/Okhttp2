package com.example.user.okhttp;

/**
 * Created by USER on 2017/11/29.
 */

public class JsonPara {
    private String success;
    private String message;
    private String token;

    public JsonPara(){}

    public void setSuccess(String success){
        this.success = success;
    }
    public String getSuccess(){
        return success;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }

}
