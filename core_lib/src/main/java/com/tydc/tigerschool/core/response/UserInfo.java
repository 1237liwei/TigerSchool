package com.tydc.tigerschool.core.response;

/**
 * Created by liwei on 16/8/7.
 */
public class UserInfo extends DataBean<UserInfo>{

    /**
     *老虎学院的sessionid
     */
    private String session="";
    /**
     *网易云信的账号
     */
    private String imid="";
    /**
     *网易云信的登录token
     */
    private String imtoken="";
    /**
     *用户昵称
     */
    private String nickname="";
    /**
     *头像地址
     */
    private String headimgurl="";
    /**
     *是否绑定过手机号，判断是否进入下一界面以此字段为准。
     */
    private String isbandmobile="";
    /**
     *-1：被禁用。0：未缴费用户。1：新用户。2：进阶用户。3：特约用户。
     */
    private int level=0;
    /**
     *该级别的名称，显示在我的里面。例如进阶用户。
     */
    private String levelname="";
    /**
     *用户过期时间，格式为yyyyMMddHHmmss
     */
    private String expiretime="";
    /**
     *是否提示用户还有多少天过期，登录后提示框的信息为”您的老虎学院还有xx天将过期，请及时续费”，并且在我的里面提示即将过期的天数。
     */
    private String isshowexpiretime="";
    /**
     *是否显示申请特约按钮
     */
    private boolean isshowspecial=false;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getImid() {
        return imid;
    }

    public void setImid(String imid) {
        this.imid = imid;
    }

    public String getImtoken() {
        return imtoken;
    }

    public void setImtoken(String imtoken) {
        this.imtoken = imtoken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getIsbandmobile() {
        return isbandmobile;
    }

    public void setIsbandmobile(String isbandmobile) {
        this.isbandmobile = isbandmobile;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public String getIsshowexpiretime() {
        return isshowexpiretime;
    }

    public void setIsshowexpiretime(String isshowexpiretime) {
        this.isshowexpiretime = isshowexpiretime;
    }

    public boolean isshowspecial() {
        return isshowspecial;
    }

    public void setIsshowspecial(boolean isshowspecial) {
        this.isshowspecial = isshowspecial;
    }



}
