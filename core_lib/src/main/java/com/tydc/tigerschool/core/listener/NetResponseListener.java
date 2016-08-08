package com.tydc.tigerschool.core.listener;


import com.tydc.tigerschool.core.response.RetrofitError;

/**
 * Created by liwei on 16/8/7.
 */
public interface NetResponseListener<T> {
    /**
     * 数据返回成功回调
     * @param data 返回的数据
     */
    public void onSuccessRsp(T data);
    /**
     * 请求发的错误回调
     * @param error 错误信息
     */
    public void onError(RetrofitError error);
}
