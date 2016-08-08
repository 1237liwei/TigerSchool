package com.tydc.tigerschool.core.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.tydc.tigerschool.core.ApplicationCache;
import com.tydc.tigerschool.core.R;
import com.tydc.tigerschool.core.exception.CommonVolleyError;
import com.tydc.tigerschool.core.utils.CLog;
import com.tydc.tigerschool.core.utils.MobileUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Describe: 网络请求
 * Date:     2016-7-31 上午11:32:27
 *
 * @author wugaojie@sinoiov.com
 * @version 1.0
 */
public class FastJsonRequest<T> extends Request<T> {

    private final Response.Listener<T> mListener;
    private Response.ErrorListener errorListener;

    private Class<T> mClass;

    /**
     * Charset for request.
     */
    private static final int TIME_OUT = 2500;
    private String TAG = "FastJsonRequest";

    String body = null;
    final long startTime = System.currentTimeMillis();
    private String serviceCode = null;
    private Context context;
    //  private String title= null;
    private int requestTimes = 0;
    private SingleLoginResponse singleLoginResponse;
    private String url;
    private String sendToken = "";

    public FastJsonRequest(int method, String url, Object bodyObject, String servCode, Class<T> clazz,
                           Response.Listener<T> listener, Response.ErrorListener errorListener, Context context, SingleLoginResponse singleLoginResponse) {
        super(method, url, errorListener);
        CLog.e(TAG, "请求的url--" + url);
        this.url = url;
        mClass = clazz;
        mListener = listener;
        this.errorListener = errorListener;
        this.serviceCode = servCode;
        this.context = context.getApplicationContext();
        this.requestTimes = 0;
        this.singleLoginResponse = singleLoginResponse;
        body = addJsonreqSearchCenter(bodyObject, servCode);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            long stopTime = System.currentTimeMillis();
            long useTime = stopTime - startTime;
            if (null == response) {
                return Response.error(new CommonVolleyError(context.getResources().getString(R.string.network_exception_tips)));
            }
            CLog.e(TAG, "data size: kb " + response.data.length / 1024.0);
            String jsonString = new String(response.data, "utf-8");
            CLog.e(TAG, "得到的json数据-" + jsonString);
            CLog.e(TAG, "本次请求花费时间：" + useTime + "毫秒");
            CommonResponseBean bean = JSON.parseObject(jsonString, CommonResponseBean.class);
            HeadResultBean headResultBean = null;
            if (null != bean) {
                headResultBean = bean.getHead();
            }

            if (null == headResultBean || !"0".equals(headResultBean.getStatus())) {
                CommonVolleyError commonVolleyError = new CommonVolleyError(headResultBean.getErrorMessage());
                commonVolleyError.setErrorCode(headResultBean.getStatus());
                return Response.error(commonVolleyError);// 通过volleyError.getMessage()得到
            }
            if (bean == null || bean.getBody() == null) {
                return Response.success(JSON.parseObject("", mClass),
                        HttpHeaderParser.parseCacheHeaders(response));
            } else {
                return Response.success(JSON.parseObject(bean.getBody(), mClass),
                        HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new CommonVolleyError(context.getResources().getString(R.string.server_response_data_error)));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new CommonVolleyError(context.getResources().getString(R.string.network_exception_tips)));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        if (null != mListener) {
            mListener.onResponse(response);
        }
    }

    /**
     * 设置超时时间
     **/
    @Override
    public RetryPolicy getRetryPolicy() {

        CLog.e(TAG, "超时时间--" + super.getRetryPolicy().getCurrentTimeout() + ",访问次数-"
                + super.getRetryPolicy().getCurrentRetryCount());
        return super.getRetryPolicy();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = new HashMap<String, String>();
        map.put("p", body);// 请求的数据

        CLog.e(TAG, "请求的body--" + body);
        return map;
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        if (null != errorListener) {
            handler.sendEmptyMessage(1);
        }
        return super.parseNetworkError(new CommonVolleyError(context.getResources().getString(R.string.network_exception_tips)));
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            errorListener.onErrorResponse(new CommonVolleyError(context.getResources().getString(R.string.network_exception_tips)));
            super.handleMessage(msg);
        }
    };

    // 针对单点登录
    public interface SingleLoginResponse {
        void onSingleLogin();
//      void success(BaseBeanRsp rsp);
//      void erro(VolleyError error);
    }

    public String addJsonreqSearchCenter(Object bodyObject,
                                         String servCode) {
        String requestStr = "";
        CommonRequestBean commonbean = new CommonRequestBean();
        HeadRequestBean headBean = new HeadRequestBean();

        headBean.setDeviceId(MobileUtils.getDeviceId(context));

        headBean.setAppVersion(MobileUtils.extractPltpVersionName(ApplicationCache.getInstance()));// app版本号
        headBean.setMobileModel(android.os.Build.MODEL);
        headBean.setProtocolVersion("1.0");
        headBean.setRequestTime(System.currentTimeMillis());
        headBean.setSequenceCode(System.currentTimeMillis());
        headBean.setServerCode(servCode);
        headBean.setSourceSystem("1");// 1-安卓 ，2-IOS
        headBean.setSystemVersion(android.os.Build.VERSION.RELEASE);// 系统版本号


        setTag("");
        commonbean.setHead(headBean);
//        commonbean.setSign(Secret.getSecretInstance(context).getSignKey());
        commonbean.setBody(bodyObject);
        try {
            requestStr = JSON.toJSONString(commonbean);
//            commonbean.setSign(MD5Utils.getDefaultMd5String(requestStr));
            requestStr = JSON.toJSONString(commonbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestStr;
    }


}
