package com.xin.xinprojectsdemo.customermenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.customattr.TypeDemo;

import java.util.ArrayList;
import java.util.List;

public class CustomerContentActivity extends AppCompatActivity {

    private CustomerMeunsView mCustomMenu;
    private List<ItemData> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_content);
        mCustomMenu = (CustomerMeunsView) findViewById(R.id.custom_menu);

        datas = new ArrayList<>();


        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa0"));
        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa1"));
        datas.add(new ItemData());
        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa2"));
        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa6", "desc"));
        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa3"));
        datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa4"));
        mCustomMenu.setDatas(datas);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas.clear();
                datas.add(new ItemData(R.mipmap.faxian, "test1", "dasfa0"));
                datas.add(new ItemData(R.mipmap.faxian, "test2", "dasfa1"));
                datas.add(new ItemData());


                datas.add(new ItemData(R.mipmap.faxian, "test1", "dasfa2"));

                datas.add(new ItemData(R.mipmap.faxian, "test1", "dasfa6", "dfdfd"));
                datas.add(new ItemData(R.mipmap.faxian, "test", "dasfa3"));
                datas.add(new ItemData(R.mipmap.faxian, "test1", "dasfa4"));
                datas.add(new ItemData(R.mipmap.faxian, "new add", "dasfa3"));
                datas.add(new ItemData(R.mipmap.faxian, "new add", "dasfa4"));
                mCustomMenu.setDatas(datas);
            }
        });
        mCustomMenu.setItemClickListener(new CustomerMeunsView.OnItemListener() {
            @Override
            public void itemClick(View v) {
                switch (((ItemData) v.getTag()).flag) {
                    case "dasfa0":
                        Toast.makeText(CustomerContentActivity.this, "hello", Toast.LENGTH_SHORT).show();
                        break;
                    case "dasfa1":
                        Toast.makeText(CustomerContentActivity.this, "world", Toast.LENGTH_SHORT).show();
                        break;
                    case "dasfa2":
                        startActivity(new Intent(getApplicationContext(), TypeDemo.class));
                        break;
                }
            }
        });


    }


}
