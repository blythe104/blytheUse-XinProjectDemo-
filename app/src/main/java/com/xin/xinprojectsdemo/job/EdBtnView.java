package com.xin.xinprojectsdemo.job;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.xin.xinprojectsdemo.R;

/**
 * Created by xin on 2016/9/23.
 */
public class EdBtnView extends LinearLayout {

    public EdBtnView(Context context) {
        this(context,null);
    }

    public EdBtnView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.et_btn_layout,this,true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
