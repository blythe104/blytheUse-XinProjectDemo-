package com.xin.xinprojectsdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by xin on 2016/6/12.
 */
public class CustomerPathView extends View {

    public Path mPath;
    public Paint mPaint;
    public Canvas canvas;
    public String btnname;

    public CustomerPathView(Context context) {
        super(context);
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pathShow(canvas,btnname);
    }

    public void pathShow(Canvas canvas, String btnname) {
        switch (btnname) {
            case "moveto":
                mPath.moveTo(100, 100);
                canvas.drawPath(mPath, mPaint);
                break;
            case "lineto":
                mPath.moveTo(100, 200);
                mPath.lineTo(300, 500);
                canvas.drawPath(mPath, mPaint);
                break;
            case "quadTo":
                mPath.moveTo(100, 300);
                mPath.quadTo(300, 300, 500, 600);
                canvas.drawPath(mPath, mPaint);
                break;
            case "cubicTo":
                mPath.moveTo(100, 300);
                mPath.cubicTo(100, 100, 300, 300, 500, 600);
                canvas.drawPath(mPath, mPaint);
                break;
            case "arcTo":
                RectF mrect = new RectF(10, 10, 600, 600);
                mPath.arcTo(mrect, 0, 150);
                mPath.moveTo(100, 300);
                canvas.drawPath(mPath, mPaint);
                break;
        }
    }
}
