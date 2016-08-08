package com.tydc.tigerschool.core.request;

/**
 * Created by liwei on 16/8/7.
 */
public class BindMobileReq {
    /**
     *老虎学院的sessionid。
     */
    private String session="";
    /**
     *电话号码。
     */
    private String mobile="";
    /**
     *短信验证码
     */
    private String verifycode="";

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

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }


}
