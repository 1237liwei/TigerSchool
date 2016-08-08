package com.tydc.tigerschool.core.view.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.tydc.tigerschool.core.R;


public class LoadAllText extends TextView {

	public LoadAllText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	public LoadAllText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	public LoadAllText(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		setText("已全部加载");
		setGravity(Gravity.CENTER);
		setTextSize(16);
		setTextColor(getResources().getColor(R.color.color_999999));
	}

}
