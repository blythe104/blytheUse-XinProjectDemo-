package com.xin.xinprojectsdemo.job;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.xin.xinprojectsdemo.R;

/**
 * Created by xin on 2016/9/18.
 */
public class CustomTimeCount extends View implements View.OnClickListener {

    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private int mCount;
    private Rect mBounds;

    public CustomTimeCount(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBounds = new Rect();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomLearn, defStyleAttr, 0);
        mText = array.getString(R.styleable.CustomLearn_custometext);
        mTextColor = array.getColor(R.styleable.CustomLearn_textColor, getResources().getColor(R.color.BtnColor));
        array.recycle();
        setOnClickListener(this);
    }

    public CustomTimeCount(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTimeCount(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mTextPaint);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(100);
        mTextPaint.setColor(getmTextColor());
        String mText = String.valueOf(mCount);
        mTextPaint.getTextBounds(mText, 0, mText.length(), mBounds);
        canvas.drawText(mText, 100, 100, mTextPaint);
    }


    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();

    }
}
