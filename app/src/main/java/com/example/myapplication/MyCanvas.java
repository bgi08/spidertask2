package com.example.myapplication;


import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Vibrator;
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
    int score = 0;
    int highScore = 0;
    int level = 0;
    boolean[][] isOpened = new boolean[8][8];
    boolean[][] isMine = new boolean[8][8];
    RectF[][] cells = new RectF[8][8];
    Paint mine, numbers = new Paint();

    Typeface typeface = Typeface.create("Arial", Typeface.BOLD);
    Canvas canvas1 = new Canvas();

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

        borderpaint.setStyle(Paint.Style.STROKE);
        borderpaint.setColor(Color.BLACK);
        borderpaint.setStrokeWidth(5);
        textpaint.setStrokeWidth(10);
        textpaint.setTypeface(typeface);
        textpaint.setTextSize(80);
        textpaint.setColor(Color.WHITE);
        canvas.drawText("MINESWEEPER", 250, 100, textpaint);
        textpaint.setTextSize(50);

        canvas.drawText("Score : " + score, 100, 200, textpaint);
        canvas.drawText("Mines : " + level * 8,100, 260, textpaint);
        canvas.drawText("High Score : " + highScore, 650, 200, textpaint);

        canvas.drawRect(50, 500, 1050, 1500, borderpaint);
        cellpaint.setColor(Color.GRAY);

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                cells[i][j] = new RectF(width, height, width + 120, height + 120);
                canvas.drawRect(cells[i][j], cellpaint);
                width += 125;
            }
            height += 125;
            width = 50;

        }




    }


    private void init(@Nullable AttributeSet set) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (cells[i][j].contains(touchX, touchY)) {
                    if (isMine[i][j]) {
                        Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();
                        isOpened[i][j] = true;

                        // Vibration
                        Vibrator v = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(300);

                        // Setting score and high score


                    } else {
                        // Increasing Score and marked block as open

                        isOpened[i][j] = true;
                    }
                    invalidate();

                }
            }
        }
        return true;
    }


}
