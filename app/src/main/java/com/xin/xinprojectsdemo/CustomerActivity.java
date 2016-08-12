package com.xin.xinprojectsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xin.xinprojectsdemo.citydemo.CityLikeTaobaoDemo;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCityLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        mCityLike = (Button) findViewById(R.id.citylike);
        mCityLike.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.citylike:
                startActivity(new Intent(this, CityLikeTaobaoDemo.class));
                break;
        }

    }
}
