package com.xin.xinprojectsdemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;

import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.citydemo.CityLikeTaobaoDemo;
import com.xin.xinprojectsdemo.customermenu.CustomerContentActivity;

public class CustomerActivity extends BaseActivity implements View.OnClickListener {

    private Button mCityLike;
    private Button mBtnCustomer;


    @Override
    public void initView() {
        setContentView(R.layout.activity_customer);
        mCityLike = (Button) findViewById(R.id.citylike);
        mBtnCustomer = (Button) findViewById(R.id.customercontent);
    }

    @Override
    public void initListener() {
        mCityLike.setOnClickListener(this);
        mBtnCustomer.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.citylike:
                startActivity(new Intent(this, CityLikeTaobaoDemo.class));
                break;
            //自定义组合控件的使用
            case R.id.customercontent:
                ActivityOptionsCompat compatcustomer = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim
                        .fade_in, android.R.anim.fade_out);
                ActivityCompat.startActivity(this,new Intent(this,
                        CustomerContentActivity.class),compatcustomer.toBundle());
                break;
        }

    }
}
