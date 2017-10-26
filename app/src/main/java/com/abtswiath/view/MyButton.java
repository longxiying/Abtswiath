package com.abtswiath.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.abtswiath.R;

/**
 * Created by longx on 2017/10/26.
 */

public class MyButton extends View {

    private Paint mPaint;
    private int textColor;
    private float textSize;
    private int degeColor;
    private String text;

    public MyButton(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyButton);
        textColor = a.getColor(R.styleable.MyButton_textColor, 0XFFFFFFFF);
        textSize = a.getDimension(R.styleable.MyButton_textSize, 36);
        degeColor = a.getColor(R.styleable.MyButton_edgeColor, 0XFFFFFFFF);
        text = a.getString(R.styleable.MyButton_text);
        mPaint.setColor(degeColor);
        mPaint.setTextSize(textSize);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rectF, 10, 10, mPaint);
        mPaint.setColor(textColor);
        canvas.drawText(text, getWidth() / 2, getHeight() / 2, mPaint);
    }
}
