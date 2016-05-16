package com.xin.xinprojectsdemo.dslc;

import android.view.View;
import android.widget.RadioGroup;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class RadioButtonMoreStyle extends BaseActivity {


    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private boolean changeedGroup = false;

    @Override
    public void initView() {
        setContentView(R.layout.activity_radio_button_more_style);
        radioGroup1 = (RadioGroup) findViewById(R.id.orderBy1);
        radioGroup1.setOnCheckedChangeListener(new MyRadioGroupOnCheckedChangedListener());
        radioGroup2 = (RadioGroup) findViewById(R.id.orderBy2);
        radioGroup2.setOnCheckedChangeListener(new MyRadioGroupOnCheckedChangedListener());
        radioGroup3 = (RadioGroup) findViewById(R.id.orderBy3);
        radioGroup3.setOnCheckedChangeListener(new MyRadioGroupOnCheckedChangedListener());

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

    private class MyRadioGroupOnCheckedChangedListener implements RadioGroup.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (!changeedGroup) {
                changeedGroup = true;
                if (group == radioGroup1) {
                    radioGroup2.clearCheck();
                    radioGroup3.clearCheck();
                } else if (group == radioGroup2) {
                    radioGroup1.clearCheck();
                    radioGroup3.clearCheck();
                } else if (group == radioGroup3) {
                    radioGroup1.clearCheck();
                    radioGroup2.clearCheck();
                }
                changeedGroup = false;
            }
        }
    }
}
