package com.xin.xinprojectsdemo.customermenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by xin on 2016/8/11.
 */
public class CustomerMeunsView extends LinearLayout {
    private OnItemListener listener;

    public CustomerMeunsView(Context context) {
        super(context);
        initView();
    }

    public CustomerMeunsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomerMeunsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(LinearLayout.VERTICAL);
    }

    public void setDatas(List<ItemData> datas) {
        if (getChildCount() == 0) {
            for (ItemData item : datas) {
                if (item.content == null) {
                    LinearLayout ll = new LinearLayout(getContext());
                    ll.setMinimumHeight(30);
                    addView(ll);
                } else {
                    createItemView(item);
                }
            }
        } else {

            for (int index = 0; index < getChildCount(); index++) {
                LinearLayout childView = (LinearLayout) getChildAt(index);
                if (childView instanceof MenuMixContorl) {
                    MenuMixContorl menuChildView = (MenuMixContorl) childView;
                    menuChildView.setData(datas.get(index));
                }
            }
            if (datas.size() != getChildCount()) {
                for (int index = getChildCount(); index < datas.size(); index++) {
                    createItemView(datas.get(index));
                }
            }
        }

    }

    private void createItemView(ItemData item) {
        MenuMixContorl menuMixContorl = new MenuMixContorl(getContext());
        menuMixContorl.setData(item);
        addView(menuMixContorl);
        menuMixContorl.setTag(item);
        menuMixContorl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(v);
                }
            }
        });// end listener
    }

    public void setItemClickListener(OnItemListener listener) {
        this.listener = listener;
    }

    public interface OnItemListener {
        void itemClick(View v);
    }
}
