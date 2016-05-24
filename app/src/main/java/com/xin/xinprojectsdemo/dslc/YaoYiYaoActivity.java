package com.xin.xinprojectsdemo.dslc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;

import java.util.Random;

public class YaoYiYaoActivity extends AppCompatActivity implements SensorEventListener {

    private Button mBtnyyy;
    private TextView mTvtext;
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_yiyao);
        mTvtext = (TextView) findViewById(R.id.tv_text);
        mBtnyyy = (Button) findViewById(R.id.btn_yyy);
        mPager = (ViewPager) findViewById(R.id.pager);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }


    /**
     * 随机生成的图片
     */
    private void getadapterYourPic() {
        Random random = new Random();
        int num = random.nextInt(10);
        num += 1;
        if (num > 0 && num < 3) {
            mPager.setBackgroundResource(R.mipmap.ic_launcher);
        } else if (num >= 3 && num < 5) {
            mPager.setBackgroundResource(R.mipmap.jx_hotsell);
        } else if (num >= 5 && num < 8) {
            mPager.setBackgroundResource(R.mipmap.faxian);
        } else {
            mPager.setBackgroundResource(R.mipmap.dazhuanpan);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float[] values = event.values;
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {
            if ((Math.abs(values[0]) > 17 || Math.abs(values[1]) > 17 || Math.abs(values[2]) > 17)) {
                mTvtext.setText("success");
                //                getInvestPicFromNet();
                getadapterYourPic();
                vibrator.vibrate(500);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
