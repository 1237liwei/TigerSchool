package com.tydc.tigerschool.core.response;

/**
 * Created by liwei on 16/8/7.
 */
public class RetrofitError {
    private String code;
    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


}
