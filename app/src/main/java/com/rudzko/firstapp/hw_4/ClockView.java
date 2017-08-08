package com.rudzko.firstapp.hw_4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.rudzko.firstapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */

public class ClockView extends View{

    private Paint myPaint = new Paint();
    private String time[] = {"12", " 3", " 6 ", "9 "};
    Rect textRect = new Rect();
    float centerX;
    float centerY;
    String currentTime;
    float angle;
    int rad;
    Canvas canvas;
    Thread thread;

    public ClockView(Context context) {
        super(context);
        settings();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        settings();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        settings();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        settings();
    }

    private void settings() {
        myPaint.setAntiAlias(true);
        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setTextSize(100);
        Resources r = getResources();
        float strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        rad = (Math.min((int) centerX, (int) centerY));
        canvas.drawCircle(centerX, centerY, rad - 4, myPaint);
        float[] center12 = getCenter(time[0]);
        canvas.drawText(time[0], centerX - (center12[0]), centerY - rad + center12[1] * 2 + 55, myPaint);
        float[] center3 = getCenter(time[1]);
        canvas.drawText(time[1], centerX + rad - (center3[0] * 2) - 55, centerY + center3[1], myPaint);
        float[] center6 = getCenter(time[2]);
        canvas.drawText(time[2], centerX - (center6[0]), centerY + rad - 55, myPaint);
        float[] center9 = getCenter(time[3]);
        canvas.drawText(time[3], centerX - rad + 55, centerY + center9[1], myPaint);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.skyblue));
        for (int i = 0; i < 60; i++) {
            int size = 5;
            if (i % 15 == 0) size = 15;
            else if (i % 5 == 0) size = 10;
            canvas.drawCircle(centerX, centerY - rad + 30, size, myPaint);
            canvas.rotate(6, centerX, centerY);
        }
//        askTime();
//        countAngle();
    }

    private float[] getCenter(String s) {
        float[] points = new float[2];
        points[0] = myPaint.measureText(s) / 2;
        myPaint.getTextBounds(s, 0, time[0].length(), textRect);
        points[1] = textRect.height() / 2;
        return points;
    }

    public void countAngle(){
        int hours = Integer.valueOf(currentTime.substring(0, 2));
        int min = Integer.valueOf(currentTime.substring(3, 5));
        int sec = Integer.valueOf(currentTime.substring(6));
        for (int i = 0; i < hours; i++) {
            canvas.rotate(30, centerX, centerY);
            angle += 30;
        }
        for (int y = 0; y < min; y++) {
            canvas.rotate(0.5f, centerX, centerY);
            angle += 0.5f;
        }
        for (int z=0; z<sec; z++){
            canvas.rotate(0.5f/60, centerX, centerY);
            angle+=0.5f/60;
        }
        drawArrow(0.6f, 15, R.color.colorPrimaryDark);
        for (int i=0; i<min; i++){
            canvas.rotate(6, centerX, centerY);
            angle+=6;
        }
        for (int z=0; z<sec; z++){
            canvas.rotate(0.1f, centerX, centerY);
            angle+=0.1f;
        }
        drawArrow(0.8f, 10, R.color.colorPrimaryDark);
        for (int i=0; i<sec; i++){
            canvas.rotate(6, centerX, centerY);
            angle+=6;
        }
        drawArrow(0.95f, 5, R.color.red);
    }

    private void askTime(){
        Date today = new Date();
        angle = 0;
        SimpleDateFormat timeDate = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        currentTime = timeDate.format(today);
    }

    private void drawArrow(float lenghtPart, int width, int color) {
        myPaint.setStrokeWidth(width);
        myPaint.setColor(ContextCompat.getColor(getContext(), color));
        myPaint.setStyle(Paint.Style.FILL);
        float y=centerY-(rad*lenghtPart);
        canvas.drawLine(centerX, centerY, centerX, y, myPaint);
        canvas.drawCircle(centerX, y, width * 0.9f, myPaint);
        canvas.drawCircle(centerX, centerY, width * 1.5f, myPaint);
        canvas.rotate(360 - angle, centerX, centerY);
        askTime();
    }


}
