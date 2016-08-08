package com.tydc.tigerschool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.tydc.tigerschool.core.BaseActivity;
import com.tydc.tigerschool.core.api.LoginApi;
import com.tydc.tigerschool.core.listener.NetResponseListener;
import com.tydc.tigerschool.core.request.LoginReq;
import com.tydc.tigerschool.core.response.RetrofitError;
import com.tydc.tigerschool.core.response.UserInfo;
import com.tydc.tigerschool.core.utils.CLog;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void findViews() {
    btnTest=(Button)findViewById(R.id.button);
    }

    @Override
    protected void setListeners() {
        btnTest.setOnClickListener(this);
    }

    private NetResponseListener<UserInfo> listener=new NetResponseListener(){


        @Override
        public void onSuccessRsp(Object data) {
            UserInfo u=(UserInfo)data;
            Gson gson=new Gson();
            String  info=gson.toJson(u);
            CLog.e("onSuccessRsp",""+info);
        }

        @Override
        public void onError(RetrofitError error) {
            CLog.e("onError","onError-------------------------------");
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            LoginReq req=new LoginReq();
            req.setOpenid("11111111");
            req.setAccesstoken("22222222");
            LoginApi loginApi=new LoginApi();
            loginApi.request(listener,req);
        }
    }
}
