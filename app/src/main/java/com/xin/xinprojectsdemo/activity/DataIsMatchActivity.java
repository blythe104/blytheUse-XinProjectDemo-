package com.xin.xinprojectsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;

import java.util.Stack;

public class DataIsMatchActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEtString;
    private Button mBtnShow;
    private TextView mTvShow;
    private String testS;
    private Stack<String> mStack1;
    private Stack<String> mStack2;
    private Stack<String> mStack3;
    private int size1 = 0;
    private int size2 = 0;
    private int size3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_is_match);
        mEtString = (EditText) findViewById(R.id.et_string);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvShow = (TextView) findViewById(R.id.tv_show);

        mBtnShow.setOnClickListener(this);
        mStack1 = new Stack<String>();
        mStack2 = new Stack<String>();
        mStack3 = new Stack<String>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                testS = mEtString.getText().toString().trim();
                if (testS.equals("")) {
                    mTvShow.setText("输入数据为空！");
                } else {
                    isMatch(testS);
                    if (size1 >= 0) {
                        Toast.makeText(this, "大括号匹配成功的对数为:" + size1, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "大括号匹配失败", Toast.LENGTH_SHORT).show();
                    }
                    if (size2 >= 0) {
                        Toast.makeText(this, "中括号匹配成功的个数为:" + size2, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "中括号匹配失败", Toast.LENGTH_SHORT).show();
                    }
                    if (size3 >= 0) {
                        Toast.makeText(this, "小括号匹配成功的个数为:" + size3, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "小括号匹配失败", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }

    private void isMatch(String testS) {
        for (int i = 0; i < testS.length(); i++) {
            if (testS.charAt(i) == '{') {
                mStack1.push(String.valueOf(testS.charAt(i)));
            } else if (testS.charAt(i) == '}') {
                if (!mStack1.empty()) {
                    mStack1.pop();
                    size1++;
                }
            }
            if (testS.charAt(i) == '[') {
                mStack2.push(String.valueOf(testS.charAt(i)));
            } else if (testS.charAt(i) == ']') {
                if (!mStack2.empty()) {
                    mStack2.pop();
                    size2++;
                }
            }
            if (testS.charAt(i) == '(') {
                mStack3.push(String.valueOf(testS.charAt(i)));
            } else if (testS.charAt(i) == ')') {
                if (!mStack3.empty()) {
                    mStack3.pop();
                    size3++;
                }
            }
        }
    }
}
