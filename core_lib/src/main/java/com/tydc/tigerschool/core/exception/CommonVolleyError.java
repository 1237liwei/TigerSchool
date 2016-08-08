package com.tydc.tigerschool.core.exception;

import com.android.volley.VolleyError;

/**
 * Describe: 这里用一句话描述这个类的作用
 * Date:     2016年7月31日 上午11:57:17
 * @author   liwei
 * @version 1.0
 */
public class CommonVolleyError  extends VolleyError {
    private static final long serialVersionUID = 5720618495381870293L;
    private String errorCode;

    public CommonVolleyError(String errorMsg) {
        super(errorMsg);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

