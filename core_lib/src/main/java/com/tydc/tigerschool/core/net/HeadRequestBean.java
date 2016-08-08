package com.tydc.tigerschool.core.net;

/**
 * Created by liwei on 16/7/31.
 * 协议头公共部分
 */

public class HeadRequestBean {
    private String serverCode;

    private long sequenceCode;

    private long requestTime;

    private String sourceSystem;// 1:android,2:iOS

    private String protocolVersion;// 1.0

    private String appVersion;

    private String mobileModel;

    private String token;

    private String userId;
    private String uaaId;
    private String systemVersion;
    private String mobileNo;// 2.4.1新添加
    private String deviceId;// 2.4.1新添加 设备id
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getSequenceCode() {
        return sequenceCode;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public void setSequenceCode(long sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getUaaId() {
        return uaaId;
    }

    public void setUaaId(String uaaId) {
        this.uaaId = uaaId;
    }

}
