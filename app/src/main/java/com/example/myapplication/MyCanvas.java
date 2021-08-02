package com.example.myapplication;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.concurrent.ThreadLocalRandom;

public class MyCanvas extends View {
    Paint borderpaint = new Paint();
    Paint textpaint = new Paint();
    Paint cellpaint = new Paint();
    Paint backgroundPaint = new Paint();
    int score=0;
    int highScore=0;
    int level=0;
    boolean[][] isOpened = new boolean[8][8];
    boolean[][] isMine = new boolean[8][8];
    Rect[][] cells = new Rect[8][8];
    Paint mine,numbers= new Paint();

    Typeface typeface = Typeface.create("Arial", Typeface.BOLD);
    Canvas canvas1=new Canvas();
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

        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(Color.BLACK);
        super.onDraw(canvas);
        canvas.drawPaint(backgroundPaint);
        int width = 50;
        int height = 500;


/*
        */
        borderpaint.setStyle(Paint.Style.STROKE);
        borderpaint.setColor(Color.BLACK);
        borderpaint.setStrokeWidth(5);
        textpaint.setStrokeWidth(10);
        textpaint.setTypeface(typeface);
        textpaint.setTextSize(80);
        textpaint.setColor(Color.WHITE);
        canvas.drawText("MINESWEEPER", 250, 100, textpaint);
        textpaint.setTextSize(50);

        canvas.drawText("Score : "+score, 40, 200, textpaint);
        canvas.drawText("Mines : "+level*8, 40,260, textpaint);
        canvas.drawText("High Score : "+highScore, 650, 200, textpaint);

        canvas.drawRect(50, 500, 1050, 1500, borderpaint);
/*        canvas.drawLine(175, 500, 175, 1500, borderpaint);//VERTICAL LINES
        canvas.drawLine(300, 500, 300, 1500, borderpaint);
        canvas.drawLine(425, 500, 425, 1500, borderpaint);
        canvas.drawLine(550, 500, 550, 1500, borderpaint);
        canvas.drawLine(675, 500, 675, 1500, borderpaint);
        canvas.drawLine(800, 500, 800, 1500, borderpaint);
        canvas.drawLine(925, 500, 925, 1500, borderpaint);
        canvas.drawLine(50, 625, 1050, 625, borderpaint);//HORIZONTAL LINES
        canvas.drawLine(50, 750, 1050, 750, borderpaint);
        canvas.drawLine(50, 875, 1050, 875, borderpaint);
        canvas.drawLine(50, 1000, 1050, 1000, borderpaint);
        canvas.drawLine(50, 1125, 1050, 1125, borderpaint);
        canvas.drawLine(50, 1250, 1050, 1250, borderpaint);
        canvas.drawLine(50, 1375, 1050, 1375, borderpaint);*/
        cellpaint.setColor(Color.GRAY);

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                cells[i][j] = new Rect(width, height, width + 120, height + 120);
                 canvas.drawRect(cells[i][j], cellpaint);
                width += 125;
            }
            height += 125;
            width = 50;

        }

        canvas1=canvas;
        placemines();

    }


    private void init(@Nullable AttributeSet set) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        mine.setStrokeWidth(10);
        mine.setColor(Color.RED);
        mine.setStyle(Paint.Style.FILL);
        numbers.setStrokeWidth(10);
        numbers.setColor(Color.GREEN);
        numbers.setStyle(Paint.Style.FILL);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (cells[i][j].contains(touchX, touchY)) {

                    int pos = i * 8 + (j + 1);
                    Toast.makeText(getContext(), "Clicked Rectangle "+pos, Toast.LENGTH_SHORT).show();
                }

            }
        }
        return true;
    }
public void placemines()
{int temp=0;
    for(int i=1;i<=8;i++) {
        for (int j = 0; j < 8; j++) {
            isOpened[i-1][j]=false;
            isMine[i-1][j]=false;
        }
    }
    level=1;
    while(temp<level*8){
        int x = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        int y = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        if(!isMine[x][y]){
            temp++;
            isMine[x][y]=true;
        }
    }
}
}



