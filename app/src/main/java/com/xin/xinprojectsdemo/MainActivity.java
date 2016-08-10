package com.xin.xinprojectsdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xin.xinprojectsdemo.activity.DataIsMatchActivity;
import com.xin.xinprojectsdemo.activity.PathUseActivity;
import com.xin.xinprojectsdemo.activity.PineViewActivity;
import com.xin.xinprojectsdemo.activity.QQListDemoActivity;
import com.xin.xinprojectsdemo.activity.RecyclerViewMenuActivity;
import com.xin.xinprojectsdemo.androidh5.HtmlActivity;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.chagebgcolor.ChangeBgColor;
import com.xin.xinprojectsdemo.customattr.TypeDemo;
import com.xin.xinprojectsdemo.dslc.ProgressBarActivity;
import com.xin.xinprojectsdemo.dslc.RadioButtonMoreStyle;
import com.xin.xinprojectsdemo.dslc.RecyclerViewActivity;
import com.xin.xinprojectsdemo.dslc.YaoYiYaoActivity;
import com.xin.xinprojectsdemo.dslc.ZytActivity;
import com.xin.xinprojectsdemo.fontchange.ViewPagerUseActivity;
import com.xin.xinprojectsdemo.marqueen.MarQueenActivity;
import com.xin.xinprojectsdemo.transtoolbar.DemoActivity;
import com.xin.xinprojectsdemo.utils.ActivityUtils;
import com.xin.xinprojectsdemo.utils.SharedPreferencesUtils;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private Button customa;
    private Button fontchange;
    private Button mAndroidH5;
    private Button mTransToolbar;
    private Button mChangeColor;
    private RelativeLayout relativeLayout;
    private Button mRadioChange;
    private Button mProgressbar;
    private Button mRecyclerView;
    private Button mZyt;
    private Button mYaoYiYao;
    private Button mPinePic;
    private Button mBtnQqList;
    private Button mBtnRecyList;
    private Button mPathUse;
    private Button mBtnJinZhan;
    private Button mBtnRadio;

    //    @BindView(R.id.marqueen)
    private Button marqueen;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTitleBar();

        fontchange = (Button) findViewById(R.id.fontchange);
        customa = (Button) findViewById(R.id.customa);
        mAndroidH5 = (Button) findViewById(R.id.androidh5);
        mTransToolbar = (Button) findViewById(R.id.transtoolbar);
        mChangeColor = (Button) findViewById(R.id.chageColor);
        mPinePic = (Button) findViewById(R.id.pinepic);
        mBtnQqList = (Button) findViewById(R.id.btn_qqlist);
        mBtnRecyList = (Button) findViewById(R.id.btn_recylist);
        int color = SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0);
        System.out.println("colormain" + SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0));
        if (color == 1) {
            relativeLayout.setBackgroundColor(Color.GREEN);
        } else if (color == 2) {
            relativeLayout.setBackgroundColor(Color.RED);
        } else if (color == 3) {
            relativeLayout.setBackgroundColor(Color.GRAY);
        }

        mRadioChange = (Button) findViewById(R.id.radiochange);
        mProgressbar = (Button) findViewById(R.id.mprogressbar);
        mRecyclerView = (Button) findViewById(R.id.mrecyclerView);
        mZyt = (Button) findViewById(R.id.mzyt);
        mYaoYiYao = (Button) findViewById(R.id.yaoyiyao);
        marqueen = (Button) findViewById(R.id.marqueen);


        //第四行数据
        mPathUse = (Button) findViewById(R.id.pathuse);
        mBtnJinZhan = (Button) findViewById(R.id.jinzhan);
        mBtnRadio = (Button) findViewById(R.id.btn_radio);


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
        fontchange.setOnClickListener(this);
        customa.setOnClickListener(this);
        mAndroidH5.setOnClickListener(this);
        mTransToolbar.setOnClickListener(this);
        mChangeColor.setOnClickListener(this);
        mRadioChange.setOnClickListener(this);
        mProgressbar.setOnClickListener(this);
        mRecyclerView.setOnClickListener(this);
        mZyt.setOnClickListener(this);
        mYaoYiYao.setOnClickListener(this);
        mPinePic.setOnClickListener(this);
        mBtnQqList.setOnClickListener(this);
        mBtnRecyList.setOnClickListener(this);

        mPathUse.setOnClickListener(this);
        mBtnJinZhan.setOnClickListener(this);
        mBtnRadio.setOnClickListener(this);
        marqueen.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.marqueen:
                /**
                 * 第一个参数当前对象，第二个对象进入动画，第三个参数退出动画
                 */
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim
                        .fade_in, android.R.anim.fade_out);
                ActivityCompat.startActivity(this, new Intent(this, MarQueenActivity.class), compat.toBundle());
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
                ActivityOptionsCompat compat1 = ActivityOptionsCompat.makeScaleUpAnimation(mChangeColor, mChangeColor
                        .getWidth() / 2, mChangeColor.getHeight() / 2, 0, 0);
                ActivityCompat.startActivity(this,new Intent(this,
                    ChangeBgColor.class),compat1.toBundle());
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
            case R.id.yaoyiyao:
                startActivity(new Intent(this, YaoYiYaoActivity.class));
                break;
            case R.id.pinepic:
                startActivity(new Intent(this, PineViewActivity.class));
                break;
            case R.id.btn_qqlist:
                startActivity(new Intent(this, QQListDemoActivity.class));
                break;
            case R.id.btn_recylist:

                ActivityUtils.startActivityLeftOutRightIn(this, RecyclerViewMenuActivity.class);
                break;
            case R.id.pathuse:
                ActivityUtils.startActivityLeftOutRightIn(this, PathUseActivity.class);
                break;
            case R.id.jinzhan:
                ActivityUtils.startActivityLeftOutRightIn(this, DataIsMatchActivity.class);
                break;
            case R.id.btn_radio:
                ActivityUtils.startActivityLeftOutRightIn(this, RadioTest.class);
                break;
        }

    }
}
