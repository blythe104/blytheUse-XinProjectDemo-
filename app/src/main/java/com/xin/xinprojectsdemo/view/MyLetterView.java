package com.xin.xinprojectsdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xin on 2016/8/12.
 */
public class MyLetterView extends View {

    private boolean isShowBg = false;
    private int choose = -1;// 用于标记当前所选中的位置
    private TextView mTvDialog;//用于接受从activity中传过来的，中间用于展示字母的textView
    private OnSlidingListener mOnSlidingListener;// 滑动此View的监听器
    //定义搜索的字段集合
    private String[] letter = {"定位", "最近", "热门", "全部", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M",
            "N", "P", "Q", "R", "S", "T", "W", "X", "Y", "Z"};
    private Paint mPaint;

    public MyLetterView(Context context) {
        super(context);
    }

    public MyLetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyLetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化画笔
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(25);
    }

    //重写onDraw方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //判断是否展示背景
        if (isShowBg) {
            canvas.drawColor(Color.parseColor("#40000000"));
        }
        //计算字符的高度
        float singleHeight = getHeight() / letter.length;
        int width = getWidth();
        for (int i = 0; i < letter.length; i++) {
            String text = letter[i];
            float xPosition = width / 2 - mPaint.measureText(text) / 2;
            float yPositon = singleHeight * i + singleHeight;
            canvas.drawText(text, xPosition, yPositon, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int position = (int) (event.getY() / getHeight() * letter.length);
        int oldChoose = choose;
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                isShowBg=true;
                if (oldChoose!=position&&mOnSlidingListener!=null)
                {
                    if(position>0&&position<letter.length)
                    {
                        //将滑动的字母传递到activity
                        mOnSlidingListener.sliding(letter[position]);
                        choose=position;
                        if(mTvDialog!=null)
                        {
                           mTvDialog.setVisibility(VISIBLE);
                            mTvDialog.setText(letter[position]);
                        }
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                isShowBg=true;
                if(oldChoose!=position&&mOnSlidingListener!=null)
                {
                    if(position>=0&&position<letter.length)
                    {
                        mOnSlidingListener.sliding(letter[position]);
                        choose=position;
                        if(mTvDialog!=null)
                        {
                            mTvDialog.setVisibility(VISIBLE);
                            mTvDialog.setText(letter[position]);
                        }
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                isShowBg=false;
                choose=-1;
                if(mTvDialog!=null)
                {
                    mTvDialog.setVisibility(GONE);
                }
                invalidate();
                break;
        }

        return super.onTouchEvent(event);
    }

    //MyLetterView的一个滑动的监听
    public void setOnSlidingListener(OnSlidingListener mOnSlidingListener) {
        this.mOnSlidingListener = mOnSlidingListener;
    }

    public interface OnSlidingListener {
        public void sliding(String str);
    }

    public void setTextView(TextView tvDialog) {
        mTvDialog=tvDialog;
    }
}
