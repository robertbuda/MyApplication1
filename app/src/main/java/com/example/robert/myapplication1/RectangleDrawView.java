package com.example.robert.myapplication1;

import android.bluetooth.BluetoothA2dp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robert on 2018-03-26.
 */

public class RectangleDrawView extends View {

    private Paint paint1;
    private Paint paint1a;
    private Paint paint2;
    private Paint paint2a;
    private Paint paint3;
    private Paint paint3a;

    private Type type = Type.BLUE;

    public RectangleDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint1 = new Paint();
        paint1.setColor(Color.parseColor("#2196F3"));
        paint1a = new Paint();
        paint1a.setColor(Color.parseColor("#BBDEFB"));

        paint2 = new Paint();
        paint2.setColor(Color.parseColor("#FF5722"));
        paint2a = new Paint();
        paint2a.setColor(Color.parseColor("#FFCCBC"));

        paint3 = new Paint();
        paint3.setColor(Color.parseColor("#8BC34A"));
        paint3a = new Paint();
        paint3a.setColor(Color.parseColor("#DCEDC8"));

    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight()*1/3,paint1);
        canvas.drawRect(0,canvas.getHeight()*1/3,canvas.getWidth(),canvas.getHeight()*2/3,paint2);
        canvas.drawRect(0,canvas.getHeight()*2/3,canvas.getWidth(),canvas.getHeight(),paint3);
    }


    private enum Type{
        BLUE,
        RED,
        GREEN,
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getPointerCount() != 1) {
            return false;
        }

        MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
        event.getPointerCoords(0,coords);



        this.invalidate();

        return true;

    }

}
