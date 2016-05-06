package com.xin.xinprojectsdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xin.xinprojectsdemo.base.BaseFragment;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> mFragments;

    public MainPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
