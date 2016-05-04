package com.xin.xinprojectsdemo.marqueen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueenDemo extends TextView {

    public MarqueenDemo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public MarqueenDemo(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MarqueenDemo(Context context) {
        super(context);

    }

    @Override
    public boolean isFocused() {
        return true;
    }

}
