package com.xin.xinprojectsdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by xin on 2016/8/16.
 * 自定义下拉刷新效果
 */
public class CustomPtrHeader extends FrameLayout implements PtrUIHandler {

    private ImageView headerImg;
    private TextView headerTitle;
    private LayoutInflater inflater;
    private ViewGroup headerView;

    public CustomPtrHeader(Context context) {
        super(context);
        initView(context);

    }

    public CustomPtrHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomPtrHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化布局
     */
    private void initView(Context context) {
        inflater=LayoutInflater.from(context);
        headerView = (ViewGroup) inflater.inflate(R.layout.customer_ptr_header, this,true);
        headerImg = (ImageView) headerView.findViewById(R.id.iv_header);
        headerTitle = (TextView) headerView.findViewById(R.id.tv_header);
        headerImg.setVisibility(VISIBLE);
        headerImg.setImageResource(R.mipmap.wb_search_icon);
        headerTitle.setText("下拉刷新...");

    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {
        headerTitle.setText("下拉刷新...");

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        headerTitle.setText("下拉刷新...");

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        headerTitle.setText("正在刷新...");

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        headerTitle.setText("刷新完成...");

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        final int mOffsetToRefresh = frame.getOffsetToRefresh();
        final int currentPos = ptrIndicator.getCurrentPosY();
        final int lastPos = ptrIndicator.getLastPosY();
        if (currentPos < mOffsetToRefresh && lastPos >= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                headerTitle.setText("下拉刷新...");
            }
        } else if (currentPos > mOffsetToRefresh && lastPos <= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                headerTitle.setText("松开刷新...");
            }
        }
    }
}
