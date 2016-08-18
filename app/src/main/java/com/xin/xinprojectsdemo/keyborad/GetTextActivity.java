package com.xin.xinprojectsdemo.keyborad;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class GetTextActivity extends BaseActivity {


    private TextView mTvText;

    @Override
    public void initView() {
        setContentView(R.layout.activity_get_text);
        mTvText = (TextView) findViewById(R.id.tv_gettext);
        String mtext = getIntent().getStringExtra("text");
        Toast.makeText(this, mtext, Toast.LENGTH_SHORT).show();
        mTvText.setText(mtext);

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
