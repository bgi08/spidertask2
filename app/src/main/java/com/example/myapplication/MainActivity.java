package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MyCanvas myCanvas;
Button easygame,mediumgame,hardgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easygame=findViewById(R.id.button);
        mediumgame=findViewById(R.id.button2);
        hardgame=findViewById(R.id.button3);



        easygame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas=new MyCanvas(MainActivity.this);
                setContentView(myCanvas);

            }
        });
        mediumgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas=new MyCanvas(MainActivity.this);
                setContentView(myCanvas);


            }
        });
        hardgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas=new MyCanvas(MainActivity.this);
                setContentView(myCanvas);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}