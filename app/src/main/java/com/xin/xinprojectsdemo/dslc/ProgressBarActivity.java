package com.xin.xinprojectsdemo.dslc;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class ProgressBarActivity extends BaseActivity {


    private static final int UPDATE = 1;
    private static final long SPLASH_DELAY_MILLIS = 3000;
    private int progress = 50;
    private TextView mTv;
    private ProgressBar mPb;
    private int i = 1;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //                case UPDATE:
                //                    mPb.setProgress(i);
                //                    mTv.setText(i + "");
                //                    i += 2;
                //                    break;
            }
        }
    };

    @Override
    public void initView() {
        setContentView(R.layout.activity_progress_bar);
        mPb = (ProgressBar) findViewById(R.id.pb);
        mTv = (TextView) findViewById(R.id.tv);
        mPb.setMax(100);
        mTv.setText(i + "");
        mPb.setProgress(0);
        mPb.incrementProgressBy(10);

        //        while (i < progress) {
        //            mHandler.sendEmptyMessage(UPDATE);
        //            mHandler.sendEmptyMessageDelayed(UPDATE, SPLASH_DELAY_MILLIS);
        //        }

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
