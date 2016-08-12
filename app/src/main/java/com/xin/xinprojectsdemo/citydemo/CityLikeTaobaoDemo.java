package com.xin.xinprojectsdemo.citydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.view.MyLetterView;

public class CityLikeTaobaoDemo extends AppCompatActivity {

    private MyLetterView letterview;
    private TextView mTvDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_like_taobao_demo);
        letterview = (MyLetterView) findViewById(R.id.letter_view);
        mTvDialog = (TextView) findViewById(R.id.tv_dialog);
        letterview.setTextView(mTvDialog);
        letterview.setOnSlidingListener(new MyLetterView.OnSlidingListener() {
            @Override
            public void sliding(String str) {
            mTvDialog.setText(str);
            }
        });

    }
}
