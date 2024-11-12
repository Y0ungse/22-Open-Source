package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class st2_Sub1Activity extends AppCompatActivity {

    private Button st2_btn_back1, st2_btn_hint;
    private Button st2_btn_artTools;
    Button st2_btn_drawing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.st2_sub1);

        if(st2_tryNumber.st2_Sub1_try == 0){
            st2_tryNumber.st2_Sub1_try++;

            st2_gv.is = getResources().openRawResource(R.raw.st2_sub1);
            st2_gv.sc = new Scanner(st2_gv.is, "UTF-8");
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(st2_gv.sc.hasNextLine()) {
                        String storyLine = st2_gv.sc.nextLine();
                        st2_gv.tv.setText(storyLine);
                    }
                    else
                        st2_gv.tv.setVisibility(View.GONE);
                }
            });
        } else {
            st2_gv.tv = (TextView) findViewById(R.id.st2_txt);
            st2_gv.tv.setVisibility(View.GONE);
        }

        st2_btn_drawing = (Button)findViewById(R.id.st2_btn_drawing);
        st2_btn_drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent st2_paint_intent = new Intent(st2_Sub1Activity.this, st2_paint.class);
                startActivity(st2_paint_intent);
            }
        });

        st2_btn_back1 = findViewById(R.id.st2_btn_back1);
        st2_btn_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_Sub1Activity.this, st2_MainActivity.class);
                startActivity(intent); //액티비티 이동
            }
        });

        st2_btn_artTools = findViewById(R.id.st2_btn_artTools);
        st2_btn_artTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(st2_Sub1Activity.this, st2_Sub2Activity.class);
                startActivity(intent); //액티비티 이동
            }
        });

        st2_btn_hint = findViewById(R.id.st2_btn_hint2);
        st2_btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st2_tryNumber.st2_hint1_try++;
                Intent intent = new Intent(st2_Sub1Activity.this, st2_hint1.class);
                startActivity(intent); //액티비티 이동
            }
        });



    }
}