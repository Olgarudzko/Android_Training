package com.rudzko.firstapp.cw_4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.rudzko.firstapp.R;

import java.util.ArrayList;

/**
 * @author Olga Rudzko
 */

public class MyView extends View {


    private Paint myPaint = new Paint();
    private RectF arcRectF = new RectF();
    private int xStartNow;
    private int yStartNow;
    private int cxNow;
    private int cyNow;
    ArrayList<Line> lines=new ArrayList<>();

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        myPaint.setAntiAlias(true);
        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        myPaint.setStyle(Paint.Style.STROKE);

        Resources r=getResources();
        float strokeWidth= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int radius=Math.min(getWidth(), getHeight())/5;
//        canvas.drawCircle(cx, cy, radius, myPaint);
//
        if (!lines.isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                int startX = lines.get(i).getxStart();
                int startY = lines.get(i).getyStart();
                int stopX = lines.get(i).getCx();
                int stopY = lines.get(i).getCy();
                canvas.drawLine(startX, startY, stopX, stopY, myPaint);
            }
        }
        int first=xStartNow;
        int second=yStartNow;
        int third=cxNow;
        int fourth=cyNow;
        canvas.drawLine(first, second, third, fourth, myPaint);

//
//        arcRectF.left=0;
//        arcRectF.top= 0;
//        arcRectF.right=getWidth();
//        arcRectF.bottom=getHeight();
//        canvas.drawArc(arcRectF, 0, 90, true, myPaint);
//        myPaint.setColor(ContextCompat.getColor(getContext(),R.color.skyblue));
//        myPaint.setStyle(Paint.Style.FILL);
//        canvas.drawRect(50, 50, 100, 100, myPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

       // arcRectF.contains((int)event.getX(), (int)event.getY());
        if (event.getAction()==MotionEvent.ACTION_MOVE){
            cxNow=(int)event.getX();
            cyNow=(int)event.getY();
            invalidate();
        } else if (event.getAction()==MotionEvent.ACTION_UP){
            lines.add(new Line(xStartNow, yStartNow, cxNow, cyNow));
        } else if (event.getAction()==MotionEvent.ACTION_DOWN){
            xStartNow=(int)event.getX();
            yStartNow=(int)event.getY();
        }
        return true;
    }
}
