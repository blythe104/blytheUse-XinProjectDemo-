package com.xin.xinprojectsdemo;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xin.xinprojectsdemo.androidh5.HtmlActivity;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.chagebgcolor.ChangeBgColor;
import com.xin.xinprojectsdemo.customattr.TypeDemo;
import com.xin.xinprojectsdemo.dslc.FXActivity;
import com.xin.xinprojectsdemo.dslc.JXAtivity;
import com.xin.xinprojectsdemo.dslc.MineActivity;
import com.xin.xinprojectsdemo.dslc.ProgressBarActivity;
import com.xin.xinprojectsdemo.dslc.RadioButtonMoreStyle;
import com.xin.xinprojectsdemo.dslc.RecyclerViewActivity;
import com.xin.xinprojectsdemo.dslc.ZytActivity;
import com.xin.xinprojectsdemo.fontchange.ViewPagerUseActivity;
import com.xin.xinprojectsdemo.marqueen.MarQueenActivity;
import com.xin.xinprojectsdemo.transtoolbar.DemoActivity;
import com.xin.xinprojectsdemo.utils.SharedPreferencesUtils;

public class MainActivity extends BaseActivity {

    private Button customa;
    private Button fontchange;
    private Button marqueen;
    private Button mAndroidH5;
    private Button mTransToolbar;
    private Button mChangeColor;
    private RelativeLayout relativeLayout;
    private Button mDslcWd;
    private Button mDslcFx;
    private Button mDslcJx;
    private Button mRadioChange;
    private Button mProgressbar;
    private Button mRecyclerView;
    private Button mZyt;


    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        initTitleBar();
        marqueen = (Button) findViewById(R.id.marqueen);
        fontchange = (Button) findViewById(R.id.fontchange);
        customa = (Button) findViewById(R.id.customa);
        mAndroidH5 = (Button) findViewById(R.id.androidh5);
        mTransToolbar = (Button) findViewById(R.id.transtoolbar);
        mChangeColor = (Button) findViewById(R.id.chageColor);
        int color = SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0);
        System.out.println("colormain" + SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0));
        if (color == 1) {
            relativeLayout.setBackgroundColor(Color.GREEN);
        } else if (color == 2) {
            relativeLayout.setBackgroundColor(Color.RED);
        } else if (color == 3) {
            relativeLayout.setBackgroundColor(Color.GRAY);
        }
        mDslcWd = (Button) findViewById(R.id.dslcwd);
        mDslcJx = (Button) findViewById(R.id.dslcjx);
        mDslcFx = (Button) findViewById(R.id.dslcfx);
        mRadioChange = (Button) findViewById(R.id.radiochange);
        mProgressbar = (Button) findViewById(R.id.mprogressbar);
        mRecyclerView = (Button) findViewById(R.id.mrecyclerView);
        mZyt = (Button) findViewById(R.id.mzyt);


    }

    public void initTitleBar() {
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_titlebar);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("主界面");
        FrameLayout mFrback = (FrameLayout) findViewById(R.id.fr_back);
        mFrback.setVisibility(View.INVISIBLE);
        TextView mTitleTag = (TextView) findViewById(R.id.tv_title_tag);
        mTitleTag.setVisibility(View.INVISIBLE);

    }

    @Override
    public void initListener() {
        marqueen.setOnClickListener(this);
        fontchange.setOnClickListener(this);
        customa.setOnClickListener(this);
        mAndroidH5.setOnClickListener(this);
        mTransToolbar.setOnClickListener(this);
        mChangeColor.setOnClickListener(this);
        mDslcWd.setOnClickListener(this);
        mDslcFx.setOnClickListener(this);
        mDslcJx.setOnClickListener(this);
        mRadioChange.setOnClickListener(this);
        mProgressbar.setOnClickListener(this);
        mRecyclerView.setOnClickListener(this);
        mZyt.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.marqueen:
                startActivity(new Intent(this, MarQueenActivity.class));
                break;
            case R.id.customa:
                startActivity(new Intent(this, TypeDemo.class));
                break;
            case R.id.fontchange:
                startActivity(new Intent(this, ViewPagerUseActivity.class));
                break;
            case R.id.androidh5:
                startActivity(new Intent(this, HtmlActivity.class));
                break;
            case R.id.transtoolbar:
                startActivity(new Intent(this, DemoActivity.class));
                break;
            case R.id.chageColor:
                startActivity(new Intent(this, ChangeBgColor.class));
                break;
            case R.id.dslcwd:
                startActivity(new Intent(this, MineActivity.class));
                break;
            case R.id.dslcfx:
                startActivity(new Intent(this, FXActivity.class));
                break;
            case R.id.dslcjx:
                startActivity(new Intent(this, JXAtivity.class));
                break;
            case R.id.radiochange:
                startActivity(new Intent(this, RadioButtonMoreStyle.class));
                break;
            case R.id.mprogressbar:
                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
            case R.id.mrecyclerView:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.mzyt:
                startActivity(new Intent(this, ZytActivity.class));
                break;
        }

    }
}
