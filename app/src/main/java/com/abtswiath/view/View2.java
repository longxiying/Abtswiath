package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

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

    private int i = 20;

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "onDraw: ");
        switch (index) {
            case 0:
                pathLine(canvas);
                break;
            case 1:
                pathAddCircle(canvas);
                break;
        }
    }

    private void pathAddCircle(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        path.addCircle(0, 0, 40, Path.Direction.CW);
        canvas.drawPath(path, mPaint);              // 绘制Path
    }

    private void pathLine(Canvas canvas) {
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


    private int index = 0;

    public void change() {
        if (index > 2) {
            index = 0;
        } else {
            index++;
        }
        Log.e(TAG, "change: index=" + index);
        invalidate();
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
