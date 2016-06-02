package com.xin.xinprojectsdemo.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.adapter.CategoryAdapter;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.bean.Category;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMenuActivity extends BaseActivity {
    List<Category> lists = new ArrayList<>();
    private CategoryAdapter adapter;
    private RecyclerView mRecyView;
    private GridLayoutManager layoutManager;


    @Override
    public void initView() {
        setContentView(R.layout.activity_recycler_view_menu);
        mRecyView = (RecyclerView) findViewById(R.id.recy_view);
        adapter = new CategoryAdapter(this, lists);
        layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case Category.SECOND_TYPE:
                        return 3;
                    case Category.THIRD_TYPE:
                        return 1;
                    default:
                        return 1;
                }
            }
        });
        mRecyView.setLayoutManager(layoutManager);
        mRecyView.setAdapter(adapter);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        lists.add(new Category("饼干", 0));
        lists.add(new Category("奶油饼干", 1));
        lists.add(new Category("威化", 1));
        lists.add(new Category("曲奇", 1));
        lists.add(new Category("传统糕点", 0));
        lists.add(new Category("凤梨酥", 1));
        lists.add(new Category("杏仁饼", 1));
        lists.add(new Category("烧饼", 1));
        lists.add(new Category("花生酥", 1));
        lists.add(new Category("西式糕点", 0));
        lists.add(new Category("巧克力派", 1));
        lists.add(new Category("酥心卷", 1));
        lists.add(new Category("面包", 1));
        lists.add(new Category("泡芙", 1));
        lists.add(new Category("蛋挞", 1));

    }

    @Override
    public void processClick(View v) {

    }
}
