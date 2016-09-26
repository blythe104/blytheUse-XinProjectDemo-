package com.xin.xinprojectsdemo.job;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class TouchDemoActivity extends BaseActivity {


    private Button mBtnTest;
    private FragmentManager manager;
    private LinearLayout left_fragment;
    private FragmentTransaction transaction;

    @Override
    public void initView() {
        setContentView(R.layout.activity_touch_demo);
        mBtnTest = (Button) findViewById(R.id.btn_test);
        left_fragment = (LinearLayout) findViewById(R.id.left_fragment);
        final LeftFragment leftFragment = new LeftFragment();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.left_fragment, leftFragment, "left");
        transaction.commit();
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftFragment.getEditText(new LeftFragment.CallBacka() {
                    @Override
                    public void getResult(String msg) {
                        Toast.makeText(TouchDemoActivity.this, msg, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
        //        mBtnTest.setOnTouchListener(new View.OnTouchListener() {
        //            @Override
        //            public boolean onTouch(View v, MotionEvent event) {
        //                return false;
        //            }
        //        });
        //        mBtnTest.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast.makeText(TouchDemoActivity.this, "hello this is onclick thing", Toast.LENGTH_SHORT)
        // .show();
        //            }
        //        });
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
