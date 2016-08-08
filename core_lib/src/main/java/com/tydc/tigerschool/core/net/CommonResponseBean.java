package com.tydc.tigerschool.core.net;

/**
 * 网络返回结果解析
 *
 * @author liwei
 */
public class CommonResponseBean {

    private HeadResultBean head;

    private String body;

    private String sign;

    public HeadResultBean getHead() {
        return head;
    }

    public void setHead(HeadResultBean head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
