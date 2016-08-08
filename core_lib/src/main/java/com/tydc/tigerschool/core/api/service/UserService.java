package com.tydc.tigerschool.core.api.service;

import com.tydc.tigerschool.core.request.BindMobileReq;
import com.tydc.tigerschool.core.request.LoginReq;
import com.tydc.tigerschool.core.request.VerifyCodeReq;
import com.tydc.tigerschool.core.response.DataBean;
import com.tydc.tigerschool.core.response.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by liwei on 16/8/7.
 */
public interface UserService {
//    @Headers({
//            "Cache-Control: max-age=640000",
//            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko"
//    })

    /**
     * 微信登录
     * @param req
     * @return
     */
    @POST("user/wxlogin")
    Call<UserInfo> userLogin(@Body LoginReq req);

    /**
     * 获取验证码
     * @param req
     * @return
     */
    @GET("/user/verifycode")
    Call<DataBean> verifyCode(@Body VerifyCodeReq req);

    /**
     * 绑定手机号
     * @param req
     * @return
     */
    @POST("user/bandmobile")
    Call<DataBean> bindMobile(@Body BindMobileReq req);
}
