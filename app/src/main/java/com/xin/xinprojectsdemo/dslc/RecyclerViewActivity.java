package com.xin.xinprojectsdemo.dslc;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class RecyclerViewActivity extends BaseActivity {


    private RecyclerView mRecycle;
    private LinearLayoutManager layoutManager;
    private MyAdapter myAdapter;


    @Override
    public void initView() {
        setContentView(R.layout.activity_recycler_view);
        mRecycle = (RecyclerView) findViewById(R.id.recy_view);
        layoutManager = new LinearLayoutManager(this);
        mRecycle.setLayoutManager(layoutManager);
        mRecycle.setHasFixedSize(true);
        String[] dataset = new String[10];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }
        myAdapter = new MyAdapter(dataset);
        mRecycle.setAdapter(myAdapter);


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

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public String[] datas = null;

        public MyAdapter(String[] datas) {
            this.datas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(datas[position]);

        }

        @Override
        public int getItemCount() {
            return datas.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mTextView = (TextView) view.findViewById(R.id.tv_text);
            }
        }
    }
}
