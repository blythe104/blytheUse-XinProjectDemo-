package com.xin.xinprojectsdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by xin on 2015/12/25.
 */
public class GuideAdapter extends PagerAdapter {

    private Context context;

    private ArrayList<ImageView> mGuideImgList;

    public GuideAdapter(Context context, ArrayList<ImageView> mGuideImgList) {
        this.context = context;
        this.mGuideImgList = mGuideImgList;
    }

    @Override
    public int getCount() {
        return mGuideImgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);

        ImageView imageView = mGuideImgList.get(position);
        container.addView(imageView);

        return imageView;
    }
}
