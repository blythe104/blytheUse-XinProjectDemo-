package com.xin.xinprojectsdemo.dslc;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class ProgressBarActivity extends BaseActivity {


    private static final int UPDATE = 1;
    private static final long SPLASH_DELAY_MILLIS = 3000;
    private int progress = 50;
    private int i = 1;
    private View mViewLine;
    private View mViewLine2;
    private ImageView mIv;
    private TextView mTv;

    @Override
    public void initView() {
        setContentView(R.layout.activity_progress_bar);
        mViewLine = findViewById(R.id.view_line);
        mViewLine2 = findViewById(R.id.view_line2);
        mTv = (TextView) findViewById(R.id.tv);
        mIv = (ImageView) findViewById(R.id.iv);
        int i = 0;

        TranslateAnimation translateAnimation = new TranslateAnimation(-1000, 0, 0, 0);
        translateAnimation.setDuration(5000);
        mViewLine.startAnimation(translateAnimation);
        TranslateAnimation translateAnimationiv = new TranslateAnimation(0, 1000, 0, 0);
        translateAnimationiv.setDuration(5000);
        mIv.startAnimation(translateAnimationiv);
        for (i = 0; i < 100; i += 10) {
            mTv.setText(i + "%");
        }
        mTv.startAnimation(translateAnimationiv);

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
