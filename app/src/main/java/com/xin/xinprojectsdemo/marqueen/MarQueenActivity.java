package com.xin.xinprojectsdemo.marqueen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xin.xinprojectsdemo.MainActivity;
import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.utils.SharedPreferencesUtils;

/**
 * 文本内容的跑马灯效果
 */
public class MarQueenActivity extends AppCompatActivity implements View.OnClickListener {

    private MarqueenDemo mTvmarqueen;
    private RelativeLayout relativeLayout;
    private Button mBtnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar_queen);
        initTitleBar();
        mTvmarqueen = (MarqueenDemo) findViewById(R.id.tv_marqueen);
        ScrollTextView scrollview = (ScrollTextView) findViewById(R.id.scrollview);
        scrollview.setText("hello world this is hello world this is hello world this is hello world this is");
        scrollview.beginScroll();

        ScrollTextView scrollview2 = (ScrollTextView) findViewById(R.id.switcher2);
        scrollview2.setText("hello this is verical hello this is verical hello this is verical");
        scrollview2.beginScroll();
        mBtnText = (Button) findViewById(R.id.tv_text);

        int color = SharedPreferencesUtils.getInt(getApplicationContext(), "color", 0);
        if (color == 1) {
            mBtnText.setBackgroundColor(Color.GREEN);
        } else if (color == 2) {
            mBtnText.setBackgroundColor(Color.RED);
        } else if (color == 3) {
            mBtnText.setBackgroundColor(Color.GRAY);
        }
        scrollview.setOnClickListener(this);
        mTvmarqueen.setOnClickListener(this);
    }

    public void initTitleBar() {
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_titlebar);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("跑马灯效果");
        FrameLayout mFrback = (FrameLayout) findViewById(R.id.fr_back);
        mFrback.setVisibility(View.INVISIBLE);
        TextView mTitleTag = (TextView) findViewById(R.id.tv_title_tag);
        mTitleTag.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_marqueen:
                Intent intent = new Intent(MarQueenActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.scrollview:
                Intent intents = new Intent(MarQueenActivity.this, MainActivity.class);
                startActivity(intents);
                break;
        }

    }
}
