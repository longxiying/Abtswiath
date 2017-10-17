package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.abtswiath.R;

/**
 * Created by longx on 2017/10/17.
 */

public class MyViewProgress extends View {


    private static final String TAG = "MyViewProgress";
    private Paint mPaint;

    private int color = R.color.colorAccent;

    private int centerX, centerY;//中心点的X,Y坐标

    private int w, h;//控件的宽跟高

    private int radius;//半径

    private float progress = 0;

    private int lineW = 10;

    public MyViewProgress(Context context) {
        super(context);
        init();
    }

    public MyViewProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyViewProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        this.w = w;
        this.h = h;
        if (w > h) {
            radius = h / 2;
        } else {
            radius = w / 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStrokeWidth(lineW);
        mPaint.setColor(getResources().getColor(color));//设置进度条的颜色
        canvas.translate(centerX, centerY);//将坐标移动到画布的中央
        RectF oval = new RectF(0, 0, radius - lineW, radius - lineW);
        Path path = new Path();
        Log.e(TAG, "onDraw: progress===" + progress);
        float jiao = (progress / 100) * 360;
        Log.e(TAG, "onDraw:jiao==== " + jiao);
        path.addArc(oval, 0, jiao);
        canvas.drawPath(path, mPaint);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setLineW(int lineW) {
        this.lineW = lineW;
        invalidate();
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }
}
