package com.tydc.tigerschool.core.api;

import com.tydc.tigerschool.core.constonts.Constont;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liwei on 16/8/7.
 */
public class BaseApi {
    private  Retrofit retrofit=null;
    public Retrofit getRetrofit(){
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constont.BASE_HTTP_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
