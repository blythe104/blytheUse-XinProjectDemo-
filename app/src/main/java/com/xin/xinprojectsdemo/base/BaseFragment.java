package com.xin.xinprojectsdemo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xin on 2016/5/4 17:32.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private boolean isVisible;// fragment对用户是否可见
    private boolean isPrepared;// 标志位，标记已经初始化完成。
    private boolean hasLoadOnce;// 标志位，标记是否已经加载过一次数据，第二次就不要再加载数据了。
    private View mRootView;


    /**
     * 获取是否加载过一次数据
     */
    protected boolean isHasLoadOnce() {
        return hasLoadOnce;
    }

    /**
     * 设置是否只加载一次数据
     */
    protected void setHasLoadOnce(boolean hasLoadOnce) {
        this.hasLoadOnce = hasLoadOnce;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (null != mRootView) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = initView(inflater, container, savedInstanceState);
        }
        isPrepared = true;
        onVisibleData();
        return mRootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListener();
        initData();
    }


    public abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public abstract void initListener();

    public void initData() {
    }

    public abstract void processClick(View v);

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisibleData();
        } else {
            isVisible = false;
        }
    }


    /**
     * 对用户可见时加载数据
     */
    protected void onVisibleData() {
        // 布局未初始化好或不可见状态，不加载数据
        if (!isPrepared || !isVisible) {
            return;
        }
        // 已经加载过一次数据，不再加载数据
        if (hasLoadOnce) {
            return;
        }
        OnLazyLoadData();
    }

    /**
     * fragment对用户可见时加载数据,并可设置是否只加载一次
     */
    protected void OnLazyLoadData() {
    }
}

