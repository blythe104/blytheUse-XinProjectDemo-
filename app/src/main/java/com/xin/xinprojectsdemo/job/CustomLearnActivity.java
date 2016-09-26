package com.xin.xinprojectsdemo.job;

import android.view.View;
import android.widget.LinearLayout;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class CustomLearnActivity extends BaseActivity {


    private LinearLayout main_layout;
    private CustomTitleBar mCustomTitleBar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_custom_learn);
        mCustomTitleBar = (CustomTitleBar) findViewById(R.id.custom_title);
        mCustomTitleBar.setmTitle("hello one tow");
        //        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        //        LayoutInflater inflater = LayoutInflater.from(this);
        //        View child = inflater.inflate(R.layout.activity_base_tran, null);
        //        main_layout.addView(child);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {

    }
}
