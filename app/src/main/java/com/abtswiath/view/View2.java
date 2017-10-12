package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by longx on 2017/10/12.
 */

public class View2 extends BaseView {

    private static final String TAG = "View2";

    public View2(Context context) {
        super(context);
    }

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int i = 20;

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        while (i < 300) {
            path.moveTo(0, i);
            path.lineTo(i, 0);
            path.lineTo(0, -i);
            path.lineTo(-i, 0);
            path.close();
            i = i + j;
        }
        canvas.drawPath(path, mPaint);              // 绘制Path
    }


    private int j = 20;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                i = (rawX + 3) / 3;
                if (j == i) {
                    return true;
                }
                j = i;
                Log.e(TAG, "rawX: " + rawX + "rawY：" + rawY);

                invalidate();
                break;
        }
        return true;
    }
}
