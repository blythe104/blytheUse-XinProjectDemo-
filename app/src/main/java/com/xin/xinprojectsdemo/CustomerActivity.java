package com.xin.xinprojectsdemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;

import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.citydemo.CityLikeTaobaoDemo;
import com.xin.xinprojectsdemo.customermenu.CustomerContentActivity;
import com.xin.xinprojectsdemo.keyborad.EditKeyBoardActivity;
import com.xin.xinprojectsdemo.pullrefresh.UltraUseActivity;

public class CustomerActivity extends BaseActivity {

    private Button mCityLike;
    private Button mBtnCustomer;
    private Button mRefreshPull;
    private Button mBtnKeyBorad;


    @Override
    public void initView() {
        setContentView(R.layout.activity_customer);
        mCityLike = (Button) findViewById(R.id.citylike);
        mBtnCustomer = (Button) findViewById(R.id.customercontent);
        mRefreshPull = (Button) findViewById(R.id.refreshpull);
        mBtnKeyBorad = (Button) findViewById(R.id.keyborad);
    }

    @Override
    public void initListener() {
        mCityLike.setOnClickListener(this);
        mBtnCustomer.setOnClickListener(this);
        mRefreshPull.setOnClickListener(this);
        mBtnKeyBorad.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.citylike:
                startActivity(new Intent(this, CityLikeTaobaoDemo.class));
                break;
            //自定义组合控件的使用
            case R.id.customercontent:
                ActivityOptionsCompat compatcustomer = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim
                        .fade_in, android.R.anim.fade_out);
                ActivityCompat.startActivity(this, new Intent(this, CustomerContentActivity.class), compatcustomer
                        .toBundle());
                break;
            case R.id.refreshpull:
                startActivity(new Intent(this, UltraUseActivity.class));
                break;
            case R.id.keyborad:
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim
                        .umeng_socialize_fade_in, R.anim.umeng_socialize_fade_out);
                ActivityCompat.startActivity(this, new Intent(this, EditKeyBoardActivity.class), compat.toBundle());
                break;

        }

    }

}
