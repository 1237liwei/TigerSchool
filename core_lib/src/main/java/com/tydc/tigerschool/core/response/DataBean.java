package com.tydc.tigerschool.core.response;

/**
 * Created by li wei on 2016/8/17.
 */
public class DataBean<T> {
    /**
     * http request code
     */
    private String returncode;
    /**
     * msg info description
     */
    private String returnmsg;

    private T data;

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }







}
