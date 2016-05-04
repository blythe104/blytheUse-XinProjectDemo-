package com.xin.xinprojectsdemo.customattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.xin.xinprojectsdemo.R;

/**
 * Created by xin on 2016/4/28 14:20.
 */
public class MyTextView extends View {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorTrackView);
        String text = typedArray.getString(R.styleable.ColorTrackView_text);
        typedArray.recycle();
    }
}
