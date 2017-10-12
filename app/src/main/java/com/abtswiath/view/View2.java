package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Created by longx on 2017/10/12.
 */

public class View2 extends BaseView {
    public View2(Context context) {
        super(context);
    }

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path = new Path();
        int i = 20;
        while (i < 300) {
            path.moveTo(0, i);
            path.lineTo(i, 0);
            path.lineTo(0, -i);
            path.lineTo(-i, 0);
            path.close();
            i = i + 20;
        }
        canvas.drawPath(path, mPaint);              // 绘制Path

    }
}
