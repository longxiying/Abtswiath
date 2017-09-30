package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by longx on 2017/9/30.
 */

public class View1 extends BaseView {

    private static final String TAG = "View1";

    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawPoint(200, 200, mPaint);     //在坐标(200,200)位置绘制一个点
        int width = getWidth();
        Log.e(TAG, "width:" + width);
        for (int i = 10; i < width; i = i + 20) {
            Log.e(TAG, "i:" + i);
            canvas.drawPoint(i, 10, mPaint);
        }
        canvas.drawLine(5, 30, width, 30, mPaint);

        mPaint.setTextSize(60f);
        canvas.drawText("囖龍齉龘靐蠿", 5, 90, mPaint);


        canvas.drawRect(5,100,width,200,mPaint);


    }

    public void setPaintFlags(int flags) {
        mPaint.setFlags(flags);
        this.invalidate();
    }

}
