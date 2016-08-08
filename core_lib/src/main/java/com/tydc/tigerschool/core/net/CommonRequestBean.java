package com.tydc.tigerschool.core.net;

/**
 * Created by liwei on 16/7/31.
 */
public class CommonRequestBean {

    private HeadRequestBean head;
    private Object body;
    private String sign;

    public String OPERATION_CODE;

    public HeadRequestBean getHead() {
        return head;
    }

    public void setHead(HeadRequestBean head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {

        this.body = body;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
