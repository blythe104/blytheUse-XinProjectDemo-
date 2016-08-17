package com.xin.xinprojectsdemo.pullrefresh;

import android.view.View;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.view.CustomPtrHeader;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class UltraUseActivity extends BaseActivity {

    private PtrFrameLayout ptrFrameLayout;

    @Override
    public void initView() {
        setContentView(R.layout.activity_ultra_use_demo);
        ptrFrameLayout = (PtrFrameLayout) findViewById(R.id.pfl_header);


        //        StoreHouseHeader header = new StoreHouseHeader(getApplicationContext());
        //        header.setPadding(0, DisplayUtil.dip2px(getApplicationContext(), 20), 0, DisplayUtil.dip2px
        //                (getApplicationContext(), 20));
        //        header.initWithString("Xin Test");
        //        header.setTextColor(Color.BLACK);
        //自定义头布局
        CustomPtrHeader header = new CustomPtrHeader(this);


        ptrFrameLayout.setDurationToCloseHeader(1500);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrameLayout.refreshComplete();
                    }
                }, 1500);

            }
        });


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
