package com.example.eric.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Eric on 2015/11/5.
 */
public class Darw extends View {

    private float currentX = 300;

    private float currentY = 500;

    private Paint paint = new Paint();

    public Darw(Context context) {
        super(context);
    }

    public Darw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Darw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Darw(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(currentX, currentY, 15, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }
}
