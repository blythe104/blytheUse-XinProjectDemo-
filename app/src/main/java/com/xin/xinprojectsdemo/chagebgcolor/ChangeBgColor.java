package com.xin.xinprojectsdemo.chagebgcolor;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xin.xinprojectsdemo.MainActivity;
import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.utils.SharedPreferencesUtils;

public class ChangeBgColor extends BaseActivity {


    private android.widget.Button btnred;
    private android.widget.Button btngreen;
    private int color;
    private RelativeLayout relativeLayout;
    private Button btngold;

    @Override
    public void initView() {
        setContentView(R.layout.activity_change_bg_color);
        initTitleBar();
        color = SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0);
        btngreen = (Button) findViewById(R.id.btn_green);
        btnred = (Button) findViewById(R.id.btn_red);
        btngold = (Button) findViewById(R.id.btn_gold);
        if (color == 1) {
            relativeLayout.setBackgroundColor(Color.GREEN);
        } else if (color == 2) {
            relativeLayout.setBackgroundColor(Color.RED);
        }
    }

    public void initTitleBar() {
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_titlebar);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("改变颜色");
        FrameLayout mFrback = (FrameLayout) findViewById(R.id.fr_back);
        mFrback.setOnClickListener(this);
        TextView mTitleTag = (TextView) findViewById(R.id.tv_title_tag);
        mTitleTag.setVisibility(View.INVISIBLE);

    }

    @Override
    public void initListener() {
        btngreen.setOnClickListener(this);
        btnred.setOnClickListener(this);
        btngold.setOnClickListener(this);

    }

    @Override
    public void initData() {


    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.fr_back:
                startActivity(new Intent(ChangeBgColor.this, MainActivity.class));
                break;
            case R.id.btn_green:
                SharedPreferencesUtils.saveInt(getApplicationContext(), "color", 1);
                System.out.println("color---" + SharedPreferencesUtils.getInt(getApplicationContext(),
                        "color", 0));
                relativeLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btn_red:
                SharedPreferencesUtils.saveInt(getApplicationContext(), "color", 2);
                System.out.println("color---" + SharedPreferencesUtils.getInt(getApplicationContext(),
                        "color", 0));
                relativeLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.btn_gold:
                SharedPreferencesUtils.saveInt(getApplicationContext(), "color", 3);
                System.out.println("color---" + SharedPreferencesUtils.getInt(getApplicationContext(),
                        "color", 0));
                relativeLayout.setBackgroundColor(Color.GRAY);
                break;
        }

    }
}
