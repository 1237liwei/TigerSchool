package com.tydc.tigerschool.core.request;

/**
 * Created by liwei on 16/8/7.
 */
public class LoginReq {
    /**
     *微信的accesstoken
     */
    private String accesstoken="";
    /**
     *微信用户的公开id
     */
    private String openid="";

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }




}
