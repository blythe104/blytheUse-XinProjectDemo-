package com.xin.xinprojectsdemo.dslc;

import android.view.View;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.view.MyView;

public class ZytActivity extends BaseActivity {


    private MyView myView;

    @Override
    public void initView() {
        setContentView(R.layout.activity_zyt);
        myView = (MyView) findViewById(R.id.myView);
        myView.SetInfo(new String[]{"5.1", "2", "3", "4", "5"}, new String[]{"", "10", "20", "30", "40","50"}, new
                int[]{15, 23, 52, 12, 14}, "hello");
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
