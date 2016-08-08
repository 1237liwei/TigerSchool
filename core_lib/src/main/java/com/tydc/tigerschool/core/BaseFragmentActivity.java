package com.tydc.tigerschool.core;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.tydc.tigerschool.core.view.DialogHelper;

/**
 * Created by liwei on 16/7/31.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {
    Dialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        init();
        findViews();
        setListeners();
    }

    /**
     * 隐藏等待对话框
     */
    public void hideWaitDialog() {
        if (waitDialog != null && waitDialog.isShowing()) {
            try {
                waitDialog.dismiss();
                waitDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 显示等待对话框
     */
    public Dialog showWaitDialog() {
        if (waitDialog == null) {
            waitDialog = DialogHelper.getWaitDialog(this, false);
        }
        if (waitDialog != null && !waitDialog.isShowing()) {
            waitDialog.show();
        }
        return waitDialog;
    }

    /**
     * 设置布局
     */
    protected abstract void setContentView();

    /**
     * 初始化，setContentView后调用
     */
    protected abstract void init();

    /**
     * 查找视图。init后调用；
     */
    protected abstract void findViews();

    /**
     * 设置侦听器，findViews后调用
     */
    protected abstract void setListeners();

}
