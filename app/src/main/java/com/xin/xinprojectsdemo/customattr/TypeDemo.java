package com.xin.xinprojectsdemo.customattr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xin.xinprojectsdemo.MainActivity;
import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.adapter.GuideAdapter;

import java.util.ArrayList;

public class TypeDemo extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewpager;
    private TextView mTvLookDetail;
    private int[] mImageIds = new int[]{R.mipmap.pagerone, R.mipmap.pagertwo};
    private ArrayList<ImageView> mGuideImgList;
    private int currentPageScrollStatus;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_demo);

        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTvLookDetail = (TextView) findViewById(R.id.tv_lookDetail);
        mTvLookDetail.setOnClickListener(this);
        // 初始化mList
        mGuideImgList = new ArrayList<ImageView>();
        // 初始化引导图
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mGuideImgList.add(view);

        }
        mViewpager.setAdapter(new GuideAdapter(getApplication(), mGuideImgList));
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == mImageIds.length - 1) {
                    if (positionOffsetPixels == 0 && currentPageScrollStatus == 1) {
                        if (count == 0) {
                            overridePendingTransition(R.anim.in_to_left, R.anim.out_to_right);
                            mTvLookDetail.setVisibility(View.VISIBLE);
                            startActivity(new Intent(TypeDemo.this, MainActivity.class));
                        }
                    }

                } else {
                    mTvLookDetail.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                currentPageScrollStatus = state;

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_lookDetail:
                startActivity(new Intent(TypeDemo.this, MainActivity.class));
                break;
        }

    }
}
