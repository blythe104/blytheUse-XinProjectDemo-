package com.xin.xinprojectsdemo.dslc;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.adapter.MainPagerAdapter;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.base.BaseFragment;

import java.util.ArrayList;

public class DSLCMainActivity extends BaseActivity {


    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRBtJX;
    private RadioButton mRBtLC;
    private RadioButton mRBtMine;
    private RadioButton mRBtFaxian;
    private int currentPagePositon;
    private ArrayList<BaseFragment> mFragments;

    @Override
    public void initView() {
        setContentView(R.layout.activity_dslcmain);
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_group);
        mRBtJX = (RadioButton) findViewById(R.id.rb_jx);
        mRBtLC = (RadioButton) findViewById(R.id.rb_lc);
        mRBtMine = (RadioButton) findViewById(R.id.rb_mine);
        mRBtFaxian = (RadioButton) findViewById(R.id.rb_faxian);

    }

    @Override
    public void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_jx:
                        currentPagePositon = 0;
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_lc:
                        currentPagePositon = 1;
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_mine:
                        mViewPager.setCurrentItem(2, false);
                        break;

                    case R.id.rb_faxian:
                        currentPagePositon = 3;
                        mViewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1000:
                if (data != null) {
                    mRadioGroup.check(R.id.rb_mine);
                } else {
                    switch (currentPagePositon) {
                        case 0:
                            mRadioGroup.check(R.id.rb_jx);
                            break;
                        case 1:
                            mRadioGroup.check(R.id.rb_lc);
                            break;
                        case 2:
                            mRadioGroup.check(R.id.rb_faxian);
                            break;
                        case 3:
                            mRadioGroup.check(R.id.rb_mine);
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<BaseFragment>();

//        mFragments.add(new MineActivity());
        //todo 2016-03-14
        //        mFragments.add(new MoreFragment());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragments));
        int tzID = getIntent().getIntExtra("tzID", 0);
        if (tzID == 1) {
            mRadioGroup.check(R.id.rb_lc);
            mViewPager.setCurrentItem(1);
        } else if (tzID == 2) {
            mRadioGroup.check(R.id.rb_mine);
            mViewPager.setCurrentItem(2);

        } /*else if (tzID == 5) {
            mRadioGroup.check(R.id.rb_lc);
            mViewPager.setCurrentItem(1);
        }*/

    }

    @Override
    public void processClick(View v) {

    }
}
