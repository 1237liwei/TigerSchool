package com.tydc.tigerschool.core.request;

/**
 * Created by liwei on 16/8/7.
 */
public class VerifyCodeReq {
    /**
     * 老虎学院的sessionid。
     */
    private String session="";
    /**
     * 电话号码
     */
    private String mobile="";

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
