package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.abtswiath.R;

/**
 * Created by longx on 2017/9/30.
 */

public abstract class BaseView extends View {

    protected Paint mPaint;

    public BaseView(Context context) {
        super(context);
        initPaint();
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    protected void initPaint() {
        mPaint = new Paint();                   // 创建画笔
        mPaint.setColor(getResources().getColor(R.color.holo_blue_dark));           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
