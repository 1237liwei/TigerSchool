package com.tydc.tigerschool.core.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tydc.tigerschool.core.R;
import com.tydc.tigerschool.core.utils.CLog;

/**
 * Created by liwei on 16/7/31.
 */
public class DialogHelper {
    /**
     * 自定义等待对话框
     *
     * @param context
     */
    public static Dialog getWaitDialog(Context context, boolean isTouchCancel) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loadding_dialog, null);// 得到加载view
        ImageView loadImage = (ImageView) v.findViewById(R.id.iv_loading);
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.loading_dialog_animation);
        // 使用ImageView显示动画
        loadImage.startAnimation(hyperspaceJumpAnimation);
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setContentView(v, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));// 设置布局
        CLog.e("Dialog", "isTouchCancel:"+isTouchCancel);
        if (isTouchCancel) {
            loadingDialog.setCanceledOnTouchOutside(true);
        }else{
            loadingDialog.setCanceledOnTouchOutside(false);
        }
        return loadingDialog;
    }

    /**
     * 获取待文本的等待对话框
     *
     * @param context
     * @param text
     *            `
     */
    public static Dialog getWaitDialog(Context context, int text) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loadding_dialog, null);// 得到加载view
        ImageView loadImage = (ImageView) v.findViewById(R.id.iv_loading);
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.loading_dialog_animation);
        // 使用ImageView显示动画
        loadImage.startAnimation(hyperspaceJumpAnimation);
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setContentView(v, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));// 设置布局
        loadingDialog.setCanceledOnTouchOutside(false);
        return loadingDialog;
    }
}
