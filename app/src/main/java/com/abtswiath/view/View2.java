package com.abtswiath.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.abtswiath.R;

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
        mPaint.setColor(getResources().getColor(R.color.holo_blue_dark));           // 画笔颜色 - 黑色
        mPaint.setTextSize(36);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("index：" + index, 20, 56, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        switch (index) {
            case 0:
                pathLine(canvas);
                break;
            case 1:
                pathAddCircle(canvas);
                break;
            case 2:
                pathAddOval(canvas);
                break;
            case 3:
                pathAddRect(canvas);
                break;
            case 4:
                path1(canvas);
                break;
            case 5:
                path2(canvas);
                break;
            case 6:
                path3(canvas);
                break;
            case 7:
                path4(canvas);
                break;
            case 8:
                path5(canvas);
                break;
        }
    }

    private void path5(Canvas canvas) {
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴
        Path path = new Path();                     // path中添加一个圆形(圆心在坐标原点)
        path.addCircle(0, 0, 100, Path.Direction.CW);
        Path dst = new Path();                      // dst中添加一个矩形
        dst.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.offset(300, 0, dst);                     // 平移
        canvas.drawPath(path, mPaint);               // 绘制path
        mPaint.setColor(Color.BLUE);                // 更改画笔颜色
        canvas.drawPath(dst, mPaint);                // 绘制dst
    }

    private void path4(Canvas canvas) {
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴
        Path path = new Path();                     // path添加一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        Path src = new Path();                      // src添加一个圆
        src.addCircle(0, 0, 100, Path.Direction.CW);
        path.set(src);                              // 大致相当于 path = src;
        canvas.drawPath(path, mPaint);
    }

    private void path3(Canvas canvas) {
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴
        Path path = new Path();
        path.lineTo(100, 100);
        RectF oval = new RectF(0, 0, 300, 300);
        path.arcTo(oval, 0, 270);
        // path.arcTo(oval,0,270,false);             // <-- 和上面一句作用等价
        canvas.drawPath(path, mPaint);
    }

    private void path2(Canvas canvas) {
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴
        Path path = new Path();
        path.lineTo(100, 100);
        RectF oval = new RectF(0, 0, 300, 300);
        path.addArc(oval, 90, 180);
        // path.arcTo(oval,0,270,true);             // <-- 和上面一句作用等价
        canvas.drawPath(path, mPaint);
    }

    private void path1(Canvas canvas) {
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴
        Path path = new Path();
        Path src = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        src.addCircle(0, 0, 100, Path.Direction.CW);
        path.addPath(src, 0, 200);
        mPaint.setColor(Color.BLACK);           // 绘制合并后的路径
        canvas.drawPath(path, mPaint);
    }

    private void pathAddRect(Canvas canvas) {
        Path path = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.setLastPoint(-300, 300);
        canvas.drawPath(path, mPaint);
    }

    private void pathAddOval(Canvas canvas) {
        canvas.translate(50, 50);
        Path path = new Path();
        path.addOval(0, 0, 200, 400, Path.Direction.CW);
        canvas.drawPath(path, mPaint);
    }

    private void pathAddCircle(Canvas canvas) {
        Path path = new Path();
        path.addCircle(-80, 0, 80, Path.Direction.CW);
        path.addCircle(0, 0, 80, Path.Direction.CW);
        path.addCircle(80, 0, 80, Path.Direction.CW);
        path.addCircle(-40, 80, 80, Path.Direction.CW);
        path.addCircle(40, 80, 80, Path.Direction.CW);
        canvas.drawPath(path, mPaint);              // 绘制Path
    }

    private void pathLine(Canvas canvas) {
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
        if (index > 7) {
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
        if (index != 0) {
            return true;
        }
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
