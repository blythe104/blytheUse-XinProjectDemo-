package com.xin.xinprojectsdemo.dslc;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class MineActivity extends BaseActivity {

    private FragmentManager mFragmentManager;


    private ViewPager mPager;


    private int currentItem = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
       setContentView(R.layout.activity_mine);

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
