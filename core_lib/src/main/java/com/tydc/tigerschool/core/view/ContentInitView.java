/**  
 * Project Name:cwza_core_lib  
 * File Name:LoadingNoDataErrorView.java  
 * Package Name:com.sinoiov.cwza.core.view  
 * Date:2015年9月26日下午5:33:01    
 * Copyright (c) 2015,www.sinoiov.com All Rights Reserved.  
 *  
*/  
  
package com.tydc.tigerschool.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tydc.tigerschool.core.R;


/**    
 * Describe: 公共初始化视图 
 * Date:     2016年7月31日 下午5:33:01
 * @author
 * @version 1.0        
 */
public class ContentInitView extends LinearLayout {
    RelativeLayout rvLoading;
    //网络连接失败显示的内容
    LinearLayout lvNetworkError;
    //加载中的显示的文本内容
    TextView tvLoadingMsg;
    ImageView ivEmptyImage;
    //加载中的image
    ImageView ivLoadingImage ;
    Context mContext;
    OnReTryClickListener mListener;
    OnUploadContactListener uploadListener;
    //重试按钮
    Button btnRetry;
    //上传通讯录
    Button uploadBtn;
    //数据加载中显示的文本
    int mText;
    public  interface  OnReTryClickListener {
        public void onClick(View v);
    }

    public  interface  OnUploadContactListener {
        public void onClick();
    }

        public ContentInitView(Context context) {
        super(context);  
        init( context);
    }
    public ContentInitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init( context);
    }
    /**
     *  初始化视图
     * @param context 
     * @author
     */
    private void init(Context context){
        this.mContext=context;
        View view = View.inflate(context, R.layout.common_loading_layout, null);
        rvLoading= (RelativeLayout)view.findViewById(R.id.rv_common_loading);
        ivLoadingImage = (ImageView)view.findViewById(R.id.iv_common_loading);
        lvNetworkError    = (LinearLayout)view.findViewById(R.id.lv_commom_network_error);
        tvLoadingMsg= (TextView)view.findViewById(R.id.tv_common_loading_msg);
        ivEmptyImage    = (ImageView)view.findViewById(R.id.iv_common_empty);
        btnRetry= (Button)view.findViewById(R.id.btn_common_retry);
        uploadBtn = (Button)view.findViewById(R.id.btn_common_upload);
        btnRetry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              if(mListener!=null){
                  if(tvLoadingMsg.getVisibility()== View.VISIBLE){
                     loadingDataWidthText(mText);
                  }else{
                      loadingData();
                  }
                  mListener.onClick(v);
              }
            }
        });
        this.addView(view);
        uploadBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (uploadListener != null) {
                    uploadListener.onClick();
                }
            }
        });
    }
    /**
     * 
     * 数据加载中显示的等待画面
     * @author
     */
    public void loadingData() {
        this.setVisibility(View.VISIBLE);
        ivEmptyImage.setVisibility(View.GONE);
        lvNetworkError.setVisibility(View.GONE);
        tvLoadingMsg.setVisibility(View.GONE);
        
        
        rvLoading.setVisibility(View.VISIBLE);
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                mContext, R.anim.loading_dialog_animation);
        // 使用ImageView显示动画
        ivLoadingImage.startAnimation(hyperspaceJumpAnimation);
     
    }
    /**
     * 
     * 数据加载中显示的等待画面
     * @param content 文本内容资源
     * @author
     */
    public void loadingDataWidthText(int content) {
        this.setVisibility(View.VISIBLE);
        ivEmptyImage.setVisibility(View.GONE);
        lvNetworkError.setVisibility(View.GONE);
        
        rvLoading.setVisibility(View.VISIBLE);
        tvLoadingMsg.setVisibility(View.VISIBLE);
        tvLoadingMsg.setText(content);
    }
    /**
     *
     * 数据加载中显示的等待画面
     * @param content 文本内容
     * @author
     */
    public void loadingDataWidthText(String content) {
        this.setVisibility(View.VISIBLE);
        ivEmptyImage.setVisibility(View.GONE);
        lvNetworkError.setVisibility(View.GONE);

        rvLoading.setVisibility(View.VISIBLE);
        tvLoadingMsg.setVisibility(View.VISIBLE);
        tvLoadingMsg.setText(content);
    }
  /**
   * 数据加载完成，隐藏这个view
   * @author
   */
    public void loadFinish() {
        this.setVisibility(View.GONE);
    }
    /**
     * 服务器请求失败时显示的错误
     * @author
     */
    public void netWorkError() {
        this.setVisibility(View.VISIBLE);
        rvLoading.setVisibility(View.GONE);
        tvLoadingMsg.setVisibility(View.GONE);
        
        ivEmptyImage.setVisibility(View.VISIBLE);
        lvNetworkError.setVisibility(View.VISIBLE);
     }
    /**
     * 在无内容是，显示的view
     * @author
     */
    public void loadNoData(int text) { 
        this.mText=text;
        this.setVisibility(View.VISIBLE);
        rvLoading.setVisibility(View.GONE);
        lvNetworkError.setVisibility(View.GONE);
        
        ivEmptyImage.setVisibility(View.VISIBLE);
        tvLoadingMsg.setVisibility(View.VISIBLE);
        tvLoadingMsg.setText(mText);
    }
     /**
      * 在无内容是，显示的view
      * @param text 显示的文本
      * @param imageRes  显示的图片
      * @author
      */
    public void loadNoDataWidthImg(int text,int imageRes) { 
        this.mText=text;
        this.setVisibility(View.VISIBLE);
        rvLoading.setVisibility(View.GONE);
        lvNetworkError.setVisibility(View.GONE);
        ivEmptyImage.setImageResource(imageRes);
        ivEmptyImage.setVisibility(View.VISIBLE);
        tvLoadingMsg.setVisibility(View.VISIBLE);
        tvLoadingMsg.setText(mText);
    }
    /**"
     * 设置重试按钮的监听器 
     * @param listener 
     * @author
     */
   public void setOnReTryClickListener(OnReTryClickListener listener){
       this.mListener=listener;
   }
    public void setOnUploadContact(OnUploadContactListener listener){
        this.uploadListener = listener;
        uploadBtn.setVisibility(View.VISIBLE);
    }

    public void goneUploadBtn(){
        uploadBtn.setVisibility(View.GONE);
    }

    /**
     * 设置按钮的显示文本
     * @param text
     */
    public void setButtonText(int text){

        btnRetry.setText(text);
    }
}
  
