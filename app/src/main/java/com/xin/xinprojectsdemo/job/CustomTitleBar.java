package com.xin.xinprojectsdemo.job;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;

/**
 * Created by xin on 2016/9/18.
 */
public class CustomTitleBar extends FrameLayout {

    private TextView mTitle;
    private Button mBtnBack;
    private Button mBtnNext;
    private String title;

    public CustomTitleBar(Context context) {
        super(context);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar_layout, this);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mBtnBack = (Button) findViewById(R.id.btn_back);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();

            }
        });
        mBtnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "hello this is next", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void setmTitle(String title) {
        mTitle.setText(title);
    }
}
