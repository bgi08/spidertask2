package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCanvas extends View {
    Paint paint = new Paint();
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Rect rect = new Rect();

    Typeface typeface = Typeface.create("Arial", Typeface.BOLD);

    public MyCanvas(Context context) {
        super(context);
        init(null);
    }

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);



        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint1.setStrokeWidth(10);
        paint1.setTypeface(typeface);
        paint1.setTextSize(80);

        canvas.drawText("MINESWEEPER", 200, 200, paint1);

        canvas.drawRect(50, 500, 1050, 1500, paint);
        canvas.drawLine(175, 500, 175, 1500, paint);//VERTICAL LINES
        canvas.drawLine(300, 500, 300, 1500, paint);
        canvas.drawLine(425, 500, 425, 1500, paint);
        canvas.drawLine(550, 500, 550, 1500, paint);
        canvas.drawLine(675, 500, 675, 1500, paint);
        canvas.drawLine(800, 500, 800, 1500, paint);
        canvas.drawLine(925, 500, 925, 1500, paint);
        canvas.drawLine(50, 625, 1050, 625, paint);//HORIZONTAL LINES
        canvas.drawLine(50, 750, 1050, 750, paint);
        canvas.drawLine(50, 875, 1050, 875, paint);
        canvas.drawLine(50, 1000, 1050, 1000, paint);
        canvas.drawLine(50, 1125, 1050, 1125, paint);
        canvas.drawLine(50, 1250, 1050, 1250, paint);
        canvas.drawLine(50, 1375, 1050, 1375, paint);

        paint2.setColor(Color.GRAY);
        for (int i = 50; i <= 925 ; i += 125) {
            for (int j = 500; j <= 1375; j += 125) {
                rect.left = i;
                rect.top = j;
                rect.bottom = j + 120;
                rect.right = i + 120;
                canvas.drawRect(rect, paint2);
            }
        }

    }






    private void init(@Nullable AttributeSet set)
    {

    }

}
