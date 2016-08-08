/**
 * @file XFooterView.java
 * @create Mar 31, 2012 9:33:43 PM
 * @author Maxwin
 * @description XListView's footer
 */
package com.tydc.tigerschool.core.view.xlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tydc.tigerschool.core.R;


@SuppressLint("NewApi")
public class XListViewFooter extends LinearLayout {
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;

	//private Context mContext;

	private View mContentView;
	private View mProgressBar;
	private View mHint;
//	private TextView mHintView;
	private View ll_footer_pcontext;
	
	public XListViewFooter(Context context) {
		super(context);
		initView(context);
	}
	
	public XListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}


	public XListViewFooter(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);
		initView(context);
	}
	
	public void setState(int state) {
//		mProgressBar.setVisibility(View.INVISIBLE);
//		mHint.setVisibility(View.INVISIBLE);
//		mHintView.setVisibility(View.INVISIBLE);
//		mContentView.setVisibility(View.INVISIBLE);
		if (state == STATE_LOADING) {
//			mProgressBar.setVisibility(View.VISIBLE);
//			mHint.setVisibility(View.VISIBLE);
//			Log.e("state", "foot visable");
//			ll_footer_pcontext.setVisibility(View.VISIBLE);
//			mContentView.setVisibility(View.VISIBLE);
			show();
		} else {
//			mProgressBar.setVisibility(View.INVISIBLE);
//			mHint.setVisibility(View.INVISIBLE);
//			Log.e("state", "foot invisable");
//			ll_footer_pcontext.setVisibility(View.INVISIBLE);
//			mContentView.setVisibility(View.INVISIBLE);
			hide();
		}
	}
	
/*	public void setBottomMargin(int height) {
		if (height < 0) return ;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)mContentView.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}
*/	
//	public int getBottomMargin() {
//		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)mContentView.getLayoutParams();
//		return lp.bottomMargin;
//	}
	
	
	/**
	 * normal status
	 */
	public void normal() {
		mHint.setVisibility(View.INVISIBLE);
		mProgressBar.setVisibility(View.INVISIBLE);
	}
	
	
	/**
	 * loading status 
	 */
	public void loading() {
		mHint.setVisibility(View.INVISIBLE);
		mProgressBar.setVisibility(View.INVISIBLE);
	}
	
	/**
	 * hide footer when disable pull load more
	 */
	public void hide() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)mContentView.getLayoutParams();
		lp.height = 0;
		mContentView.setLayoutParams(lp);
	}

	/**
	 * show footer
	 */
	public void show() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)mContentView.getLayoutParams();
		lp.height = LayoutParams.WRAP_CONTENT;
		mContentView.setLayoutParams(lp);
	}

	private void initView(Context context) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		View moreView = LayoutInflater.from(context).inflate(R.layout.xlistview_footer, null);
		addView(moreView,lp);
		ll_footer_pcontext = moreView.findViewById(R.id.ll_footer_pcontext);
		mContentView = moreView.findViewById(R.id.xlistview_footer_content);
		mProgressBar = moreView.findViewById(R.id.xlistview_footer_progressbar);
		mHint= moreView.findViewById(R.id.xlistview_footer_hint_textview);
	}
	
	
}
