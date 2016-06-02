package com.xin.xinprojectsdemo.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;
import com.xin.xinprojectsdemo.view.QQListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QQListDemoActivity extends BaseActivity {

    private QQListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mDatas;

    @Override
    public void initView() {
        setContentView(R.layout.activity_qqlist_demo);
        mListView = (QQListView) findViewById(R.id.listview);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        // 不要直接Arrays.asList
        mDatas = new ArrayList<String>(Arrays.asList("HelloWorld", "Welcome", "Java", "Android", "Servlet", "Struts",
                "Hibernate", "Spring", "HTML5", "Javascript", "Lucene"));
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas);
        mListView.setAdapter(mAdapter);
        mListView.setDelButtonClickListener(new QQListView.DelButtonClickListener() {
            @Override
            public void clickHappend(int position) {
                Toast.makeText(QQListDemoActivity.this, position + " : " + mAdapter.getItem(position),Toast.LENGTH_SHORT).show();
                mAdapter.remove(mAdapter.getItem(position));

            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(QQListDemoActivity.this, position + " : " + mAdapter.getItem(position),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void processClick(View v) {

    }
}
