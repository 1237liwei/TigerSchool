package com.tydc.tigerschool.core.api;

import com.tydc.tigerschool.core.api.service.UserService;
import com.tydc.tigerschool.core.listener.NetResponseListener;
import com.tydc.tigerschool.core.request.LoginReq;
import com.tydc.tigerschool.core.response.RetrofitError;
import com.tydc.tigerschool.core.response.UserInfo;
import com.tydc.tigerschool.core.utils.CLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by liwei on 16/8/7.
 */
public class LoginApi extends BaseApi{

    public void request(final NetResponseListener<UserInfo> listener, final LoginReq model) {

        UserService apiService = getRetrofit().create(UserService.class);
        Call<UserInfo> call = (Call<UserInfo>) apiService.userLogin(model);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if(response!=null){
                    CLog.e("onResponse",response.message());
                    CLog.e("onResponse",""+response.code());
                    UserInfo u=response.body();
                    listener.onSuccessRsp(u);
                }else{
                    RetrofitError error=new RetrofitError();
                    error.setErrorMsg(response.message());
                    error.setCode(String.valueOf(response.code()));
                    listener.onError(error);
                }


            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                RetrofitError error=new RetrofitError();
                error.setErrorMsg(t.getMessage());
                listener.onError(error);
            }


        });
    }
}
