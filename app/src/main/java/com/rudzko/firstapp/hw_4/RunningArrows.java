package com.rudzko.firstapp.hw_4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.rudzko.firstapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */

public class RunningArrows extends View {

    private Paint myPaint = new Paint();
    private Canvas canvas;
    private float centerX;
    private float centerY;
    private float rad;
    private float angle;
    private String currentTime;

    public RunningArrows(Context context) {
        super(context);
        settings();
    }

    public RunningArrows(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        settings();
    }

    public RunningArrows(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        settings();
    }

    public RunningArrows(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        settings();
    }

    public void settings(){

        myPaint.setAntiAlias(true);
        myPaint.setStyle(Paint.Style.STROKE);
        Date today = new Date();
        SimpleDateFormat timeDate = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        currentTime = timeDate.format(today);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        rad = (Math.min((int) centerX, (int) centerY));
        super.onDraw(canvas);
        this.canvas=canvas;
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

    private void drawArrow(float lenghtPart, int width, int color) {
        myPaint.setStrokeWidth(width);
        myPaint.setColor(ContextCompat.getColor(getContext(), color));
        myPaint.setStyle(Paint.Style.FILL);
        float y=centerY-(rad*lenghtPart);
        canvas.drawLine(centerX, centerY, centerX, y, myPaint);
        canvas.drawCircle(centerX, y, width * 0.9f, myPaint);
        canvas.drawCircle(centerX, centerY, width * 1.5f, myPaint);
        canvas.rotate(360 - angle, centerX, centerY);
        angle=0;
    }

}
