package com.xin.xinprojectsdemo.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xin.xinprojectsdemo.R;

public class PathUseActivity extends AppCompatActivity implements View.OnClickListener {
    Canvas canvas;
    private Button mMoveto;
    private Button mLineto;
    private Button mQuadTo;
    private Button mCubicTo;
    private Button mArcTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_use);
        mMoveto = (Button) findViewById(R.id.moveto);
        mLineto = (Button) findViewById(R.id.lineto);
        mQuadTo = (Button) findViewById(R.id.quadTo);
        mCubicTo = (Button) findViewById(R.id.cubicTo);
        mArcTo = (Button) findViewById(R.id.arcTo);
        mMoveto.setOnClickListener(this);
        mLineto.setOnClickListener(this);
        mQuadTo.setOnClickListener(this);
        mCubicTo.setOnClickListener(this);
        mArcTo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moveto:
//                   mCustomView.pathShow(canvas, "moveto");
                break;
            case R.id.lineto:
                //  mCustomView.pathShow(canvas, "lineto");
                break;
            case R.id.quadTo:
                //   mCustomView.pathShow(canvas, "quadTo");
                break;
            case R.id.cubicTo:
                //  mCustomView.pathShow(canvas, "cubicTo");
                break;
            case R.id.arcTo:
                // mCustomView.pathShow(canvas, "arcTo");
                break;
        }

    }
}
